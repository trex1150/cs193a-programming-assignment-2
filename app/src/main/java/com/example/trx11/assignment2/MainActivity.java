package com.example.trx11.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> todoList = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertList();
    }

    //sets up the ArrayAdapter to take in the ArrayList
    private void convertList() {
       adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                todoList);
        final ListView listView = (ListView) findViewById(R.id.todolist);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                removeItem(position, listView);
                return false;
            }
        });
    }

    //remove an item from the ArrayList and update the changes to the screen
    private void removeItem(int position, ListView listView) {
        todoList.remove(position);
        Toast.makeText(this, "Item removed", Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
    }

    //add an item to the ArrayList and update the changes to the screen
    public void addItem(View view) {
        EditText item = (EditText) findViewById(R.id.new_item);
        String newItem = item.getText().toString();
        todoList.add(newItem);
        Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show();
        item.setText("");
        adapter.notifyDataSetChanged();
    }

}
