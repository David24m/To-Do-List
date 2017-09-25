package com.example.user.todolist;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by user on 22/09/2017.
 */
public class NoteTest {

    Note note;

    @Before
    public void before() {
        note = new Note ("Buy Shopping", "Remember to buy eggs", 1, "27-09-2017");
    }

    @Test
    public void canGetTitleOfEntry() {
        assertEquals("Buy Shopping", note.getTitle());
    }

    @Test
    public void canGetDetailsOfEntry() {
        assertEquals("Remember to buy eggs", note.getDetails());
    }

    @Test
    public void canGetPriorityOfTask() {
        assertEquals(1, note.getPriority());
    }

    @Test
    public void canGetDateOfTask() {
        assertEquals("27-09-2017", note.getDate());
    }

}