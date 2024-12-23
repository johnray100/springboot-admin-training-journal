package jay.springbootadmintrainingjournal.Event.Service;

import jay.springbootadmintrainingjournal.Event.Model.Event;
import jay.springbootadmintrainingjournal.Event.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    /*LIST*/
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    /*SAVE*/
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    /*GET BY ID*/
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    /*DELETE BY ID*/
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
