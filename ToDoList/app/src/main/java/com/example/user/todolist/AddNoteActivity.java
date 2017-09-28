package com.example.user.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class AddNoteActivity extends AppCompatActivity {



    Button confirmAdd;
    EditText newTitleText;
    EditText newDetailsText;
    RatingBar newPriorityBar;
    EditText newDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        newTitleText = (EditText) findViewById(R.id.addTitleText);
        newDetailsText = (EditText) findViewById(R.id.addDetailsText);
        newPriorityBar = (RatingBar) findViewById(R.id.addPriorityBar);
        newDateText = (EditText) findViewById(R.id.addDateText);
        confirmAdd = (Button) findViewById(R.id.addButton);

        AddData();
    }

    public void AddData() {
        confirmAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // getting saved notes from SP
                SharedPreferences sharedPrefs = getSharedPreferences("list", Context.MODE_PRIVATE);
                String notesJson = sharedPrefs.getString("allNotes", new ArrayList<Note>().toString());
                Log.d("saved notes", notesJson);
                Gson gson = new Gson();
                TypeToken< ArrayList<Note> > notesArrayTypeToken = new TypeToken< ArrayList<Note>>(){};
                ArrayList<Note> list = gson.fromJson(notesJson, notesArrayTypeToken.getType());

                String title = newTitleText.getText().toString();
                String details = newDetailsText.getText().toString();
                float priority = newPriorityBar.getRating();
                String date = newDateText.getText().toString();

                Note newNote = new Note(title, details, priority, date);


                list.add(newNote);
                Log.d("updated notes", newNote.toString());


                sharedPrefs.edit().putString("allNotes", gson.toJson(list)).apply();

                MakeAddToast("Note Added", Toast.LENGTH_SHORT);
            }
        });
    }

    public void MakeAddToast(String message, int length) {
        Toast.makeText(this, message, length).show();
    }

}
