package com.epam.hackathon2016.event.controller;

import com.epam.hackathon2016.event.dao.EventDao;
import com.epam.hackathon2016.event.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alexander on 10.9.16.
 */
@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventDao dao;

    @RequestMapping("/all")
    public List<Event> getAllEvents() {
        return dao.getAllEvents();
    }

    @RequestMapping("/{eventId}")
    public Event getEventById(@PathVariable("eventId") int eventId) {
        return dao.getEventById(eventId);
    }

    @RequestMapping(name = "/create", method = RequestMethod.POST)
    public int createEvent(@ModelAttribute Event event) {
        return dao.createEvent(event);
    }






}
