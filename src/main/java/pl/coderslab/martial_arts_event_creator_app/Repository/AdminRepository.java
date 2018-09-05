package pl.coderslab.martial_arts_event_creator_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.martial_arts_event_creator_app.Entity.User.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
