package pl.coderslab.martial_arts_event_creator_app.Entity.Event;

import pl.coderslab.martial_arts_event_creator_app.Entity.User.Fighter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Column(nullable = false)
    private Double minilWeight;

    @NotEmpty
    @Column(nullable = false)
    private Double maxWeight;


    @OneToMany( mappedBy = "category")
    private Set<Fighter> fighters;



    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMinilWeight() {
        return minilWeight;
    }

    public void setMinilWeight(Double minilWeight) {
        this.minilWeight = minilWeight;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }


    public Set<Fighter> getFighters() {
        return fighters;
    }

    public void setFighters(Set<Fighter> fighters) {
        this.fighters = fighters;
    }


}
