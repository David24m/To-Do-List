package com.example.user.todolist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SeekBar;

import java.util.ArrayList;

import static android.R.attr.button;

public class EditActivity extends AppCompatActivity {

    EditText titleField;
    EditText detailsField;
    RatingBar priorityField;
    EditText dateField;
    Button savenotebutton;
    SharedPreferences savednotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();
        Note note = (Note) intent.getSerializableExtra("selectedTask");
        Log.d("Task to edit", note.toString());

        EditText titleField = (EditText) findViewById(R.id.titleText);
        titleField.setText(note.getTitle());

        EditText detailsField = (EditText) findViewById(R.id.detailsText);
        detailsField.setText(note.getDetails());

        RatingBar priorityField = (RatingBar) findViewById(R.id.ratingBar);
        priorityField.setRating(note.getPriority());

        EditText dateField = (EditText) findViewById(R.id.dateText);
        dateField.setText(note.getDate());

        savenotebutton = (Button) findViewById(R.id.editButton);
        savednotes = getSharedPreferences("notes", MODE_PRIVATE);

//        titleField.setText(savednotes.getString("tag", "Default Value"));
//        detailsField.setText(savednotes.getString("tag", "Default Value"));
//        priorityField.setRating(savednotes.getInt("tag", Integer.parseInt("Default Value")));
//        dateField.setText(savednotes.getString("tag", "Default Value"));
//
//        savenotebutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                titleField.setText(savednotes);
//            }
//        });
//
//
//    }
//
//    private void makeTag(String tag){
//        String or = savednotes.getString(tag, null);
//        SharedPreferences.Editor preferencesEditor = savednotes.edit();
//        preferencesEditor.putString("tag",tag); //change this line to this
//        preferencesEditor.commit();
//    }

    }


    public void getEdit(View button) {
        String UserTitleField = titleField.getText().toString();
        titleField.setText(UserTitleField);
        String UserDetailsField = detailsField.getText().toString();
        detailsField.setText(UserDetailsField);
//        Integer UserRatingField = priorityField.getRating();
//        priorityField.setRating(UserRatingField);
        String UserDateField = dateField.getText().toString();
        dateField.setText(UserDateField);
    }

}