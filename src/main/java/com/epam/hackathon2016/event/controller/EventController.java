package com.epam.hackathon2016.event.controller;

import com.epam.hackathon2016.event.dao.EventDao;
import com.epam.hackathon2016.event.domain.Action;
import com.epam.hackathon2016.event.domain.Event;
import com.epam.hackathon2016.event.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alexander on 10.9.16.
 */
@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventDao dao;

    @RequestMapping("")
    public List<Event> getAllEvents() {
        return dao.getAllEvents();
    }

    @RequestMapping("/{eventId}")
    public Event getEventById(@PathVariable("eventId") int eventId) {
        return dao.getEventById(eventId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int createEvent(@RequestParam("date") String date,
                           @RequestParam("budget") double budget,
                           @RequestParam("location") String location,
                           @RequestParam("eventName") String eventName,
                           @RequestParam("eventDescription") String eventDescription
                           /*@RequestParam("picture") MultipartFile file*/)
            throws IOException, ParseException {
        Event event = new Event();

        event.setGroups(Collections.emptyList());
        event.setActions(Collections.emptyList());
        event.setEventDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        event.setBudget(budget);
        event.setLocation(location);
        event.setEventName(eventName);
        event.setEventDescription(eventDescription);

        int eventId = dao.createEvent(event);
        File bodyToSave = new File("/img/events" + eventId + ".jpg");
        //file.transferTo(bodyToSave);
        return eventId;
    }






}
