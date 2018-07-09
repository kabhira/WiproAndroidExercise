package com.abhi.androidexercise.model;

/**
 *  Author: Abhiraj Khare
 *  Description: Model Object to hold values form JSON object which are fetched from server.
 *
 */

public class FactsRowsElement {

    private String title;
    private String description;
    private String imageHref;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageHref() {
        return imageHref;
    }

    public void setImageHref(String imageHref) {
        this.imageHref = imageHref;
    }
}
