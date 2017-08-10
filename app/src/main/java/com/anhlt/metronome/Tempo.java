package com.anhlt.metronome;

/**
 * Created by tuananh on 8/10/17.
 */

public class Tempo {
    private String name;
    private int lowerSpeed, upperSpeed;

    Tempo(String name, int lowerSpeed, int upperSpeed) {
        this.name = name;
        this.lowerSpeed = lowerSpeed;
        this.upperSpeed = upperSpeed;
    }

    public String generateSpeedScope() {
        return "(" + lowerSpeed + " - " + upperSpeed + ")";
    }

    public int getAverageSpeed()
    {
        return (lowerSpeed+upperSpeed)/2;
    }
    public int getLowerSpeed() {
        return lowerSpeed;
    }

    public int getUpperSpeed() {
        return upperSpeed;
    }

    public String getName() {
        return name;
    }

    public void setLowerSpeed(int lowerSpeed) {
        this.lowerSpeed = lowerSpeed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpperSpeed(int upperSpeed) {
        this.upperSpeed = upperSpeed;
    }
}

