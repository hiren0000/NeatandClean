package com.neatandclean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogIN extends AppCompatActivity {

   EditText editText, editText2;
    Button go;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_log_in );

        editText= findViewById ( R.id.editText );
        editText2 = findViewById ( R.id.editText2 );


        go = findViewById ( R.id.go );


    go.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        Intent intent = new Intent ( LogIN.this, Questions.class );
        startActivity ( intent );

    }

    } );



 }

    @Override
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


}

