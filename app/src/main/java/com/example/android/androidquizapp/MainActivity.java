package com.example.android.androidquizapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Custom font TypeFace for welcome slogan
        TextView welcomeTextView = (TextView)findViewById(R.id.welcomeTextView);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/android_7.ttf");
        welcomeTextView.setTypeface(custom_font);

        //TextView bugsTextView = (TextView)findViewById(R.id.bugs);
        //Typeface bugs = Typeface.createFromAsset(getAssets(),  "fonts/BinarySoldiers II.ttf");
        //bugsTextView.setTypeface(bugs);

        // Name
        EditText nameEditTextView = (EditText) findViewById(R.id.nameEditText);
        userName = nameEditTextView.getText().toString();

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = ((EditText) findViewById(R.id.nameEditText)).getText().toString();

                Intent myIntent = new Intent(getBaseContext(), QuizActivity.class);
                myIntent.putExtra("USER_NAME", userName);
                startActivity(myIntent);
                startActivityForResult(myIntent,0);
            }
        });



    }


}
