package com.example.jennquinn.myhopefullyworkingapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String USER_NAME_KEY = "Username Key";

    public void onBtnOkayClick(View view){
        EditText input = (EditText)findViewById(R.id.txt_name_input);

        String name = input.getText().toString();

        //Toast.makeText(getApplicationContext(), "Hello there " + name, Toast.LENGTH_LONG).show();

        Intent it = new Intent(this, Calculator.class);
        it.putExtra(USER_NAME_KEY, name);
        startActivity(it);

    }

    public void clickedLayout(View view){
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();

        InputMethodManager keyboardManage = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        keyboardManage.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView cat = (ImageView) findViewById(R.id.imgcat);

        cat.setImageResource(R.drawable.agitated_cat);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
