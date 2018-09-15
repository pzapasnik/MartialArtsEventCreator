package pl.coderslab.martial_arts_event_creator_app.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.martial_arts_event_creator_app.Model.Event.Event;
import pl.coderslab.martial_arts_event_creator_app.Enum.Discipline;
import pl.coderslab.martial_arts_event_creator_app.Enum.TypeOfEvent;
import pl.coderslab.martial_arts_event_creator_app.Repository.EventRepository;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @ModelAttribute("events")
    public Collection<Event> getEvents() { return eventRepository.findAll();}

    @ModelAttribute("typesOfEvent")
    public TypeOfEvent[] getEventTypes() { return TypeOfEvent.values();}

    @ModelAttribute("disciplines")
    public Discipline[] getDisciplines() {return Discipline.values();}



    @RequestMapping(value = "/addevent", method = RequestMethod.GET)
    public String createEvent(Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        return "addEvent";
    }

    @RequestMapping(value = "/addevent", method = RequestMethod.POST)
    public String addEvent(@Valid Event event, BindingResult result) {
        if (result.hasErrors()) {
            return "addEvent";
        } else {
            eventRepository.save(event);
            return "redirect:events";
        }
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String listEvents() {
        return "events";
    }

    @RequestMapping(value = "/eventdetails/{eventName}", method = RequestMethod.GET)
    public String showEventDetails(@PathVariable String eventName, Model model){
        model.addAttribute("event",eventRepository.findByName(eventName));
        return "eventdetails";
    }

}
