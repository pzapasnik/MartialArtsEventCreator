package pl.coderslab.martial_arts_event_creator_app.Entity.Event;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.martial_arts_event_creator_app.Entity.User.Fighter;
import pl.coderslab.martial_arts_event_creator_app.Entity.User.Guest;
import pl.coderslab.martial_arts_event_creator_app.Entity.User.Menager;
import pl.coderslab.martial_arts_event_creator_app.Enum.Discipline;
import pl.coderslab.martial_arts_event_creator_app.Enum.TypeOfEvent;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Future
    private Date eventDate;

//    @NotEmpty
//    @Column (nullable = false)
//    private String timeZone;

    @NotEmpty
    @Column(name = "event_name", nullable = false, unique = true)
    private String name;

    @NotEmpty
    @Column (nullable = false)
    private String city;

    @NotEmpty
    @Column( nullable = false)
    private String country;

    @NotEmpty
    @Column( nullable = false)
    private String address;

    private int numberOfTickets;

    private Discipline discipline;

    private TypeOfEvent typeOfEvent;

    @ManyToOne
    private Menager menager;

    @ManyToOne
    private Federation federation;

    @OneToMany (mappedBy = "event")
    private Set<Fight> fights;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "event_guests", joinColumns = { @JoinColumn(name = "event_id") },
            inverseJoinColumns = { @JoinColumn(name = "guest_id" )})
    private Set<Guest> guests;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "events_fighters", joinColumns = { @JoinColumn(name = "event_id") },
            inverseJoinColumns = { @JoinColumn(name = "fighters_id" )})
    private Set<Fighter> fighters;


    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menager getMenager() {
        return menager;
    }

    public void setMenager(Menager menager) {
        this.menager = menager;
    }

    public Federation getFederation() {
        return federation;
    }

    public void setFederation(Federation federation) {
        this.federation = federation;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

//    public String getTimeZone() {
//        return timeZone;
//    }
//
//    public void setTimeZone(String timeZone) {
//        this.timeZone = timeZone;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public Set<Fight> getFights() {
        return fights;
    }

    public void setFights(Set<Fight> fights) {
        this.fights = fights;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public TypeOfEvent getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(TypeOfEvent typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public Set<Guest> getGuests() {
        return guests;
    }

    public void setGuests(Set<Guest> guests) {
        this.guests = guests;
    }

    public Set<Fighter> getFighters() {
        return fighters;
    }

    public void setFighters(Set<Fighter> fighters) {
        this.fighters = fighters;
    }
}
