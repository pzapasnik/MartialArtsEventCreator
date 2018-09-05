package pl.coderslab.martial_arts_event_creator_app.Repository;

import org.hibernate.boot.model.source.spi.JpaCallbackSource;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.martial_arts_event_creator_app.Entity.User.Menager;

public interface MenagerRepository extends JpaRepository<Menager, Long> {

    Menager findByEmail(String email);
}
