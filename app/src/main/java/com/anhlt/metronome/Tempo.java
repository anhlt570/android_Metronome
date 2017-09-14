package com.anhlt.metronome;

/**
 * Created by tuananh on 8/10/17.
 */

public class Tempo {
    private String name;
    private int minSpeed, maxSpeed;

    Tempo(String name, int minSpeed, int maxSpeed) {
        this.name = name;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    public String generateSpeedScope() {
        return "(" + minSpeed + " - " + maxSpeed + ")";
    }

    public int getAverageSpeed()
    {
        return (minSpeed + maxSpeed)/2;
    }
    public int getMinSpeed() {
        return minSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setMinSpeed(int minSpeed) {
        this.minSpeed = minSpeed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

