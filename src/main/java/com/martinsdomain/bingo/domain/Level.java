package com.martinsdomain.bingo.domain;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum Level {

    @JsonEnumDefaultValue
    EASY("easy", 5),
    MEDIUM("medium", 10),
    HARD("hard", 15),
    ELITE("elite", 20);

    private final String id;
    private final int pointValue;

    Level(String id, int pointValue) {
        this.id = id;
        this.pointValue = pointValue;
    }

    public String getId() {
        return id;
    }

    public int getPointValue() {
        return pointValue;
    }
}
