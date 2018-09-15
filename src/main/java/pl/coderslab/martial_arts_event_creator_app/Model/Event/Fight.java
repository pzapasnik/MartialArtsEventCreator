package pl.coderslab.martial_arts_event_creator_app.Model.Event;

import pl.coderslab.martial_arts_event_creator_app.Enum.TypeOfWin;
import pl.coderslab.martial_arts_event_creator_app.Enum.WeightClass;
import pl.coderslab.martial_arts_event_creator_app.Model.User.User;

import javax.persistence.*;

@Entity
@Table(name = "fights")
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Event event;

    @OneToOne
    @JoinColumn(name = "first_fighter_id")
    private User firstFighter;

    @OneToOne
    @JoinColumn(name = "second_fighter_id")
    private User secondFighter;

    private WeightClass weightClass;

    private Long winnersId;

    private boolean draw = false;

    private TypeOfWin typeOfWin;

    public Fight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getFirstFighter() {
        return firstFighter;
    }

    public void setFirstFighter(User firstFighter) {
        this.firstFighter = firstFighter;
    }

    public User getSecondFighter() {
        return secondFighter;
    }

    public void setSecondFighter(User secondFighter) {
        this.secondFighter = secondFighter;
    }

    public WeightClass getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(WeightClass weightClass) {
        this.weightClass = weightClass;
    }

    public Long getWinnersId() {
        return winnersId;
    }

    public void setWinnersId(Long winnersId) {
        this.winnersId = winnersId;
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public TypeOfWin getTypeOfWin() {
        return typeOfWin;
    }

    public void setTypeOfWin(TypeOfWin typeOfWin) {
        this.typeOfWin = typeOfWin;
    }
}
