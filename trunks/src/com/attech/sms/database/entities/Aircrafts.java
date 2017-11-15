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
public class Aircrafts implements Serializable {
    
    private Integer Id;
    private String Icao24Address;
    private String RegistrationNo;
    private String Model;
    private String AircraftType;
    private String Operator;
    
    public Aircrafts(){
    
    }
    
    public Aircrafts(String Icao24Address, String RegistrationNo, String AircraftType){
        this();
        this.AircraftType = AircraftType;
        this.Icao24Address = Icao24Address;
        this.RegistrationNo = RegistrationNo;
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
     * @return the Icao24Address
     */
    public String getIcao24Address() {
        return Icao24Address;
    }

    /**
     * @param Icao24Address the Icao24Address to set
     */
    public void setIcao24Address(String Icao24Address) {
        this.Icao24Address = Icao24Address;
    }

    /**
     * @return the RegistrationNo
     */
    public String getRegistrationNo() {
        return RegistrationNo;
    }

    /**
     * @param RegistrationNo the RegistrationNo to set
     */
    public void setRegistrationNo(String RegistrationNo) {
        this.RegistrationNo = RegistrationNo;
    }

    /**
     * @return the Model
     */
    public String getModel() {
        return Model;
    }

    /**
     * @param Model the Model to set
     */
    public void setModel(String Model) {
        this.Model = Model;
    }

    /**
     * @return the AircraftType
     */
    public String getAircraftType() {
        return AircraftType;
    }

    /**
     * @param AircraftType the AircraftType to set
     */
    public void setAircraftType(String AircraftType) {
        this.AircraftType = AircraftType;
    }

    /**
     * @return the Operator
     */
    public String getOperator() {
        return Operator;
    }

    /**
     * @param Operator the Operator to set
     */
    public void setOperator(String Operator) {
        this.Operator = Operator;
    }
    
}
