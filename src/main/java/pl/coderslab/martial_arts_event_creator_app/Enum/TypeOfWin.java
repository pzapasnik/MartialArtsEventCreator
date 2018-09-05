package pl.coderslab.martial_arts_event_creator_app.Enum;

public enum TypeOfWin {
    SUBMISSION("Submission"),
    TECHNICAL_KNOCKOUT("TKO"),
    TECHNICAL_DECISION("Technical Decision"),
    POINTS("Points");

    private String label;

    TypeOfWin (String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
