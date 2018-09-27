package pl.coderslab.martial_arts_event_creator_app.Model.User;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.martial_arts_event_creator_app.Enum.Discipline;
import pl.coderslab.martial_arts_event_creator_app.Enum.Gender;
import pl.coderslab.martial_arts_event_creator_app.Enum.WeightClass;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "fighter_details")
public class FighterDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Digits(integer = 5, fraction = 2)
    @Column(nullable = false)
    private BigDecimal weight;

    @Digits(integer = 3, fraction = 2)
    @Column(nullable = false)
    private BigDecimal hight;

    @NotNull
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date yearOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Discipline discipline;

    @Enumerated(EnumType.STRING)
    private WeightClass weightClass;

    private String team;

    private String amatureFightsScore;

    private String profesionalFightsScore;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



    public FighterDetails() {
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getHight() {
        return hight;
    }

    public void setHight(BigDecimal hight) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WeightClass getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(WeightClass weightClass) {
        this.weightClass = weightClass;
    }
}
