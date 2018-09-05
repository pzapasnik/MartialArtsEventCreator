package pl.coderslab.martial_arts_event_creator_app.Entity.Event;

import pl.coderslab.martial_arts_event_creator_app.Entity.Event.Event;
import pl.coderslab.martial_arts_event_creator_app.Entity.User.Menager;
import pl.coderslab.martial_arts_event_creator_app.Enum.Discipline;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Federation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column (name = "feceration_name")
    private String name;

    @OneToMany(mappedBy = "federation", cascade = CascadeType.ALL)
    private Set<Event> events;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Set<Category> categories;

    @OneToOne(cascade = CascadeType.ALL)
    private Menager menager;

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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
