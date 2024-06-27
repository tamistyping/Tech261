package com.sparta.tp;

public enum Potion {
    SPEED("Speed Potion", "Travel at the speed of light", 30),
    INVINCIBLE("Invincible Potion", "Unlimited health", 30),
    INVISIBILITY("Invisibility Potion", "Become invisible", 60);

    private final String name;
    private final String description;
    private final int duration;

    Potion(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }
}
