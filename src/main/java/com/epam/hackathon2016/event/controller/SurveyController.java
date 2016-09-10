package com.epam.hackathon2016.event.controller;

import com.epam.hackathon2016.event.dao.EventDao;
import com.epam.hackathon2016.event.domain.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alexander on 10.9.16.
 */
@RestController
@RequestMapping("/surveys")
public class SurveyController {
    @Autowired
    private EventDao dao;

    @RequestMapping("")
    public List<Survey> getAllSurveys() {
        return dao.getAllSurveys();
    }

    @RequestMapping("/{surveyId}")
    public Survey getSurveyById(@PathVariable("surveyId") int surveyId) {
        return dao.getSurveyById(surveyId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int createSurvey(@ModelAttribute Survey survey) {
        return dao.createSurvey(survey);
    }
}
