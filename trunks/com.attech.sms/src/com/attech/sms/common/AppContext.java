/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attech.sms.common;

import com.attech.sms.config.Configuration;
import java.io.File;
import org.hibernate.SessionFactory;

/**
 *
 * @author anhth
 */
public class AppContext {

    // private int timeout;
    private static Configuration configuration;
    public AppContext() {
        
    }

    public static void load(String path) {
        configuration = Configuration.load(path);

    }

    /**
     * @return the configuration
     */
    public static Configuration getConfiguration() {
        return configuration;
    }
}
