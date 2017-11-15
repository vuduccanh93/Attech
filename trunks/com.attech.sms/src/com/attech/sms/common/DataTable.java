/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attech.sms.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author andh
 */
public class DataTable {
    
    private List<DataRow> rows;
    
    
    public DataTable() {
        rows = new ArrayList<>();
    }
    
    
    

    /**
     * @return the rows
     */
    public List<DataRow> getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(List<DataRow> rows) {
        this.rows = rows;
    }
    
    public void addRow(DataRow row) {
        this.rows.add(row);
    }
}
