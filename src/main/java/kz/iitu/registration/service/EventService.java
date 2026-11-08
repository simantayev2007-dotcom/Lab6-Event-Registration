
package kz.iitu.registration.service;

import kz.iitu.registration.model.EventInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    public List<EventInfo> getAllEvents() {
        return List.of(
                new EventInfo(1, "Web Design Workshop", "Room 101"),
                new EventInfo(2, "JavaScript Quiz", "Room 202"),
                new EventInfo(3, "IT Career Talk", "Room 303")
        );
    }

    public String getWelcomeMessage() {
        return "Welcome to the Event Registration API";
    }
}
