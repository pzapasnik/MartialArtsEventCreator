package pl.coderslab.martial_arts_event_creator_app.Entity.User;

import pl.coderslab.martial_arts_event_creator_app.Entity.Event.Event;
import pl.coderslab.martial_arts_event_creator_app.Entity.Event.Federation;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menagers")
public class Menager extends User {

    @OneToMany(mappedBy = "menager")
    private Set<Event> Events;

    @OneToOne
    private Federation federation;

    public Menager() {
    }

    public Set<Event> getEvents() {
        return Events;
    }

    public void setEvents(Set<Event> events) {
        Events = events;
    }
}
