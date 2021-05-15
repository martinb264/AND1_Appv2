package com.example.and1app.shared;

public class Radiator {
    private int temperature;
    private boolean temperatureOn;
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
