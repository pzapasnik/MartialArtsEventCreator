package pl.coderslab.martial_arts_event_creator_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.martial_arts_event_creator_app.Model.User.FighterDetails;
import pl.coderslab.martial_arts_event_creator_app.Model.User.User;

public interface FighterDetailsRepository extends JpaRepository<FighterDetails, Long> {

    FighterDetails findByUser(User user);

}
