package com.example.and1app.shared;


public class Room {
    private String title;
    private String thermostatID;
    private int roomTemperature;
    private Radiator radiator;
    private GroundHeat groundHeat;
    private Boolean hasRadiator;
    private Boolean hasGroundHeat;


    public Room() {
    }

    public Room(String title) {
        this.title = title;
    }

    public Room(String title, String thermostatID)
    {
        this.title=title;
        this.thermostatID = thermostatID;
    }


    public Room(String title,String thermostatID, Radiator radiator) {
        this.title = title;
        this.thermostatID = thermostatID;
        this.radiator = radiator;
    }

    public Room(String title,String thermostatID, GroundHeat groundHeat) {
        this.title = title;
        this.thermostatID = thermostatID;
        this.groundHeat = groundHeat;
    }

    public Room(Radiator radiator, GroundHeat groundHeat) {
        this.radiator = radiator;
        this.groundHeat = groundHeat;
    }

    public Room(String title, String thermostatID, Radiator radiator, GroundHeat groundHeat) {
        this.title = title;
        this.thermostatID = thermostatID;
        this.radiator = radiator;
        this.groundHeat = groundHeat;
    }

    public Room(String title, String thermostatID, int roomTemperature) {
        this.title = title;
        this.thermostatID = thermostatID;
        this.roomTemperature = roomTemperature;
    }

    public Room(String title, Radiator radiator) {
        this.title = title;
        this.radiator = radiator;
    }

    public Room(String title, GroundHeat groundHeat) {
        this.title = title;
        this.groundHeat = groundHeat;
    }

    public Room(String title, Radiator radiator, GroundHeat groundHeat) {
        this.title = title;
        this.radiator = radiator;
        this.groundHeat = groundHeat;
    }


    public int getRoomTemperature() {
        return roomTemperature;
    }

    public void setRoomTemperature(int roomTemperature) {
        this.roomTemperature = roomTemperature;
    }

    public GroundHeat getGroundHeat() {
        return groundHeat;
    }

    public void setGroundHeat(GroundHeat groundHeat) {
        this.groundHeat = groundHeat;
    }

    public Radiator getRadiator() {
        return radiator;
    }

    public void setRadiator(Radiator radiator) {
        this.radiator = radiator;
    }

    public Boolean getHasRadiator() {
        return hasRadiator;
    }

    public void setHasRadiator(Boolean hasRadiator) {
        this.hasRadiator = hasRadiator;
    }

    public Boolean getHasGroundHeat() {
        return hasGroundHeat;
    }

    public void setHasGroundHeat(Boolean hasGroundHeat) {
        this.hasGroundHeat = hasGroundHeat;
    }

    public String getThermostatID() {
        return thermostatID;
    }

    public void setThermostatID(String thermostatID) {
        this.thermostatID = thermostatID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
