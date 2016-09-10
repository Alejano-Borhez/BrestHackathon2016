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

    private static long lastEventId = 0;
    private static long lastActionId = 0;
    private static long lastSurveyId = 0;


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
    public long createEvent(List<Action> actions, List<Group> groups, Date date, String location, double budget) {
        ++lastEventId;
        Event event=new Event();
        event.setActions(actions);
        event.setGroups(groups);
        event.setEventDate(date);
        event.setLocation(location);
        event.setBudget(budget);

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
    public int createAction(ActionType type, double cost, String desc) {
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
    public int createSurvey(int eventId) {
        return 0;
    }

    @Override
    public ArrayList<Survey> getAllSurveys() {
        return null;
    }
}
