package pl.coderslab.martial_arts_event_creator_app.Enum;

public enum Discipline {
    MIXED_MARCIAL_ARTS("Mixed Marcial Arts"),
    BRAZYLIAN_JUJITSU("Brazilian Jiu-Jitsu"),
    NO_GI("Subbmision No Gi"),
    KICKBOXING("Kickboxing - K1"),
    BOX("Box");

    String label;

    Discipline(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
