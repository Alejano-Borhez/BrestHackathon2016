package com.epam.hackathon2016.event.domain;

import java.util.ArrayList;

/**
 * Created by alexander on 10.9.16.
 */
public class User {

    private String name;
    private int id;
    private int groupId;
    private ArrayList<Action> favourite;
    private String email;

    public ArrayList<Action> getFavourite() {
        return favourite;
    }

    public void setFavourite(ArrayList<Action> favourite) {
        this.favourite = favourite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
