package com.example.user.todolist;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public class ToDoList {

    private ArrayList<Note> list;

    public ToDoList() {
        list = new ArrayList<Note>();
        list.add(new Note("Buy Shopping", "Remember to buy eggs", 1, "27-09-2017"));
    }

    public ArrayList<Note> getList() {
        return new ArrayList<Note> (list);
    }
}
