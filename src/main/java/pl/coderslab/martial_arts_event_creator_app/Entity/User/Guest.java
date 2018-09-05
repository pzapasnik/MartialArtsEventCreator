package pl.coderslab.martial_arts_event_creator_app.Entity.User;

import pl.coderslab.martial_arts_event_creator_app.Entity.Event.Event;
import pl.coderslab.martial_arts_event_creator_app.Entity.Event.Ticket;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "guests")
public class Guest extends User {

    @ManyToMany(mappedBy = "guests")
    private Set<Event> events;

    public Guest() {
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
