package jay.springbootadmintrainingjournal;

import jay.springbootadmintrainingjournal.Event.Model.Event;
import jay.springbootadmintrainingjournal.Event.Repository.EventRepository;
import jay.springbootadmintrainingjournal.Event.Service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEvents() {
        // Arrange: Gumawa ng mock data na may lahat ng required fields
        Event event = new Event();
        event.setId(1L);
        event.setName("Mock Event");
        event.setLocation("Mock Location");
        event.setDate("2024-12-30");
        event.setTime("10:00 AM");
        event.setDescription("Mock Description");


        // I-configure ang mock repository upang magbalik ng mock data
        when(eventRepository.findAll()).thenReturn(Arrays.asList(event));


        // Act: Tumawag sa service method
        Iterable<Event> retrievedEvents = eventService.getAllEvents();

        // Assert: Siguraduhing tama ang resulta
        assertThat(retrievedEvents).isNotNull();
        assertThat(retrievedEvents).hasSize(1);

        Event retrievedEvent = retrievedEvents.iterator().next();
        assertThat(retrievedEvent.getId()).isEqualTo(1L);
        assertThat(retrievedEvent.getName()).isEqualTo("Mock Event");
        assertThat(retrievedEvent.getLocation()).isEqualTo("Mock Location");
        assertThat(retrievedEvent.getDate()).isEqualTo("2024-12-30");
        assertThat(retrievedEvent.getTime()).isEqualTo("10:00 AM");
        assertThat(retrievedEvent.getDescription()).isEqualTo("Mock Description");

        System.out.println("Test completed successfully");
    }
}
