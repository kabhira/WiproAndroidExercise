package com.abhi.androidexercise.model;

import java.util.ArrayList;

/**
 *  Author: Abhiraj Khare
 *  Description: Model Object to hold values form JSON object which are fetched from server.
 *
 */

public class FactsElement {

    private String title;
    private ArrayList<FactsRowsElement> rows;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<FactsRowsElement> getRows() {
        return rows;
    }

    public void setRows(ArrayList<FactsRowsElement> rows) {
        this.rows = rows;
    }
}
