package com.example.user.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public class ToDoListAdapter extends ArrayAdapter<Note> {

    public ToDoListAdapter(Context context, ArrayList<Note> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.to_do_list_item, parent, false);
        }

        Note currentNote = getItem(position);

        TextView title = (TextView) listItemView.findViewById(R.id.titleText);
        title.setText(currentNote.getTitle());

        listItemView.setTag(currentNote);

        return listItemView;
    }
}
