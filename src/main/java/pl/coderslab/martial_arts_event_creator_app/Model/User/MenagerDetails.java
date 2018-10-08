package pl.coderslab.martial_arts_event_creator_app.Model.User;

import pl.coderslab.martial_arts_event_creator_app.Model.Event.Event;
import pl.coderslab.martial_arts_event_creator_app.Model.User.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MenagerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column (name = "organization_name")
    private String organizationName;

    @OneToMany(mappedBy = "menagerDetails")
    private Set<Event> events;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User menager;

    public MenagerDetails() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
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
