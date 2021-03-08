/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.HelloConstraint;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Displays two Buttons and a TextView.
 * - Pressing the TOAST button shows a Toast.
 * - Pressing the COUNT button increases the displayed mCount.
 *
 * Note: Fixing behavior when device is rotated is a challenge exercise for the student.
 */

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button btn_count;
    private Button btn_zero;
    private Button btn_toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        btn_count = (Button) findViewById(R.id.button_count2);
        btn_zero = (Button) findViewById(R.id.button_count);
        btn_toast = (Button) findViewById(R.id.button_toast);
    }

    /*
    * Shows a Toast when the TOAST button is clicked.
    *
    * @param view The view that triggered this onClick handler.
    *             Since a toast always shows on the top,
    *             the passed in view is not used.
    */
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    /*
    * Increments the number in the TextView when the COUNT button is clicked.
    *
    * @param view The view that triggered this onClick handler.
    *             Since the count always appears in the TextView,
    *             the passed in view is not used.
    */
    public void countUp(View view) {
        mCount++;
        if(mCount % 2 == 0)
        {
            btn_count.setBackgroundColor(Color.GREEN);
            btn_zero.setBackgroundColor(Color.MAGENTA);
        }
        else
        {
            btn_count.setBackgroundColor(Color.MAGENTA);
            btn_zero.setBackgroundColor(Color.GREEN);
        }
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void Zero(View view) {
        btn_zero.setBackgroundColor(Color.DKGRAY);
        btn_count.setBackgroundColor(Color.BLUE);
        btn_toast.setBackgroundColor(Color.BLUE);
        mShowCount.setText("0");
    }


}
