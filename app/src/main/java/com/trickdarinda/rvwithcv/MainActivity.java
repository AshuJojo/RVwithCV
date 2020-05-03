package com.trickdarinda.rvwithcv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private static final LinkedList<String> linkedList = new LinkedList<>();
    private RecyclerView recyclerView;
    private RvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating the Linked List of 50 sample strings
        for (int i = 1; i < 51; i++) {
            linkedList.addLast("Text " + i);
        }

        //Get a handle to the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        //Create an adapter and supply data to be displayed
        adapter = new RvAdapter(this, linkedList);
        //Attach the RecyclerView to the Adapter
        recyclerView.setAdapter(adapter);
        //Set the LayoutManager for RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
