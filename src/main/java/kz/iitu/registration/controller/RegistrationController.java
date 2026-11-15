
package kz.iitu.registration.controller;

import kz.iitu.registration.model.EventInfo;
import kz.iitu.registration.service.EventService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final EventService eventService;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${app.course}")
    private String course;

    @Value("${app.semester}")
    private int semester;

    public RegistrationController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", eventService.getWelcomeMessage());
    }

    @GetMapping("/info")
    public Map<String, Object> getInfo() {
        return Map.of(
                "applicationName", applicationName,
                "course", course,
                "semester", semester
        );
    }

    @GetMapping("/events")
    public List<EventInfo> getAllEvents(
            @RequestParam(required = false) String title) {

        if (title != null) {
            return eventService.searchEvents(title);
        }

        return eventService.getAllEvents();
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<EventInfo> getEventById(
            @PathVariable int id) {

        EventInfo event = eventService.getEventById(id);

        if (event == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(event);
    }

    @PostMapping("/events")
    public ResponseEntity<EventInfo> addEvent(
            @RequestBody(required = false) EventInfo event) {

        if (event == null ||
                event.getTitle() == null ||
                event.getTitle().isBlank() ||
                event.getLocation() == null ||
                event.getLocation().isBlank()) {

            return ResponseEntity.badRequest().build();
        }

        EventInfo newEvent = eventService.addEvent(
                event.getTitle(),
                event.getLocation()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(newEvent);
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<EventInfo> updateEvent(
            @PathVariable int id,
            @RequestBody(required = false) EventInfo event) {

        if (event == null ||
                event.getTitle() == null ||
                event.getTitle().isBlank() ||
                event.getLocation() == null ||
                event.getLocation().isBlank()) {

            return ResponseEntity.badRequest().build();
        }

        EventInfo updatedEvent = eventService.updateEvent(
                id,
                event.getTitle(),
                event.getLocation()
        );

        if (updatedEvent == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Void> deleteEvent(
            @PathVariable int id) {

        boolean deleted = eventService.deleteEvent(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
