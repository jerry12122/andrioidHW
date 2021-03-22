package com.example.homework4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnCount;
    private TextView mShowCount;
    private EditText reply;
    private int mCount = 0;
    private String text;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        btnCount = findViewById (R.id.button);
        mShowCount = findViewById(R.id.textView);
        reply =findViewById(R.id.reply);
        if (savedInstanceState != null) {
            super.onRestoreInstanceState (savedInstanceState);
            text = savedInstanceState.getString ("string");
            reply.setText(text);
        }

    }
    // Increment the variable by one and print its value.
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState (outState);
        outState.putString ("string", reply.getText().toString());
    }
}

