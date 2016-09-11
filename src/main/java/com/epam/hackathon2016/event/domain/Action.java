package com.epam.hackathon2016.event.domain;

/**
 * Created by alexander on 10.9.16.
 */
public class Action {
    private int actionId;
    private String actionName;
    private double costPerUser;
    private String actionDescription;
    private int actionRating;

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public double getCostPerUser() {
        return costPerUser;
    }

    public void setCostPerUser(double costPerUser) {
        this.costPerUser = costPerUser;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public int getActionRating() {
        return actionRating;
    }

    public void setActionRating(int actionRating) {
        this.actionRating = actionRating;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        return actionId == action.actionId;

    }

    @Override
    public int hashCode() {
        return actionId;
    }
}
