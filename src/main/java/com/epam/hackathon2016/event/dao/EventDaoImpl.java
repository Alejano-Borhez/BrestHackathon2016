package com.epam.hackathon2016.event.dao;

import com.epam.hackathon2016.event.domain.*;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by asavitsky on 9/10/16.
 */
@Repository
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
        groups = new ArrayList<>();
        events = new ArrayList<>();

        Action action1=new Action();
        action1.setActionName("Barbecue");
        action1.setActionDescription("This is Barbecue Baby!");
        action1.setActionRating(10);
        action1.setCostPerUser(100);
        createAction(action1);

        Action action2=new Action();
        action2.setActionName("Pizza");
        action2.setActionDescription("Wanna Pizza?");
        action2.setActionRating(14);
        action2.setCostPerUser(50);
        createAction(action2);

        Action action3=new Action();
        action3.setActionName("Billiard");
        action3.setActionDescription("Lets play!");
        action3.setActionRating(3);
        action3.setCostPerUser(80);
        createAction(action3);

        Action action4=new Action();
        action4.setActionName("Poker");
        action4.setActionDescription("Bring your money man!");
        action4.setActionRating(4);
        action4.setCostPerUser(20);
        createAction(action4);

        Action action5=new Action();
        action5.setActionName("Boating");
        action5.setActionDescription("Swimming? Cool!");
        action5.setActionRating(3);
        action5.setCostPerUser(10);
        createAction(action5);

        Action action6=new Action();
        action6.setActionName("Sauna");
        action6.setActionDescription("Take a towel and be ready to get sweat!");
        action6.setActionRating(7);
        action6.setCostPerUser(50);
        createAction(action6);

        User user1 = new User();
        user1.setName("Alexander Borohov");
        user1.setEmail("alexander.borohov17@gmail.com");
        user1.setGroupId(1);
        ArrayList<Action> favActionsForUser1 = new ArrayList<>(Arrays.asList(new Action[]{action1, action2}));
        user1.setFavourite(favActionsForUser1);

        User user2 = new User();
        user2.setName("Andrei Mushinsky");
        user2.setEmail("alexander.borohov17@gmail.com");
        user2.setGroupId(1);
        ArrayList<Action> favActionsForUser2 = new ArrayList<>(Arrays.asList(new Action[]{action2, action3, action6}));
        user2.setFavourite(favActionsForUser2);

        User user3 = new User();
        user3.setName("Anton Savitsky");
        user3.setEmail("anton.savitsky.1995@gmail.com");
        user3.setGroupId(2);
        ArrayList<Action> favActionsForUser3 = new ArrayList<>(Arrays.asList(new Action[]{action4, action5}));
        user3.setFavourite(favActionsForUser3);

        User user4 = new User();
        user4.setName("Vasily Bur");
        user4.setEmail("alexander.borohov17@gmail.com");
        user4.setGroupId(2);
        ArrayList<Action> favActionsForUser4 = new ArrayList<>(Arrays.asList(new Action[]{action2, action3, action5, action6}));
        user4.setFavourite(favActionsForUser4);

        Group group1 = new Group();
        group1.setGroupId(1);
        group1.setGroupName("Java Team");
        lastGroupId = 1;
        ArrayList<User> usersGroup1 = new ArrayList<>(Arrays.asList(new User[]{user1, user2}));
        group1.setUserList(usersGroup1);
        groups.add(group1);

        Group group2 = new Group();
        group2.setGroupId(2);
        group2.setGroupName(".NET Team");
        lastGroupId = 2;
        ArrayList<User> usersGroup2 = new ArrayList<>(Arrays.asList(new User[]{user3, user4}));
        group2.setUserList(usersGroup2);
        groups.add(group2);

        Event event1 = new Event();
        event1.setBudget(1000);
        event1.setLocation("Brest, Belarus");
        event1.setActions(favActionsForUser1);
        event1.setEventDate(stringToDate("07/08/2016"));
        event1.setEventDescription("The Hottest party ever!");
        event1.setEventName("Summer Party");
        event1.setEventRating(0);
        event1.setGroups(Arrays.asList(new Group[]{group1}));
        createEvent(event1);

        Event event2 = new Event();
        event2.setBudget(2000);
        event2.setLocation("Minsk, Belarus");
        event2.setActions(favActionsForUser2);
        event2.setEventDate(stringToDate("23/02/2017"));
        event2.setEventDescription("Today is the day of the people I love the most in this world my cute dad and my brothers he gave me, " +
                "thank you all for the great love you give me, happy men’s day");
        event2.setEventName("Mens' day");
        event2.setEventRating(0);
        event2.setGroups(Arrays.asList(new Group[]{group2}));
        createEvent(event2);

        Event event3 = new Event();
        event3.setBudget(1400);
        event3.setLocation("Gomel, Belarus");
        event3.setActions(favActionsForUser3);
        event3.setEventDate(stringToDate("23/12/2016"));
        event3.setEventDescription("The Hottest party ever!");
        event3.setEventName("Winter Party");
        event3.setEventRating(0);
        event3.setGroups(Arrays.asList(new Group[]{group2}));
        createEvent(event3);

        Event event4 = new Event();
        event4.setBudget(2000);
        event4.setLocation("Minsk, Belarus");
        event4.setActions(favActionsForUser4);
        event4.setEventDate(stringToDate("08/03/2016"));
        event4.setEventDescription("Girls you're kindly welcome to join!");
        event4.setEventName("Womens' day");
        event4.setEventRating(0);
        event4.setGroups(Arrays.asList(new Group[]{group1}));
        createEvent(event4);

        Event event5 = new Event();
        event5.setBudget(1400);
        event5.setLocation("Gomel, Belarus");
        event5.setActions(favActionsForUser3);
        event5.setEventDate(stringToDate("12/09/2016"));
        event5.setEventDescription("Today, on the 256th day of the year, we celebrate our professional holiday! " +
                "We'd like to congratulate my colleagues and wish effective solutions, bug-free code and wide recognition of your efforts!");
        event5.setEventName("Programmer Day");
        event5.setEventRating(0);
        event5.setGroups(Arrays.asList(new Group[]{group2}));
        createEvent(event5);
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
        Event eventToBeUpdated = getEventById(event.getEventId());
        events.set(events.indexOf(eventToBeUpdated), event);
        return true;
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
        Action actionToBeUpdated = getActionById(action.getActionId());
        actions.set(actions.indexOf(actionToBeUpdated), action);
        return true;
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

    Date stringToDate(String str){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
