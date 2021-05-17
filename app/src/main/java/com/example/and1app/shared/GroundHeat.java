package com.example.and1app.shared;

import java.io.Serializable;

public class GroundHeat implements Serializable {
    private String groundHeatID;
    private int temperature = 0;
    private boolean temperatureOn = false;

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

    public boolean getTemperatureOn() {
        return temperatureOn;
    }

    public void setTemperatureOn(boolean temperatureOn) {
        this.temperatureOn = temperatureOn;
    }

}
