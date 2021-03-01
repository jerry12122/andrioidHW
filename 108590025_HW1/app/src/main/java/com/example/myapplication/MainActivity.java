package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String TAG = MainActivity.class.getSimpleName();
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Hello Worlda");

    }
}