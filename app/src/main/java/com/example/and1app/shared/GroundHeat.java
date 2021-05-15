package com.example.and1app.shared;

public class GroundHeat {
    private String groundHeatID;
    private int temperature;
    private Boolean temperatureOn;

    public GroundHeat() {
    }

    public GroundHeat(String groundHeatID) {
        this.groundHeatID = groundHeatID;
    }

    public String getGroundHeatID() {
        return groundHeatID;
    }

    public void setGroundHeatID(String groundHeatID) {
        this.groundHeatID = groundHeatID;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Boolean getTemperatureOn() {
        return temperatureOn;
    }

    public void setTemperatureOn(Boolean temperatureOn) {
        this.temperatureOn = temperatureOn;
    }
}
