/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attech.sms.database.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author anhth
 */
public class Users implements Serializable {
    private Integer Id;
    private String Username;
    private String Password;
    private String Fullname;
    private Integer UserGroupId;
    private Date LastLogin;
    private Integer UserStatus;
    
    public Users(){}
    
    public Users(int id, String name, String pass, String fname, Integer groupid){
        this();
        this.Id = id;
        this.Fullname = fname;
        this.Username = name;
        this.Password = pass;
        this.UserGroupId = groupid;
        this.LastLogin = new Date();
        this.UserStatus = 1;
    }

    @Override
    public String toString() {
        return String.format("Id: %3d, Username: %s, Password: %s, Fullname: %s, GroupId: %3d", 
                Id,
                Username,
                Password,
                Fullname,
                UserGroupId);
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
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Fullname
     */
    public String getFullname() {
        return Fullname;
    }

    /**
     * @param Fullname the Fullname to set
     */
    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    /**
     * @return the UserGroupId
     */
    public Integer getUserGroupId() {
        return UserGroupId;
    }

    /**
     * @param UserGroupId the UserGroupId to set
     */
    public void setUserGroupId(Integer UserGroupId) {
        this.UserGroupId = UserGroupId;
    }

    /**
     * @return the LastLogin
     */
    public Date getLastLogin() {
        return LastLogin;
    }

    /**
     * @param LastLogin the LastLogin to set
     */
    public void setLastLogin(Date LastLogin) {
        this.LastLogin = LastLogin;
    }

    /**
     * @return the UserStatus
     */
    public Integer getUserStatus() {
        return UserStatus;
    }

    /**
     * @param UserStatus the UserStatus to set
     */
    public void setUserStatus(Integer UserStatus) {
        this.UserStatus = UserStatus;
    }

}
