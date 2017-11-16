/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attech.sms;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import com.attech.sms.common.AppContext;
import com.attech.sms.common.ExceptionHandler;
import com.attech.sms.gui.*;

/**
 *
 * @author anhth
 */
public class run {

    private final static String CONFIGURATION = "config.xml";
    private static final String CONFIG_LOG = "log.xml";
    private static final Logger logger = Logger.getLogger(run.class);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DOMConfigurator.configure(CONFIG_LOG);
        AppContext.load(CONFIGURATION);
        String theme = AppContext.getConfiguration().getTheme();
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (theme.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ExceptionHandler.handle(ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                logger.info("PROGRAM STARTED");
                Login frmLogin = new Login();
                //GUI gui = new GUI();    
                frmLogin.setVisible(true);
            } catch (Exception ex) {
                ExceptionHandler.handle(ex);
            } finally {
                
            }
        });
        
    }
    
}
