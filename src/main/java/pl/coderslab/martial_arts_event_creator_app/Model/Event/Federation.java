package pl.coderslab.martial_arts_event_creator_app.Model.Event;

import pl.coderslab.martial_arts_event_creator_app.Model.User.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Federation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column (name = "federation_name")
    private String name;

    @OneToMany(mappedBy = "federation")
    private Set<Event> events;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User menager;

    public Federation() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }


    public User getMenager() {
        return menager;
    }

    public void setMenager(User menager) {
        this.menager = menager;
    }
}
