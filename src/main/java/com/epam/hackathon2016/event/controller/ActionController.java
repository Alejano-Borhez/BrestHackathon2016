package com.epam.hackathon2016.event.controller;

import com.epam.hackathon2016.event.dao.EventDao;
import com.epam.hackathon2016.event.domain.Action;
import com.epam.hackathon2016.event.domain.ActionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by alexander on 10.9.16.
 */
@RestController
@RequestMapping("/actions")
public class ActionController {
    @Autowired
    private EventDao dao;

    @RequestMapping("")
    public List<Action> getAllActions() {
        return dao.getAllActions();
    }

    @RequestMapping("/{actionId}")
    public Action getActionById(@PathVariable("actionId") int actionId) {
        return dao.getActionById(actionId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int createAction(@RequestParam("actionName") String actionName,
                            @RequestParam("type") String type,
                            @RequestParam("costPerUser") double costPerUser,
                            @RequestParam("actionDescription") String actionDescription,
                            HttpServletResponse resp
    ) throws IOException {

        Action action = new Action();
        action.setActionName(actionName);
        action.setType(ActionType.valueOf(type));
        action.setCostPerUser(costPerUser);
        action.setActionDescription(actionDescription);

        int actionId =dao.createAction(action);

        resp.sendRedirect("index.html");

        return actionId;
    }

    @RequestMapping(name = "/{actionId}/update", method = RequestMethod.PUT)
    public boolean updateAction(@PathVariable("actionId") int actionId,
                            @RequestParam("actionName") String actionName,
                            @RequestParam("type") String type,
                            @RequestParam("costPerUser") double costPerUser,
                            @RequestParam("actionDescription") String actionDescription,
                                HttpServletResponse resp
    ) throws IOException {

        Action action = dao.getActionById(actionId);
        action.setActionName(actionName);
        action.setType(ActionType.valueOf(type));
        action.setCostPerUser(costPerUser);
        action.setActionDescription(actionDescription);

        boolean updated = dao.updateAction(action);
        resp.sendRedirect("index.html");
        return updated;
    }
}
