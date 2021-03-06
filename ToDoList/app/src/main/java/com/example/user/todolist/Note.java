package com.example.user.todolist;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by user on 22/09/2017.
 */

public class Note implements Serializable {

    private String title;
    private String details;
    private float priority;
    private String date;

    public Note (String title, String details, float priority, String date )  {
        this.title = title;
        this.details = details;
        this.priority = priority;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public float getPriority() {
        return priority;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPriority(float priority) {
        this.priority = priority;
    }

    public void setDate(String date) {
        this.date = date;
    }


}


