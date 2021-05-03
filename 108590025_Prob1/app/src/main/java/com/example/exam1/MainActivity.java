package com.example.exam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "transfer";
    private EditText name ;
    private EditText age ;
    private RadioButton rb1 ;
    private RadioButton rb2 ;
    private CheckBox Sport ;
    private CheckBox Movie ;
    private CheckBox Reading ;
    private TextView header;
    private TextView message;
    private String[] text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = getIntent().getStringArrayExtra("CustomObject");
        name = findViewById(R.id.name);
        age = findViewById(R.id.txtAge);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        Sport = (CheckBox) findViewById(R.id.checkBox);
        Movie = (CheckBox) findViewById(R.id.checkBox2);
        Reading = (CheckBox) findViewById(R.id.checkBox3);
        header = findViewById(R.id.text_header_reply);
        message = findViewById(R.id.text_message_reply);

        if(null != savedInstanceState)

        {//因為Activity的生命周期原因 ，if 語句放著不一定能執行得到 應該結合實際情況

            text = savedInstanceState.getStringArray("StrTest");

            //String StrTest = savedInstanceState.getString("StrTest");

        }



    }
    public void displayToast(String message) {
        Toast toast = Toast.makeText(this,message,
                Toast.LENGTH_SHORT);
        toast.show();
    }
    public void onRadioButtonClicked(View v)
    {
        //require to import the RadioButton class



        //is the current radio button now checked?
        boolean  checked = ((RadioButton) v).isChecked();

        //now check which radio button is selected
        //android switch statement
        switch(v.getId()){

            case R.id.radioButton:
                if(checked)
                    displayToast("Male");
                break;

            case R.id.radioButton2:
                if(checked)
                    displayToast("Female");
                break;
        }
    }
    public void onCheckBoxClicked(View v)
    {
        //require to import the RadioButton class


        //is the current radio button now checked?
        boolean  checked = ((CheckBox) v).isChecked();

        //now check which radio button is selected
        //android switch statement
        switch(v.getId()){

            case R.id.checkBox:
                if(checked)
                    displayToast("Sport");
                break;
            case R.id.checkBox2:
                if(checked)
                    displayToast("Movie");
                break;
            case R.id.checkBox3:
                if(checked)
                    displayToast("Reading");
                break;
        }
    }
    public void buttonClick(View view)
    {
        String[] data = new String[]{"name","gender","age","0","0","0"};
        data[0] = (name.getText().toString());
        if(rb1.isChecked())
        {
            data[1] = ("Male");
        }else if(rb2.isChecked()){
            data[1] = ("Female");
        }
        data[2] = (age.getText().toString());
        if(Sport.isChecked()){
            data[3] = ("Sport");
        }
        else data[3] = "0";
        if(Movie.isChecked()){
            data[4] = ("Movie");
        } else data[4] = "0";
        if(Reading.isChecked()){
            data[5] = ("Reading");
        } else data[5] = "0";

        Intent intent = new Intent(view.getContext(), MainActivity2.class);
        intent.putExtra(EXTRA_MESSAGE,data);
        view.getContext().startActivity(intent);
    }
    @Override

    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        text = savedInstanceState.getStringArray("StrTest");
        message.setVisibility(View.VISIBLE);
        header.setVisibility((View.VISIBLE));
        header.setText("Reply Received:");
        message.setText(text[6]);
        name.setText(text[0]);
        if(text[1].equals("Male")){
            rb1.setChecked(true);
        }else if(text[1].equals("Female"))
        {
            rb2.setChecked(true);
        }
        age.setText(text[2]);
        if(text[3].equals("Sport")){
            Sport.setChecked(true);
        }
        if(text[4].equals("Movie")){
            Movie.setChecked(true);
        }
        if(text[5].equals("Reading"))
        {
            Reading.setChecked(true);
        }

    }
}