package com.neatandclean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {

    TextView resultLabel,totalScoreLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_result );


        resultLabel = findViewById ( R.id.resultLabel );
        totalScoreLabel = findViewById ( R.id.totalScoreLabel );

        String sc= getIntent ().getStringExtra ("CurrentSc");
        resultLabel.setText ( "Your score is :"+sc );

        /*Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        SharedPreferences settings = getSharedPreferences("NeatamdClean", Context.MODE_PRIVATE);
        int totalScore = settings.getInt("totalScore", 0);
        totalScore += score;


        totalScoreLabel.setText("Total Score : " + totalScore);

        resultLabel.setText("Your Score: " + score);*/
    }

        @Override
        protected void onResume ()
        {
            super.onResume ();
            SharedPreferences sharedPreferences = getSharedPreferences ( "MyPref", Context.MODE_PRIVATE );
            String txt = sharedPreferences.getString ( "name", "" );
            String txt2 = sharedPreferences.getString ( "surname", "" );

            totalScoreLabel.setText ( txt +" "+txt2);



        }

        @Override
        protected void onPause () {
            super.onPause ();
            SharedPreferences sharedPref = this.getSharedPreferences ( "MyPref", Context.MODE_PRIVATE );
            SharedPreferences.Editor editor = sharedPref.edit ();
            editor.putString ( "name"+"surname", totalScoreLabel.getText ().toString () );



            editor.commit ();
        }

    }

