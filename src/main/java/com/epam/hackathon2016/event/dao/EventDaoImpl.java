package com.epam.hackathon2016.event.dao;

import com.epam.hackathon2016.event.domain.*;

import java.util.*;

/**
 * Created by asavitsky on 9/10/16.
 */
public class EventDaoImpl implements EventDao{

    List<Event> events;
    List<Action> actions;
    List<Survey> surveys;
    List<Group> groups;

    private static int lastEventId = 0;
    private static int lastActionId = 0;
    private static int lastSurveyId = 0;
    private static int lastGroupId = 0;

    public EventDaoImpl() {
        actions = new ArrayList<>();

        Action action1=new Action();
        action1.setType(ActionType.BBQ);
        action1.setActionDescription("This Barbeque Baby!");
        action1.setActionRating(0);
        action1.setCostPerUser(100);
        createAction(action1);

        Action action2=new Action();
        action2.setType(ActionType.PIZZA);
        action2.setActionDescription("Wanna Pizza?");
        action2.setActionRating(0);
        action2.setCostPerUser(50);
        createAction(action2);

        Action action3=new Action();
        action3.setType(ActionType.BILLIARD);
        action3.setActionDescription("Lets play!");
        action3.setActionRating(0);
        action3.setCostPerUser(80);
        createAction(action3);

        User user1 = new User();
        user1.setName("Alexander Borohov");
        user1.setGroupId(1);
        ArrayList<Action> favActionsForUser1 = new ArrayList<>(Arrays.asList(new Action[]{action1, action2}));
        user1.setFavourite(favActionsForUser1);

        User user2 = new User();
        user2.setName("Andrei Mushinsky");
        user2.setGroupId(1);
        ArrayList<Action> favActionsForUser2 = new ArrayList<>(Arrays.asList(new Action[]{action2, action3}));
        user2.setFavourite(favActionsForUser2);

        Group group = new Group();
        group.setGroupId(1);
        lastGroupId = 1;
        ArrayList<User> usersGroup1 = new ArrayList<>(Arrays.asList(new User[]{user1, user2}));
        group.setUserList(usersGroup1);
        createGroup(group);


        Event event1 = new Event();
        event1.setBudget(1000);
        event1.setLocation("Brest, Belarus");
        event1.setActions(favActionsForUser1);
        event1.setEventDate(new Date());
        event1.setEventDescription("The Hottest party ever!");
        event1.setEventName("Summer Party");
        event1.setEventRating(0);
        event1.setGroups(Arrays.asList(new Group[]{group}));
        events = new ArrayList<>();
        createEvent(event1);
    }

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
    public boolean updateEvent(Event event) {
        get
        return false;
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
    public boolean updateAction(Action action) {
        return false;
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

    @Override
    public boolean updateSurvey(Survey survey) {
        return false;
    }

    @Override
    public Group getGroupById(int id) {
        Iterator<Group> iterator= groups.iterator();
        while(iterator.hasNext()) {
            Group group=iterator.next();
            if (group.getGroupId() == id)
                return group;
        }
        return null;
    }

    @Override
    public int createGroup(Group group) {
        ++lastGroupId;
        group.setGroupId(lastGroupId);
        groups.add(group);
        return lastGroupId;
    }

    @Override
    public List<Group> getAllGroups() {
        return groups;
    }

}
