package com.epam.hackathon2016.event.dao;

import com.epam.hackathon2016.event.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by asavitsky on 9/10/16.
 */
public class EventDaoImpl implements EventDao{

    List<Event> events;
    List<Action> actions;
    List<Survey> surveys;

    private static int lastEventId = 0;
    private static int lastActionId = 0;
    private static int lastSurveyId = 0;


    @Override
    public Event getEventById(int id) {
        Iterator<Event> iterator= events.iterator();
        while(iterator.hasNext()) {
            Event event=iterator.next();
                if (event.getEventId() == id)
                    return
        }

        return null;
    }

    @Override
    public int createEvent(Event event) {
        ++lastEventId;
        event.setEventId();
        return lastEventId;
    }

    @Override
    public List<Event> getAllEvents() {
        return events;
    }

    @Override
    public Action getActionById(int id) {
        return null;
    }

    @Override
    public int createAction(Action action) {
        return 0;
    }

    @Override
    public ArrayList<Action> getAllActions() {
        return null;
    }

    @Override
    public Survey getSurveyById(int id) {
        return null;
    }

    @Override
    public int createSurvey(Survey survey) {
        return 0;
    }


    @Override
    public ArrayList<Survey> getAllSurveys() {
        return null;
    }
}
