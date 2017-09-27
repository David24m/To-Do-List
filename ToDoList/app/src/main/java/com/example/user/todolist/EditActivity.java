package com.example.user.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    EditText titleField;
    EditText detailsField;
    RatingBar priorityField;
    EditText dateField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();
        Note note = (Note) intent.getSerializableExtra("selectedTask");
        Log.d("Task to edit", note.toString());

        titleField = (EditText) findViewById(R.id.titleText);
        titleField.setText(note.getTitle());

        detailsField = (EditText) findViewById(R.id.detailsText);
        detailsField.setText(note.getDetails());

        priorityField = (RatingBar) findViewById(R.id.priorityBar);
        priorityField.setRating(note.getPriority());

        dateField = (EditText) findViewById(R.id.dateText);
        dateField.setText(note.getDate());
    }

    public void getEdit(View button) {
        SharedPreferences sharedPrefs = getSharedPreferences("list", Context.MODE_PRIVATE);
        String notesJson = sharedPrefs.getString("allNotes", new ArrayList<Note>().toString());
        Log.d("saved notes", notesJson);
        Gson gson = new Gson();
        TypeToken< ArrayList<Note> > notesArrayTypeToken = new TypeToken< ArrayList<Note>>(){};
        ArrayList<Note> list = gson.fromJson(notesJson, notesArrayTypeToken.getType());

        Intent intent = getIntent();
        Integer index = intent.getIntExtra("selectedIndex", -1);

        Note note = list.get(index);

        String title = titleField.getText().toString();
        String details = detailsField.getText().toString();
        float priority = priorityField.getRating();
        String date = dateField.getText().toString();

        note.setTitle(title);
        note.setDetails(details);
        note.setPriority(priority);
        note.setDate(date);

        sharedPrefs.edit().putString("allNotes", gson.toJson(list)).apply();

        MakeEditToast("Note Edited", Toast.LENGTH_SHORT);
    }

    public void getDelete(View button) {
        SharedPreferences sharedPrefs = getSharedPreferences("list", Context.MODE_PRIVATE);
        String notesJson = sharedPrefs.getString("allNotes", new ArrayList<Note>().toString());
        Log.d("saved notes", notesJson);
        Gson gson = new Gson();
        TypeToken< ArrayList<Note> > notesArrayTypeToken = new TypeToken< ArrayList<Note>>(){};
        ArrayList<Note> list = gson.fromJson(notesJson, notesArrayTypeToken.getType());

        Intent intent = getIntent();
        Integer index = intent.getIntExtra("selectedIndex", -1);

        Note note = list.get(index);

        list.remove(note);
        Log.d("updated notes", note.toString());

        sharedPrefs.edit().putString("allNotes", gson.toJson(list)).apply();

        MakeDeleteToast("Note Deleted", Toast.LENGTH_SHORT);
    }

    public void MakeEditToast(String message, int length) {
        Toast.makeText(this, message, length).show();
    }

    public void MakeDeleteToast(String message, int length) {
        Toast.makeText(this, message, length).show();
    }
}