package pl.coderslab.martial_arts_event_creator_app.Enum;

public enum TypeOfPayment {
    TRANSFER("Card Transfer"),
    CASH("Cash Desk");

    private String label;

    TypeOfPayment(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
