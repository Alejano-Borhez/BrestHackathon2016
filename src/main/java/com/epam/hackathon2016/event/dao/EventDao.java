package com.epam.hackathon2016.event.dao;

import com.epam.hackathon2016.event.domain.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by alexander on 10.9.16.
 */
public interface EventDao {
    Event getEventById(int id);
    int createEvent(ArrayList<Action> actions, Group group, Date date, String place, double budget);
    ArrayList<Event> getAllEvents();

    Action getActionById(int id);
    int createAction(ActionType type, double cost, String desc);
    ArrayList<Action> getAllActions();

    Survey getSurveyById(int id);
    int createSurvey(int eventId);
    ArrayList<Survey> getAllSurveys();
    
}
