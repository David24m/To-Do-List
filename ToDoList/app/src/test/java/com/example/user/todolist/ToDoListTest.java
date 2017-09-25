package com.example.user.todolist;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by user on 22/09/2017.
 */
public class ToDoListTest {

    Note note;
    ArrayList<Note> list;

    @Before
    public void before() {
        note = new Note ("Buy Shopping", "Remember to buy eggs", 1, "27-09-2017");
    }

    @Test
    public void arrayStartsWithNoEntries() {
        list = new ArrayList<Note>();
        assertEquals(0, list.size());
    }

    @Test
    public void arrayCanAddEntry() {
        list = new ArrayList<Note>();
        list.add(note);
        assertEquals(1, list.size());
    }

    @Test
    public void arrayCanRemoveEntries() {
        list = new ArrayList<Note>();
        list.add(note);
        list.remove(note);
        assertEquals(0, list.size());
    }
}