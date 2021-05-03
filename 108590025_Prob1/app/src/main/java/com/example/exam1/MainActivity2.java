package com.example.exam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.LinkedList;

public class MainActivity2 extends AppCompatActivity {
    private  Spinner spinner;
    private  String[] sp,data;
    private TextView name2,gender2,age2,hobby2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name2 = findViewById(R.id.name2);
        gender2 = findViewById(R.id.gender2);
        age2 = findViewById(R.id.age2);
        hobby2 = findViewById(R.id.hobby);


        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =
            ArrayAdapter.createFromResource(this,    //對應的Context
                R.array.spinner,                             //資料選項內容
                android.R.layout.simple_spinner_item);  //預設Spinner未展開時的View(預設及選取後樣式)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(spnOnItemSelected);

        Resources res = getResources();
        sp= res.getStringArray(R.array.spinner);


        Intent intent = getIntent();
        data =  intent.getStringArrayExtra("transfer");
        name2.setText(data[0]);
        gender2.setText(data[1]);
        age2.setText(data[2]);
        String hobbys = "";
        if(data[3].equals("Sport")){
            hobbys += (data[3] + " ");
        }
        if(data[4].equals("Movie")){
            hobbys += (data[4] + " ");
        }
        if(data[5].equals("Reading")){
            hobbys += (data[5] + " ");
        }
        hobby2.setText(hobbys);
        System.out.println("list:"+ Arrays.deepToString(data));


    }
    public void displayToast(String message) {
        Toast toast = Toast.makeText(this,message,
                Toast.LENGTH_SHORT);
        toast.show();
    }
    private AdapterView.OnItemSelectedListener spnOnItemSelected
            = new AdapterView.OnItemSelectedListener() {


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            displayToast(sp[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

    };
    public void replyClick(View view ){
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        Bundle bundle = new Bundle();

        String[] res = new String[]{data[0],data[1],data[2],data[3],data[4],data[5],spinner.getSelectedItem().toString()};
        bundle.putStringArray("StrTest", res);
        //super.onSaveInstanceState(bundle);
        intent.putExtras(bundle);
        view.getContext().startActivity(intent);
    }




}