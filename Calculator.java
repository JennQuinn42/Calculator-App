package com.example.jennquinn.myhopefullyworkingapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity {

    private String calculations = "";

    public void onClick(View view){
        TextView calcs = (TextView)findViewById(R.id.txt_show_calcs);
        calcs.setText("testing");
        ArrayList<String> numbers = new ArrayList<String>();
        Button buttonClicked = (Button) view;
       String num = "";

        Toast.makeText(getApplicationContext(),"It's clicking" + buttonClicked.getText(), Toast.LENGTH_SHORT).show();

        switch(buttonClicked.getText().toString()){
            case "CLEAR": calculations = ""; break;
            case "+": numbers.add(num); numbers.add("+");calculations += num + "="; break;
            case "-": numbers.add(num); numbers.add("-"); calculations += num + "="; break;
            case "/": numbers.add(num); numbers.add("/"); calculations += num + "="; break;
            case "x": numbers.add(num); numbers.add("x"); calculations += num + "="; break;
            case "=": numbers.add(num); numbers.add("="); calculations += num + "="; calculate(numbers); break;
            default: num += buttonClicked.getText().toString(); calculations +=num; break;
        }

        calcs.setText(calculations);

    }

    public void calculate(ArrayList<String> numbers){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Intent calculator = getIntent();
        String name = calculator.getStringExtra(MainActivity.USER_NAME_KEY);

        if(name.isEmpty()){
            setTitle("Simple Calculator");
        }else {
            setTitle(name + "'s Calculator");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
