package pl.coderslab.martial_arts_event_creator_app.Model.Event;

import pl.coderslab.martial_arts_event_creator_app.Enum.Discipline;
import pl.coderslab.martial_arts_event_creator_app.Enum.TypeOfEvent;
import pl.coderslab.martial_arts_event_creator_app.Model.User.User;

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

    private double ticketPrice;

    private Discipline discipline;

    private TypeOfEvent typeOfEvent;


    @ManyToOne
    private Federation federation;

    @OneToMany (mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Fight> fights;

    @ManyToMany(mappedBy = "events")
    private Set<User> guests;


    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Set<User> getGuests() {
        return guests;
    }

    public void setGuests(Set<User> guests) {
        this.guests = guests;
    }
}
