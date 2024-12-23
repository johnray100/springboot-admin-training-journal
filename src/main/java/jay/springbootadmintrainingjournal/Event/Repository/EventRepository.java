package jay.springbootadmintrainingjournal.Event.Repository;

import jay.springbootadmintrainingjournal.Event.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
