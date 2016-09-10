package com.epam.hackathon2016.event.domain;

/**
 * Created by alexander on 10.9.16.
 */
public enum ActionType {
    OPEN_AIR("Open Air"), BBQ("Barbecue"), PIZZA("Pizza"), POKER("Poker"), BILLIARD("Billiard"), SAUNA("Sauna"), BOATING("Boating");

    private final String text;

    private ActionType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
