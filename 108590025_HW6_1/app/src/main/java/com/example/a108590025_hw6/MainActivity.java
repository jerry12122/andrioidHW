package com.example.a108590025_hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  CheckBox CHK_BOXES1,CHK_BOXES2,CHK_BOXES3,CHK_BOXES4,CHK_BOXES5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CHK_BOXES1 = (CheckBox)findViewById(R.id.checkBox);
        CHK_BOXES2 = (CheckBox)findViewById(R.id.checkBox2);
        CHK_BOXES3 = (CheckBox)findViewById(R.id.checkBox3);
        CHK_BOXES4 = (CheckBox)findViewById(R.id.checkBox4);
        CHK_BOXES5 = (CheckBox)findViewById(R.id.checkBox5);
    }
    public void displayToast(String message) {
        Toast toast = Toast.makeText(this,message,
                Toast.LENGTH_SHORT);
        toast.show();
        /*
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();*/
    }
    public void onButtonClicked(View view) {
        // Is the button now checked?

        String toast = "Toppings:" ;
        boolean checked = false;
        if(CHK_BOXES1.isChecked()){
            toast = toast + " " + getString(R.string.chocolate_syrup);

            checked = true;
        }
        if(CHK_BOXES2.isChecked()){
            toast = toast + " " + getString(R.string.sprinkles);
            checked = true;
        }
        if(CHK_BOXES3.isChecked()){
            toast = toast + " " + getString(R.string.crushed_nuts);
            checked = true;
        }
        if(CHK_BOXES4.isChecked()){
            toast = toast + " " + getString(R.string.cherries);
            checked = true;
        }
        if(CHK_BOXES5.isChecked()){
            toast = toast + " " + getString(R.string.orio_cookie_crumbles);
            checked = true;
        }
        if(checked)
        {
            displayToast(toast);
        }

    }
}