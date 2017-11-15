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
public class Stations implements Serializable {
    
    private Integer Id;
    private String StationName;
    private String StationDescription;
    private Integer SortNumber;
    
    public Stations(){
    
    }
    
    public Stations(String stationName, String stationDescription, int sortNumber){
        this();
        this.StationName = stationName;
        this.StationDescription = stationDescription;
        this.SortNumber = sortNumber;
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
     * @return the StationName
     */
    public String getStationName() {
        return StationName;
    }

    /**
     * @param StationName the StationName to set
     */
    public void setStationName(String StationName) {
        this.StationName = StationName;
    }

    /**
     * @return the StationDescription
     */
    public String getStationDescription() {
        return StationDescription;
    }

    /**
     * @param StationDescription the StationDescription to set
     */
    public void setStationDescription(String StationDescription) {
        this.StationDescription = StationDescription;
    }

    /**
     * @return the SortNumber
     */
    public Integer getSortNumber() {
        return SortNumber;
    }

    /**
     * @param SortNumber the SortNumber to set
     */
    public void setSortNumber(Integer SortNumber) {
        this.SortNumber = SortNumber;
    }


}
