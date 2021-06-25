package com.example.a108590025_hw7_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.example.android.a108590025_hw7_2.extra.MESSAGE";
    private  final LinkedList<String> foods = new LinkedList<>();
    private  final LinkedList<String> desc = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        String[] food = res.getStringArray(R.array.foods);
        String[] des = res.getStringArray(R.array.desc);
        for (int i = 0; i < food.length; i++) {
            foods.add(food[i]);
            desc.add(des[i]);
        }
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
// Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, foods,desc);
// Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
// Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}