package com.epam.hackathon2016.event.controller;

import com.epam.hackathon2016.event.dao.EventDao;
import com.epam.hackathon2016.event.domain.Action;
import com.epam.hackathon2016.event.domain.Event;
import com.epam.hackathon2016.event.domain.Survey;
import com.epam.hackathon2016.event.domain.User;
import com.epam.hackathon2016.event.mail.EventMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by alexander on 10.9.16.
 */
@RestController
@RequestMapping("/surveys")
public class SurveyController {
    @Autowired
    private EventDao dao;
    @Autowired
    private EventMailSender mailSender;

    @RequestMapping("")
    public List<Survey> getAllSurveys() {
        return dao.getAllSurveys();
    }

    @RequestMapping("/{surveyId}")
    public Survey getSurveyById(@PathVariable("surveyId") int surveyId) {
        return dao.getSurveyById(surveyId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int createSurvey(@RequestParam("eventId") int eventId, HttpServletResponse resp
            ) throws IOException {
        Event event = dao.getEventById(eventId);
        Survey survey = new Survey();
        survey.setEvent(event);
        int surveyId = dao.createSurvey(survey);
        mailSender.sendSurveyEmail(survey);
        resp.sendRedirect("index.html");
        return surveyId;
    }

    @RequestMapping(name = "/{surveyId}/{userId}/vote", method = RequestMethod.POST)
    public boolean voteInSurvey(@PathVariable("surveyId") int surveyId,
                                @PathVariable("userId") int userId,
                                @RequestParam("votesMap") Map<Integer, Integer> votesMap,
                                HttpServletResponse resp) {
        User user = dao.getUserById(userId);
        ArrayList<Action> preferences = user.getFavourite();
        for (int entry : votesMap.keySet()) {
            Action action = dao.getActionById(entry);
            action.setActionRating(action.getActionRating() + votesMap.get(entry));
            dao.updateAction(action);

            switch (votesMap.get(entry)) {
                case 0: break;
                case 1:
                    if (!preferences.contains(action)) preferences.add(action);
                    break;
                case -1:
                    if (preferences.contains(action)) preferences.remove(action);
                    break;
            }
        }

        user.setFavourite(preferences);
        dao.updateUser(user);

        return true;
    }
}
