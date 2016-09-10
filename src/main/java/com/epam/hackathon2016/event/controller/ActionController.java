package com.epam.hackathon2016.event.controller;

import com.epam.hackathon2016.event.dao.EventDao;
import com.epam.hackathon2016.event.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by alexander on 10.9.16.
 */
@RestController
@RequestMapping("/actions")
public class ActionController {
    @Autowired
    private EventDao dao;

    @RequestMapping(name = "/all")
    public List<Action> getAllActions() {
        return dao.getAllActions();
    }

    @RequestMapping(name = "/{actionId}")
    public Action getActionById(@PathVariable("actionId") int actionId) {
        return dao.getActionById(actionId);
    }

    @RequestMapping(name = "/create", method = RequestMethod.POST)
    public int createAction(@ModelAttribute Action action) {
        return dao.createAction(action);
    }
}
