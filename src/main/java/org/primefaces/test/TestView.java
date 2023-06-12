package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;
    private List<TestObject> list;

    /** Locales get */
    public List<Locale> getLocales(){
        List<Locale> localeList = new ArrayList<>();
        FacesContext fc = FacesContext.getCurrentInstance();
        if (fc != null) {
            Application app = fc.getApplication();
            Iterator it = app.getSupportedLocales();
            while (it.hasNext()) {
                localeList.add((Locale)it.next());
            }
        }
        return localeList;
    }

    /** Locale get */
    public Locale getLocale(){
        FacesContext fc = FacesContext.getCurrentInstance();
        return fc != null ? fc.getViewRoot().getLocale() : null;
    }
    /** Locale set */
    public void setLocale(Locale locale){
        FacesContext fc = FacesContext.getCurrentInstance();
        if (fc != null) {
            fc.getViewRoot().setLocale(locale);
        }
    }

    /** datePickerValue */
    private Date datePickerValue;
    public Date getDatePickerValue() {
        return this.datePickerValue;
    }
    public void setDatePickerValue(Date datePickerValue) {
        this.datePickerValue = datePickerValue;
    }

    @PostConstruct
    public void init() {
        string = "Welcome to PrimeFaces!!!";
        list = new ArrayList<>(Arrays.asList(
                new TestObject("Thriller", "Michael Jackson", 1982),
                new TestObject("Back in Black", "AC/DC", 1980),
                new TestObject("The Bodyguard", "Whitney Houston", 1992),
                new TestObject("The Dark Side of the Moon", "Pink Floyd", 1973)
        ));
    }
}
