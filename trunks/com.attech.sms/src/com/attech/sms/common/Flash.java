/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.attech.sms.common;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 *
 * @author andh
 */
public class Flash {
    
    private final JWindow window;
    private final JLabel label;
    private static Flash instance;
    ImageIcon icnHighPriority = new ImageIcon("flash.png");

    public Flash() {
        window = new JWindow();
        label = new JLabel("Initializing ... ", SwingConstants.CENTER);
        label.setIcon(icnHighPriority);
        label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        window.getContentPane().add(label);
        window.setBounds(500, 150, 300, 200);
        window.setAlwaysOnTop(true);
        // window.setVisible(true);
        
        window.setSize(icnHighPriority.getIconWidth(), icnHighPriority.getIconHeight() + 20);
    }
    
    public void show() {
        if (window == null) {
            return;
        }
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - window.getWidth()) / 2;
        final int y = (screenSize.height - window.getHeight()) / 2;
        window.setLocation(x, y);
        window.setVisible(true);
    }
    
    public void close() {
        if (window == null)return;
        window.dispose();
    }
    
    public synchronized void update(String status) {
        this.label.setText(status);
        label.paintImmediately(label.getVisibleRect());
        // this.label.repaint();
        // this.label.validate();
        // window.validate();
        // window.pack();
        
    }
    
    
    public synchronized static Flash getInstance() {
        if (instance == null) instance = new Flash();
        return instance;
    }
}
