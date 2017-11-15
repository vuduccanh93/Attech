/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attech.sms.config;


import com.attech.sms.common.XmlSerializer;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anhth
 */
@XmlRootElement(name = "System")
@XmlAccessorType(XmlAccessType.NONE)
public class Configuration {
    
    @XmlElement(name = "Theme")
    private String theme;
    
    public Configuration() {
        
    }

    
    public static Configuration load(String fileName) {
        Object configuration = XmlSerializer.deserialize(fileName, Configuration.class);
        if (configuration == null) return Configuration.getDefault();
        return (Configuration) configuration;
    }
    
    public void save(String file) {
        XmlSerializer.serialize(file, this);
    }
    
    public static void main (String [] args) {
        Configuration config  = new Configuration();
        config.setTheme("Window");
        
        config.save("config3.xml");
        System.out.println("Writing example is completed");
    }
    
    
    public static Configuration getDefault() {
        Configuration config = new Configuration();
        config.setTheme("Windows");
        config.save("config.xml");
        return config;
    }

    /**
     * @return the theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * @param theme the theme to set
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    
}
