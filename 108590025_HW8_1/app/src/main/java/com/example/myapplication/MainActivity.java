package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button minus;
    private Button plus;
    private int imageLevel = 0;
    private ImageView battery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        minus = findViewById(R.id.button);
        plus = findViewById(R.id.button2);
        battery = findViewById(R.id.imageView);
    }
    public void increase(View view){
        if (imageLevel < 6){
            imageLevel ++;
            battery.setImageLevel(imageLevel);
        }
    }
    public void decrease(View view){
        if (imageLevel > 0){
            imageLevel --;
            battery.setImageLevel(imageLevel);
        }
    }
}