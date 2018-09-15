package pl.coderslab.martial_arts_event_creator_app.Enum;

public enum WeightClass {
    MMA_STAWWEIGHT("MMA - STAWWEIGHT - 52.2 kg"),
    MMA_FLYWEIGHT("MMA - FLYWEIGHT - 56.7 kg"),
    MMA_BANTAMWEIGHT("MMA - BANTAMWEIGHT - 61.2 kg"),
    MMA_FEATHERWEIGHT("MMA - FEATHERWEIGHT - 65.8 kg"),
    MMA_LIGHTWEIGHT( "MMA - LIGHTWEIGHT - 70.3 kg"),
    MMA_WELTERWEIGHT("MMA - WELTERWEIGHT - 77.1 kg"),
    MMA_MIDDLEWEIGHT("MMA - MIDDLEWEIGHT - 83.9 kg"),
    MMA_LIGHT_HEAVYWEIGHT("MMA - LIGHT HEAVYWEIGHT - 93.0 kg"),
    MMA_HEAVYWEIGHT("MMA - HEAVYWEIGHT - 120.2 kg"),

    KICKBOXING_BANTAMWEIGHT("K-1 - BANTAMWEIGHT - 55 kg"),
    KICKBOXING_FEATHERWEIGHT("K-1 - FEATHERWEIGHT - 65 kg"),
    KICKBOXING_LIGHTWEIGHT("K-1 - LIGHTWEIGHT - 70 kg"),
    KICKBOXING_WELTERWEIGHT("K-1 - WELTERWEIGHT - 77 kg"),
    KICKBOXING_MIDDLEWEIGHT("K-1 - MIDDLEWEIGHT - 85 kg"),
    KICKBOXING_LIGHT_HEAVYWEIGHT("K-1 - LIGHT HEAVYWEIGHT - 95 kg"),
    KICKBOXING_HEAVYWEIGHT("K-1 - HEAVYWEIGHT - UNLIMITED");




    String label;

    WeightClass( String label) {
        this.label = label;
    }
}