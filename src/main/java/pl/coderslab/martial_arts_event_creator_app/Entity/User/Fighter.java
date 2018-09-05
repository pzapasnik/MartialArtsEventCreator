package pl.coderslab.martial_arts_event_creator_app.Entity.User;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.martial_arts_event_creator_app.Entity.Event.Event;
import pl.coderslab.martial_arts_event_creator_app.Entity.Event.Category;
import pl.coderslab.martial_arts_event_creator_app.Enum.Discipline;
import pl.coderslab.martial_arts_event_creator_app.Enum.Gender;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.Set;

@Entity
@Table (name = "fighters")
public class Fighter extends User {

    @NotEmpty
    @Column(nullable = false)
    private Double weight;

    @NotEmpty
    @Column(nullable = false)
    private Double hight;

    @NotEmpty
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date yearOfBirth;

    private Gender gender;

    private Discipline discipline;

    private String team;

    private String amatureFightsScore;
    private String profesionalFightsScore;


    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "fighters")
    private Set<Event> events;

    public Fighter() {
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHight() {
        return hight;
    }

    public void setHight(Double hight) {
        this.hight = hight;
    }

    public Date getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Date yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getAmatureFightsScore() {
        return amatureFightsScore;
    }

    public void setAmatureFightsScore(String amatureFightsScore) {
        this.amatureFightsScore = amatureFightsScore;
    }

    public String getProfesionalFightsScore() {
        return profesionalFightsScore;
    }

    public void setProfesionalFightsScore(String profesionalFightsScore) {
        this.profesionalFightsScore = profesionalFightsScore;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
