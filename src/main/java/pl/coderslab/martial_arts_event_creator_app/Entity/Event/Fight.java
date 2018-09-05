package pl.coderslab.martial_arts_event_creator_app.Entity.Event;

import pl.coderslab.martial_arts_event_creator_app.Entity.User.Fighter;
import pl.coderslab.martial_arts_event_creator_app.Enum.TypeOfWin;

import javax.persistence.*;
import java.util.HashSet;

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
    private Fighter firstFighter;

    @OneToOne
    @JoinColumn(name = "second_fighter_id")
    private Fighter secondFighter;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "fight_score")
    private Score score;

    @ManyToOne
    private Category category;

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

    public Fighter getFirstFighter() {
        return firstFighter;
    }

    public void setFirstFighter(Fighter firstFighter) {
        this.firstFighter = firstFighter;
    }

    public Fighter getSecondFighter() {
        return secondFighter;
    }

    public void setSecondFighter(Fighter secondFighter) {
        this.secondFighter = secondFighter;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
