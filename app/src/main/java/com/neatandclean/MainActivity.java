package com.neatandclean;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.media.MediaPlayer;

import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import static com.neatandclean.R.layout.activity_main;


public class MainActivity extends AppCompatActivity {


    EditText editText,editText2;

    ImageView imageView;


    Button button7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( activity_main );

        imageView = findViewById ( R.id.imageView );

      /*  editText = findViewById ( R.id.editText );
        editText2 = findViewById ( R.id.editText2 );
        button7 = findViewById ( R.id.button7 );*/

        MediaPlayer player = MediaPlayer.create ( getApplicationContext (), R.raw.garbage );
        player.setLooping ( true );
        player.start ();

        Thread splash= new Thread (  )
        {
            @Override
            public void run() {
                super.run ();
                try {
                    sleep ( 5000 );
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
                finally
                {
                    Intent intent = new Intent ( MainActivity.this, LogIN.class );
                    startActivity ( intent );
                    finish ();
                }
            }
        };
        splash.start();





/*
        button7.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( MainActivity.this, Questions.class );
                startActivity ( intent );
                finish ();
            }
        } );*/

    }

       /* @Override
        protected void onResume()
        {
            super.onResume ();
            SharedPreferences sharedPreferences= getSharedPreferences ( "MyPref", Context.MODE_PRIVATE );
            String txt = sharedPreferences.getString("name", "");
            String txt2 = sharedPreferences.getString("surname", "");

            editText.setText(txt);
            editText2.setText ( txt2);


        }

        @Override
        protected void onPause(){
            super.onPause();
            SharedPreferences sharedPref = this.getSharedPreferences ( "MyPref", Context.MODE_PRIVATE );
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("name", editText.getText().toString());
            editor.putString("surname", editText2.getText().toString());



            editor.commit();
        }







*/

   /*    button = (Button) findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });



    }

    public void openActivity2() {
        Intent intent = new Intent(this, Questions.class);
        startActivity(intent);



    }*/


}





