/*
 * @(#)PreferencesTest.java 
 * 
 * Copyright © 2010 Werner Randelshofer, Switzerland.
 * All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with Werner Randelshofer.
 * For details see accompanying license terms.
 */

package test;

import ch.randelshofer.quaqua.osx.OSXPreferences;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 * PreferencesTest.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class PreferencesTest extends javax.swing.JPanel {

    /** Creates new form PreferencesTest */
    public PreferencesTest() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preferencesScrollPane = new javax.swing.JScrollPane();
        preferencesTable = new javax.swing.JTable();
        controlPanel = new javax.swing.JPanel();
        readGlobalButton = new javax.swing.JButton();
        readFinderButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        FormListener formListener = new FormListener();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 17, 17, 17));
        setLayout(new java.awt.BorderLayout());

        preferencesScrollPane.setViewportView(preferencesTable);

        add(preferencesScrollPane, java.awt.BorderLayout.CENTER);

        controlPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        readGlobalButton.setText("Read Global Preferences");
        readGlobalButton.addActionListener(formListener);
        controlPanel.add(readGlobalButton);

        readFinderButton.setText("Read Finder Preferences");
        readFinderButton.addActionListener(formListener);
        controlPanel.add(readFinderButton);

        add(controlPanel, java.awt.BorderLayout.SOUTH);
        add(titleLabel, java.awt.BorderLayout.PAGE_START);
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == readGlobalButton) {
                PreferencesTest.this.readGlobalPerformed(evt);
            }
            else if (evt.getSource() == readFinderButton) {
                PreferencesTest.this.readFinderPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void readGlobalPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readGlobalPerformed
        read(OSXPreferences.GLOBAL_PREFERENCES,"Global Preferences");
    }//GEN-LAST:event_readGlobalPerformed

    private void readFinderPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readFinderPerformed
         read(OSXPreferences.FINDER_PREFERENCES,"Finder Preferences");

    }//GEN-LAST:event_readFinderPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controlPanel;
    private javax.swing.JScrollPane preferencesScrollPane;
    private javax.swing.JTable preferencesTable;
    private javax.swing.JButton readFinderButton;
    private javax.swing.JButton readGlobalButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    private void read(File f, String title) {
        titleLabel.setText("");
        OSXPreferences.clearCache(f);
        ArrayList<String> keys=new ArrayList<String>(OSXPreferences.getKeySet(f));
        Collections.sort(keys);
        String[][] data=new String[keys.size()][2];
        for (int i=0,n=keys.size();i<n;++i) {
            data[i][0]=keys.get(i);
            data[i][1]=OSXPreferences.getString(f, keys.get(i));
        }
        preferencesTable.setModel(new DefaultTableModel(data,new String[]{"Key","Value"}));
        titleLabel.setText(title);
        revalidate();
    }

}
