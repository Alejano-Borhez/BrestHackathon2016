package com.epam.hackathon2016.event.controller;

import com.epam.hackathon2016.event.dao.EventDao;
import com.epam.hackathon2016.event.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alexander on 10.9.16.
 */
@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private EventDao dao;

    @RequestMapping("")
    public List<Group> getAllGroups() {
        return dao.getAllGroups();
    }

    @RequestMapping("/{groupId}")
    public Group getGroupById(@PathVariable("groupId") int groupId) {
        return dao.getGroupById(groupId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int createGroup(@ModelAttribute Group group) {
        return dao.createGroup(group);
    }






}
