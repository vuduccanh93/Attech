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
public class UserGroups implements Serializable {
    private Integer Id;
    private String GroupName;
    private String GroupDescription;
    
    public UserGroups(){}
    
    public UserGroups(String Name, String Description){
        this();
        this.GroupName = Name;
        this.GroupDescription = Description;
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
     * @return the GroupName
     */
    public String getGroupName() {
        return GroupName;
    }

    /**
     * @param GroupName the GroupName to set
     */
    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    /**
     * @return the GroupDescription
     */
    public String getGroupDescription() {
        return GroupDescription;
    }

    /**
     * @param GroupDescription the GroupDescription to set
     */
    public void setGroupDescription(String GroupDescription) {
        this.GroupDescription = GroupDescription;
    }
}
