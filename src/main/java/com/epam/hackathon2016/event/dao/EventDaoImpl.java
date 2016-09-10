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
                    return event;
        }
        return null;
    }

    @Override
    public int createEvent(Event event) {
        ++lastEventId;
        event.setEventId(lastEventId);
        events.add(event);
        return lastEventId;
    }

    @Override
    public List<Event> getAllEvents() {
        return events;
    }

    @Override
    public Action getActionById(int id) {
        Iterator<Action> iterator= actions.iterator();
        while(iterator.hasNext()) {
            Action action=iterator.next();
            if (action.getActionId() == id)
                return action;
        }
        return null;
    }

    @Override
    public int createAction(Action action) {
        ++lastActionId;
        action.setActionId(lastActionId);
        actions.add(action);
        return lastActionId;
    }

    @Override
    public List<Action> getAllActions() {
        return actions;
    }

    @Override
    public Survey getSurveyById(int id) {
        Iterator<Survey> iterator= surveys.iterator();
        while(iterator.hasNext()) {
            Survey survey=iterator.next();
            if (survey.getSurveyId() == id)
                return survey;
        }
        return null;
    }

    @Override
    public int createSurvey(Survey survey) {
        ++lastSurveyId;
        survey.setSurveyId(lastSurveyId);
        surveys.add(survey);
        return lastSurveyId;
    }


    @Override
    public List<Survey> getAllSurveys() {
        return surveys;
    }
}
