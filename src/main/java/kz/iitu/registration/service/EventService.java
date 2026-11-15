
package kz.iitu.registration.service;

import kz.iitu.registration.model.EventInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final List<EventInfo> events = new ArrayList<>();

    private int nextId = 4;

    public EventService() {
        events.add(new EventInfo(1, "Web Design Workshop", "Room 101"));
        events.add(new EventInfo(2, "JavaScript Quiz", "Room 202"));
        events.add(new EventInfo(3, "IT Career Talk", "Room 303"));
    }

    public List<EventInfo> getAllEvents() {
        return events;
    }

    public EventInfo getEventById(int id) {
        for (EventInfo event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }

    public List<EventInfo> searchEvents(String title) {
        List<EventInfo> result = new ArrayList<>();

        for (EventInfo event : events) {
            if (event.getTitle().toLowerCase()
                    .contains(title.toLowerCase())) {
                result.add(event);
            }
        }

        return result;
    }

    public EventInfo addEvent(String title, String location) {
        EventInfo event = new EventInfo(nextId, title, location);
        nextId++;

        events.add(event);

        return event;
    }

    public EventInfo updateEvent(int id, String title, String location) {
        EventInfo event = getEventById(id);

        if (event == null) {
            return null;
        }

        event.setTitle(title);
        event.setLocation(location);

        return event;
    }

    public boolean deleteEvent(int id) {
        EventInfo event = getEventById(id);

        if (event == null) {
            return false;
        }

        events.remove(event);
        return true;
    }

    public String getWelcomeMessage() {
        return "Welcome to the Event Registration API";
    }
}
