package org.primefaces.locale;

import java.util.Locale;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class LocaleConverter implements Converter<Object> {
    public Object getAsObject(FacesContext fc, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        value = value.trim();
        return value.isEmpty() ? null : Locale.forLanguageTag(value);
    }

    public String getAsString(FacesContext fc, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        return value instanceof String ? (String) value : ((Locale) value).toLanguageTag();
    }
}