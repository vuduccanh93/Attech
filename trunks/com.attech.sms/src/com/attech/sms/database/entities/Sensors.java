/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attech.sms.database.entities;

import java.io.Serializable;

/**
 *
 * @author anhth
 */
public class Sensors implements Serializable {
    
    private Integer Id;
    private Byte SensorMode;
    private Integer Sic;
    private Float Latitude;
    private Float Longitude;
    private Integer StationId;
    private Byte Status;
    private String Description;
    
    public Sensors(){
    
    }

    /**
     * @return the Id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }

    /**
     * @return the SensorMode
     */
    public Byte getSensorMode() {
        return SensorMode;
    }

    /**
     * @param SensorMode the SensorMode to set
     */
    public void setSensorMode(Byte SensorMode) {
        this.SensorMode = SensorMode;
    }

    /**
     * @return the Sic
     */
    public Integer getSic() {
        return Sic;
    }

    /**
     * @param Sic the Sic to set
     */
    public void setSic(Integer Sic) {
        this.Sic = Sic;
    }

    /**
     * @return the Latitude
     */
    public Float getLatitude() {
        return Latitude;
    }

    /**
     * @param Latitude the Latitude to set
     */
    public void setLatitude(Float Latitude) {
        this.Latitude = Latitude;
    }

    /**
     * @return the Longitude
     */
    public Float getLongitude() {
        return Longitude;
    }

    /**
     * @param Longitude the Longitude to set
     */
    public void setLongitude(Float Longitude) {
        this.Longitude = Longitude;
    }

    /**
     * @return the StationId
     */
    public Integer getStationId() {
        return StationId;
    }

    /**
     * @param StationId the StationId to set
     */
    public void setStationId(Integer StationId) {
        this.StationId = StationId;
    }

    /**
     * @return the Status
     */
    public Byte getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Byte Status) {
        this.Status = Status;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
