package pl.coderslab.martial_arts_event_creator_app.Entity.Event;

import pl.coderslab.martial_arts_event_creator_app.Entity.User.Fighter;
import pl.coderslab.martial_arts_event_creator_app.Enum.TypeOfWin;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne (mappedBy = "score")
    private Fight fight;

    @OneToOne
    @JoinColumn(name = "winer")
    private Fighter winer;

    private boolean draw = false;

    private TypeOfWin typeOfWin;


    public Score() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fight getFight() {
        return fight;
    }

    public void setFight(Fight fight) {
        this.fight = fight;
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

    public Fighter getWiner() {
        return winer;
    }

    public void setWiner(Fighter winer) {
        this.winer = winer;
    }
}
