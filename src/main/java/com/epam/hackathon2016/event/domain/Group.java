package com.epam.hackathon2016.event.domain;

import java.util.ArrayList;

/**
 * Created by alexander on 10.9.16.
 */
public class Group {

    private String groupName;
    private int groupId;
    private ArrayList<User> userList;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
