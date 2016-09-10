package com.epam.hackathon2016.event.domain;

/**
 * Created by alexander on 10.9.16.
 */
public class Survey {
    private int surveyId;
    private Event event;

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
