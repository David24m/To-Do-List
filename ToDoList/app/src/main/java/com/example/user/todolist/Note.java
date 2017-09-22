package com.example.user.todolist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by user on 22/09/2017.
 */

public class Note {

    private String title;
    private String details;
    private int priority;
    private String date;

    public Note (String title, String details, Integer priority, String date )  {
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

    public Integer getPriority() {
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

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setDate(String date) {
        this.date = date;
    }
}



//
//        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-mm-yyyy", Locale.UK);
//        try {
//            this.date = dateFormatter.parse(dateString);
//        }
//        catch (ParseException exception) {
//            this.date = new Date();
//        }