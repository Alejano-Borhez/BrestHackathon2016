package com.epam.hackathon2016.event.dao;

import com.epam.hackathon2016.event.domain.Event;

import java.util.ArrayList;

/**
 * Created by alexander on 10.9.16.
 */
public interface EventDao {
    Event getEvent(int id);
    ArrayList<Event> events();
    
}
