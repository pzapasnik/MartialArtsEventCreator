package pl.coderslab.martial_arts_event_creator_app.Enum;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
