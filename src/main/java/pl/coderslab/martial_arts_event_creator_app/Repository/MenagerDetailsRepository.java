package pl.coderslab.martial_arts_event_creator_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.martial_arts_event_creator_app.Model.User.MenagerDetails;
import pl.coderslab.martial_arts_event_creator_app.Model.User.User;

public interface MenagerDetailsRepository extends JpaRepository <MenagerDetails, Long> {

    MenagerDetails findByMenager (User user);
}
