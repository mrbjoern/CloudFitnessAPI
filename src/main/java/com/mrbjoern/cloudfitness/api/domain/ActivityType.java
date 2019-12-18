package com.mrbjoern.cloudfitness.api.domain;

public enum ActivityType {
    CARDIO("CARDIO"), WEIGHTLIFTING("WEIGHTLIFTING");

    private String name;

    ActivityType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
