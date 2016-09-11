package com.epam.hackathon2016.event.dao;

import com.epam.hackathon2016.event.domain.*;

import java.util.List;

/**
 * Created by alexander on 10.9.16.
 */
public interface EventDao {
    Event getEventById(int id);
    int createEvent(Event event);
    List<Event> getAllEvents();
    boolean updateEvent(Event event);

    Action getActionById(int id);
    int createAction(Action action);
    List<Action> getAllActions();
    boolean updateAction(Action action);

    Survey getSurveyById(int id);
    int createSurvey(Survey survey);
    List<Survey> getAllSurveys();


    Group getGroupById(int id);
    int createGroup(Group group);
    List<Group> getAllGroups();

    User getUserById(int userId);
    int createUser(User user);
    List<User> getAllUsers();
    void updateUser(User user);
}
