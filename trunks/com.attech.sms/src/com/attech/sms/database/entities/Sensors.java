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
    
    private String ReceivingMode;
    private String ReceivingMulticastAddress;
    private Integer ReceivingPort;
    private String ReceivingBindIp;
    
    private String ForwardMode;
    private String ForwardAddress;
    private Integer ForwardPort;
    private Byte EnableForwarding;
    private String ForwardBindIp;
    private Integer ForwardingMultiCastTTL;
    private Integer BufferSize;
    
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

    /**
     * @return the ReceivingMode
     */
    public String getReceivingMode() {
        return ReceivingMode;
    }

    /**
     * @param ReceivingMode the ReceivingMode to set
     */
    public void setReceivingMode(String ReceivingMode) {
        this.ReceivingMode = ReceivingMode;
    }

    /**
     * @return the ReceivingMulticastAddress
     */
    public String getReceivingMulticastAddress() {
        return ReceivingMulticastAddress;
    }

    /**
     * @param ReceivingMulticastAddress the ReceivingMulticastAddress to set
     */
    public void setReceivingMulticastAddress(String ReceivingMulticastAddress) {
        this.ReceivingMulticastAddress = ReceivingMulticastAddress;
    }

    /**
     * @return the ReceivingPort
     */
    public Integer getReceivingPort() {
        return ReceivingPort;
    }

    /**
     * @param ReceivingPort the ReceivingPort to set
     */
    public void setReceivingPort(Integer ReceivingPort) {
        this.ReceivingPort = ReceivingPort;
    }

    /**
     * @return the ReceivingBindIp
     */
    public String getReceivingBindIp() {
        return ReceivingBindIp;
    }

    /**
     * @param ReceivingBindIp the ReceivingBindIp to set
     */
    public void setReceivingBindIp(String ReceivingBindIp) {
        this.ReceivingBindIp = ReceivingBindIp;
    }

    /**
     * @return the ForwardMode
     */
    public String getForwardMode() {
        return ForwardMode;
    }

    /**
     * @param ForwardMode the ForwardMode to set
     */
    public void setForwardMode(String ForwardMode) {
        this.ForwardMode = ForwardMode;
    }

    /**
     * @return the ForwardAddress
     */
    public String getForwardAddress() {
        return ForwardAddress;
    }

    /**
     * @param ForwardAddress the ForwardAddress to set
     */
    public void setForwardAddress(String ForwardAddress) {
        this.ForwardAddress = ForwardAddress;
    }

    /**
     * @return the ForwardPort
     */
    public Integer getForwardPort() {
        return ForwardPort;
    }

    /**
     * @param ForwardPort the ForwardPort to set
     */
    public void setForwardPort(Integer ForwardPort) {
        this.ForwardPort = ForwardPort;
    }

    /**
     * @return the EnableForwarding
     */
    public Byte getEnableForwarding() {
        return EnableForwarding;
    }

    /**
     * @param EnableForwarding the EnableForwarding to set
     */
    public void setEnableForwarding(Byte EnableForwarding) {
        this.EnableForwarding = EnableForwarding;
    }

    /**
     * @return the ForwardBindIp
     */
    public String getForwardBindIp() {
        return ForwardBindIp;
    }

    /**
     * @param ForwardBindIp the ForwardBindIp to set
     */
    public void setForwardBindIp(String ForwardBindIp) {
        this.ForwardBindIp = ForwardBindIp;
    }

    /**
     * @return the ForwardingMultiCastTTL
     */
    public Integer getForwardingMultiCastTTL() {
        return ForwardingMultiCastTTL;
    }

    /**
     * @param ForwardingMultiCastTTL the ForwardingMultiCastTTL to set
     */
    public void setForwardingMultiCastTTL(Integer ForwardingMultiCastTTL) {
        this.ForwardingMultiCastTTL = ForwardingMultiCastTTL;
    }

    /**
     * @return the BufferSize
     */
    public Integer getBufferSize() {
        return BufferSize;
    }

    /**
     * @param BufferSize the BufferSize to set
     */
    public void setBufferSize(Integer BufferSize) {
        this.BufferSize = BufferSize;
    }
    
}
