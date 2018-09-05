package pl.coderslab.martial_arts_event_creator_app.Enum;

import org.springframework.context.annotation.Bean;

public enum TypeOfEvent {
    AMATURE("Amature"),
    PROFESIONAL("Profesional");

    private String label;

    TypeOfEvent (String label) {
        this.label = label;
    }


    public String getLabel() {
        return label;
    }

}
