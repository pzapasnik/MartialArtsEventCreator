package pl.coderslab.martial_arts_event_creator_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.martial_arts_event_creator_app.Entity.Event.Fight;
import pl.coderslab.martial_arts_event_creator_app.Entity.User.Fighter;

public interface FighterRepository extends JpaRepository<Fighter, Long> {

    Fighter findByEmail(String email);
}
