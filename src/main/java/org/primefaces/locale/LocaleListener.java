package org.primefaces.locale;

import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LocaleListener implements PhaseListener {
    private static final long serialVersionUID = 1L;

    public void beforePhase(PhaseEvent event) {
    }

    public void afterPhase(PhaseEvent event) {
    }

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}