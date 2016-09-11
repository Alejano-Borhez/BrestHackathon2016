package com.epam.hackathon2016.event.controller;

import com.epam.hackathon2016.event.dao.EventDao;
import com.epam.hackathon2016.event.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

/**
 * Created by alexander on 10.9.16.
 */
@RestController
@RequestMapping("/events")
public class EventController {
    private EventDao dao;
    private ServletContext servletContext;

    @Autowired
    public EventController(EventDao dao, ServletContext servletContext) {
        this.dao = dao;
        this.servletContext = servletContext;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getAllEvents() {
        return dao.getAllEvents();
    }

    @RequestMapping(path = "/{eventId}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable("eventId") int eventId) {
        return dao.getEventById(eventId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    public int createEvent(@RequestParam("date") String date,
                           @RequestParam("budget") double budget,
                           @RequestParam("location") String location,
                           @RequestParam("eventName") String eventName,
                           @RequestParam("eventDescription") String eventDescription,
                           @RequestParam("picture") MultipartFile picture,
                           HttpServletResponse response
    ) throws IOException, ParseException {
        Event event = new Event();

        event.setGroups(Collections.emptyList());
        event.setActions(Collections.emptyList());
        event.setEventDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        event.setBudget(budget);
        event.setLocation(location);
        event.setEventName(eventName);
        event.setEventDescription(eventDescription);

        int eventId = dao.createEvent(event);

        String folder = servletContext.getResource("/img/events").getFile();
        File image = new File(folder + eventId + ".jpg");
        FileCopyUtils.copy(picture.getInputStream(), new FileOutputStream(image));

        response.sendRedirect("index.html");
        return eventId;
    }

    @RequestMapping(name = "/{eventId}/update", method = RequestMethod.PUT)
    public boolean updateEvent(@PathVariable("eventId") int eventId,
                           @RequestParam("date") String date,
                           @RequestParam("budget") double budget,
                           @RequestParam("location") String location,
                           @RequestParam("eventName") String eventName,
                           @RequestParam("eventDescription") String eventDescription,
                           HttpServletResponse response
                           ) throws IOException, ParseException {

        Event event = dao.getEventById(eventId);

        event.setGroups(Collections.emptyList());
        event.setActions(Collections.emptyList());
        event.setEventDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        event.setBudget(budget);
        event.setLocation(location);
        event.setEventName(eventName);
        event.setEventDescription(eventDescription);

        boolean updated = dao.updateEvent(event);
        response.sendRedirect("index.html");
        return updated;
    }
}