package com.neatandclean;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.provider.Settings;
import android.system.Os;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.zip.Inflater;

public class Questions extends AppCompatActivity implements Serializable {

    // public int counter;
    //TextView textView;
    Button button2;

    TextView textView;
    public int co;
    CountDownTimer counter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_questions );
        textView = findViewById ( R.id.textView );


        MediaPlayer player = MediaPlayer.create ( getApplicationContext (), R.raw.garbage );
        player.setLooping ( true );
        player.start ();
        player.stop ();

        //extView = findViewById(R.id.textView);
        button2 = (Button) findViewById ( R.id.btn );


        button2.setOnClickListener ( new View.OnClickListener () {

            Drawable bgp = button2.getBackground ();


            @Override
            public void onClick(View v) {

                Intent intent = new Intent ( Questions.this, Quiz.class );
                //  intent.putExtra ( "CountDownTimer", (Parcelable) counter1 );
                startActivity ( intent );


            }
        } );

    }



     /*            counter1 = new CountDownTimer ( 20000, 1000 ) {
                     @Override
                     public void onTick(long millisUntilFinished) {
                         textView.setText ( "Seconds left: " + (millisUntilFinished) );
                         co++;
                     }

                     @Override
                     public void onFinish() {
                         textView.setText ( "Finsih!!!!" );
                     }
                 };
                 counter1.start ();



    new CountDownTimer(30000, 1000) {
                     @Overri
                     //public void onTick(long millisUntilFinished) {
                        //  textView.setText(String.valueOf(counter));
                          //counter++;




    */


    // Menu item code
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate ( R.menu.example_menu, menu );
        return true;
    }

    //to perform item pressed tasks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId ()) {
            case R.id.item1:
                Toast.makeText ( this, "You pressed Pause", Toast.LENGTH_SHORT ).show ();
                return true;
            case R.id.item2:
                AlertDialog.Builder alertbox = new AlertDialog.Builder ( this );

                alertbox.setTitle ( "Confirmation!!" );
                alertbox.setMessage ( "Are you sure you want to quit?" );
                alertbox.setPositiveButton ( "Yes", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish ();
                        System.exit ( 0 );
                    }
                } );

                alertbox.setNegativeButton ( "No", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        closeOptionsMenu ();
                    }
                } );
                alertbox.show ();

                return true;

            default:
                return super.onOptionsItemSelected ( item );

        }

    }
}



    /*public void Play() {
        //Intent intent = new Intent(this, Quiz.class);
      //  intent.putExtra ( "CountDownTimer", (Parcelable) counter1 );
       // startActivity(intent);
    }*/

