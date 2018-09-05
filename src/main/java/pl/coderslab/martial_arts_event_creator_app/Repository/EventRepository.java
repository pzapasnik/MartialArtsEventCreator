package pl.coderslab.martial_arts_event_creator_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.martial_arts_event_creator_app.Entity.Event.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

    Event findByName(String name);
}
