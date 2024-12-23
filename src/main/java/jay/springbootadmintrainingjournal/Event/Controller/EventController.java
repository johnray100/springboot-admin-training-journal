package jay.springbootadmintrainingjournal.Event.Controller;

import jay.springbootadmintrainingjournal.Event.Model.Event;
import jay.springbootadmintrainingjournal.Event.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "views/backend/event/index";
    }

    @GetMapping("/error400")
    public String errorPage() {
        return "views/backend/event/error-page";
    }

    @GetMapping("/create")
    public String createEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "views/backend/event/create";
    }

    @PostMapping("/save")
    public String saveEvent(@ModelAttribute("event") Event event, RedirectAttributes redirectAttributes) {
        eventService.saveEvent(event);
        redirectAttributes.addFlashAttribute("success", "Event saved successfully!");
        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    public String editEventForm(@PathVariable Long id, Model model) {
        model.addAttribute("event", eventService.getEventById(id).orElseThrow());
        return "views/backend/event/edit";
    }

    @PostMapping("/update")
    public String updateEvent(@ModelAttribute("event") Event event, RedirectAttributes redirectAttributes) {
        eventService.saveEvent(event);
        redirectAttributes.addFlashAttribute("success", "Event updated successfully!");
        return "redirect:/events";
    }

    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        try {
            eventService.deleteEvent(id);
            return "redirect:/events"; // Redirect to the event list page
        } catch (Exception e) {
            // Handle error
            return "views/backend/event/error-page";
        }
    }
}
