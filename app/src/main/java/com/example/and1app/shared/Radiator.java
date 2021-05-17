package com.example.and1app.shared;

import java.io.Serializable;

public class Radiator implements Serializable {
    private int temperature = 0;
    private boolean temperatureOn = false;
    private String id;

    public Radiator() {
    }

    public Radiator(String id)
    {
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isTemperatureOn() {
        return temperatureOn;
    }

    public void setTemperatureOn(boolean temperatureOn) {
        this.temperatureOn = temperatureOn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
