package com.epam.hackathon2016.event.controller;

import com.epam.hackathon2016.event.dao.EventDao;
import com.epam.hackathon2016.event.domain.Event;
import com.epam.hackathon2016.event.domain.Survey;
import com.epam.hackathon2016.event.mail.EventMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
}
