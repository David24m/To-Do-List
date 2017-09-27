package com.example.user.todolist;

import android.app.Application;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {


    ArrayList<Note> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        ToDoList toDoList = new ToDoList();

        list = toDoList.getList();

        SharedPreferences sharedPrefs = getSharedPreferences("list", Context.MODE_PRIVATE);
        String notesJson = sharedPrefs.getString("allNotes", new ArrayList<Note>().toString());
        Log.d("saved notes", notesJson);
        Gson gson = new Gson();
        TypeToken< ArrayList<Note> > notesArrayTypeToken = new TypeToken< ArrayList<Note>>(){};
        ArrayList<Note> list = gson.fromJson(notesJson, notesArrayTypeToken.getType());


        ToDoListAdapter toDoListAdapter = new ToDoListAdapter(this, list);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(toDoListAdapter);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View listItem, int index, long l) {
                Note note = (Note) listItem.getTag();

                Intent intent = new Intent(ToDoListActivity.this, EditActivity.class);
                intent.putExtra("selectedTask", note);
                intent.putExtra("selectedIndex", index);


                startActivity(intent);
            }
        };
        listView.setOnItemClickListener(listener);
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
        intent.putExtra("list", list);

        startActivity(intent);
    }

}
