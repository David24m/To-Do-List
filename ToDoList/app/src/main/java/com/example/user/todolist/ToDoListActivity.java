package com.example.user.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        ToDoList toDoList = new ToDoList();
        ArrayList<Note> list = toDoList.getList();

        ToDoListAdapter toDoListAdapter = new ToDoListAdapter(this, list);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(toDoListAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.to_do_list_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selectedItemId = item.getItemId();
        switch (selectedItemId) {
            case R.id.action_add:
                goToNewActivity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToNewActivity() {
       Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }

    public void getDetails(View listItem){
        Note note = (Note) listItem.getTag();

        Intent intent = new Intent(this, EditActivity.class);

        intent.putExtra("selectedTask", note);


        startActivity(intent);
    }

}
