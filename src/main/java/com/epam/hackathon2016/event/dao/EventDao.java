package com.epam.hackathon2016.event.dao;

import com.epam.hackathon2016.event.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alexander on 10.9.16.
 */
public interface EventDao {
    Event getEventById(int id);
    long createEvent(Event event);
    List<Event> getAllEvents();

    Action getActionById(int id);
    long createAction(Action action);
    List<Action> getAllActions();

    Survey getSurveyById(int id);
    long createSurvey(Survey survey);
    List<Survey> getAllSurveys();

}
