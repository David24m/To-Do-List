package com.example.user.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    DatabaseHelper todolistDB;

    Button confirmAdd;
    EditText newTitleText;
    EditText newDetailsText;
    RatingBar newPriorityBar;
    EditText newDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);


        todolistDB = new DatabaseHelper(this);

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

                String title = newTitleText.getText().toString();
                String details = newDetailsText.getText().toString();
                Integer priority = newPriorityBar.getNumStars();
                String date = newDateText.getText().toString();

                boolean insertData = todolistDB.addData(title, details, priority, date);

                if(insertData == true) {
                    Toast.makeText(AddNoteActivity.this, "Data successfully inserted!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(AddNoteActivity.this, "You messed up!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
