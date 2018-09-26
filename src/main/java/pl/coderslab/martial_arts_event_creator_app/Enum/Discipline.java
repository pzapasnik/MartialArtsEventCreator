package pl.coderslab.martial_arts_event_creator_app.Enum;

public enum Discipline {
    MIXED_MARCIAL_ARTS("Mixed Martial Arts"),
    KICKBOXING("Kickboxing - K1");
//    BRAZYLIAN_JUJITSU("Brazilian Jiu-Jitsu"),
//    NO_GI("Subbmision No Gi"),
//    BOX("Box");

    String label;

    Discipline(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
