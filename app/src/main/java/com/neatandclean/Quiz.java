package com.neatandclean;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quiz extends AppCompatActivity {
    //String  alertTitle;
    Button button, button2, button3, button4, button5, button6;
    private MediaPlayer player;
    int mScore=0;

    TextView txtvwView,textView;
    ImageView question;
    List<ImgQue> list;
    Random r;
    int turn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

      /*  player =  MediaPlayer.create(getApplicationContext(), R.raw.shakti);
        player.setLooping(true);
        player.start();*/

       //String Ti= String.valueOf ( getIntent ().getParcelableExtra  ( "CountDownTimer" ) );
       //textView.setText ( Ti );

        r = new Random();

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6) ;



       txtvwView = (TextView) findViewById(R.id.score);
        question = (ImageView) findViewById(R.id.question);
        textView = findViewById ( R.id.textView );

      //  String output =getIntent ().getExtras ().getString ( "counter1" );

        list = new ArrayList<>();



        for (int i =0; i< new Database().answers.length; i++){
            list.add(new ImgQue(new Database().answers[i], new Database().photo[i]));
        }

       Collections.shuffle(list);

        newQue(turn);
        score (mScore);







        button.setOnClickListener(new View.OnClickListener() {

           Drawable bg =button.getBackground (  );


            @Override
            public void onClick(View v) {

            if(button.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())) {

                Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();

                button.setBackgroundColor (Color.parseColor ("#0BA710"));
                button.postDelayed ( new Runnable () {
                    @Override
                    public void run() {
                        button.setBackgroundColor ( Color.parseColor ( "#FFFFFF" ));
                        mScore++;
                        txtvwView.setText ( "Score is "+mScore );
                      // mScore=mScore++;
                        //txtvwView.setText ( mScore );
                    }
                }, 3000);
               /* AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(null);
                builder.setTitle(alertTitle);
                builder.setMessage("answer : ");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });*/

                player = MediaPlayer.create(getApplicationContext(), R.raw.yes);
               //player.setLooping(true);
                player.start();
               // Intent intent = new Intent(getApplicationContext(),Result.class);


                //player.pause();


                if (turn < list.size()) {
                    //button.setBackgroundColor ( Color.parseColor ( "#FFFFFF" ) );
                    turn++;
                    newQue(turn);


                } else {
                    Toast.makeText(Quiz.this, "Bravo You finished the game", Toast.LENGTH_SHORT).show();
                  Intent  intent = new Intent(getApplicationContext(), Result.class);
                  intent.putExtra ( "CurrentSc", mScore );
                    startActivity(intent);
                 /*  intent.putExtra("score", mScore);
                    startActivity(intent);
                    finish();
*/

                }

            }
            else if(turn < list.size())
            {
                turn++;
                newQue(turn);
                button.setBackgroundResource(R.color.Wrong);
                Toast.makeText(Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();
                player = MediaPlayer.create(getApplicationContext(), R.raw.buzz);
                //player.setLooping(true);
                player.start();

                button.postDelayed ( new Runnable () {
                    @Override
                    public void run() {
                        button.setBackgroundColor ( Color.parseColor ( "#FFFFFF" ));
                    }
                }, 3000);


                // Toast.makeText(Quiz.this, "Better luck next time", Toast.LENGTH_SHORT).show();
                // finish();


            }
            else  {
                Intent intent = new Intent(getApplicationContext (),Result.class);

                intent.putExtra ( "CurrentSc", mScore );
                startActivity(intent);// intent.putExtra("score",  mScore);
                //startActivity(intent);

            }

            }
        });
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())) {
                    button2.setBackgroundColor (Color.parseColor ("#0BA710"));
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                    player = MediaPlayer.create(getApplicationContext(), R.raw.yes);
                    //player.setLooping(true);
                    player.start();

                    //player.pause();


                    button2.postDelayed ( new Runnable () {
                        @Override
                        public void run() {
                            button2.setBackgroundColor ( Color.parseColor ( "#FFFFFF" ));
                            mScore++;
                            txtvwView.setText ( "Score is "+mScore );
                           // mScore=mScore++;
                            //txtvwView.setText ( mScore );
                        }
                    }, 3000);


                    if (turn <list.size()) {
                        turn++;
                        newQue(turn);
                    } else {
                        Toast.makeText(Quiz.this, "Bravo You finished the game", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Result.class);
                        intent.putExtra ( "CurrentSc", mScore );
                        startActivity ( intent );


                     /*  intent.putExtra("score",  mScore);
                        startActivity(intent);
                        finish();
*/
                    }

                }
                else if(turn <list.size())
                {
                    turn++;
                    newQue(turn);
                    button2.setBackgroundResource ( R.color.Wrong );
                    Toast.makeText(Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();
                    player = MediaPlayer.create(getApplicationContext(), R.raw.buzz);
                    //player.setLooping(true);
                    player.start();
                    // Toast.makeText(Quiz.this, "Better luck next time", Toast.LENGTH_SHORT).show();
                    // finish();
                    button2.postDelayed ( new Runnable () {
                        @Override
                        public void run() {
                            button2.setBackgroundColor ( Color.parseColor ( "#FFFFFF" ));
                          //  mScore=mScore++;
                            //txtvwView.setText ( mScore );
                        }
                    }, 3000);


                }
                else  {

                    Intent intent = new Intent(getApplicationContext(),Result.class);
                    intent.putExtra ( "CurrentSc", mScore );
                    startActivity ( intent );
  //                  intent.putExtra("score",  mScore);
    //                startActivity(intent);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())) {
                    button3.setBackgroundColor (Color.parseColor ("#0BA710"));
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                    player = MediaPlayer.create(getApplicationContext(), R.raw.yes);
                   // player.setLooping(true);
                    player.start();
                    //player.pause();


                    button3.postDelayed ( new Runnable () {
                        @Override
                        public void run() {
                            button3.setBackgroundColor ( Color.parseColor ( "#FFFFFF" ));
                            mScore++;
                            txtvwView.setText ( "Score is "+mScore );
                         //   mScore=mScore++;
                           // txtvwView.setText ( mScore );
                        }
                    }, 3000);

                    if (turn < list.size()) {
                        turn++;
                        newQue(turn);
                    } else {
                        Toast.makeText(Quiz.this, "Bravo You finished the game", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Result.class);
                        intent.putExtra ( "CurrentSc", mScore );
                        startActivity ( intent );
      /*                  intent.putExtra("score", mScore);
                        startActivity(intent);
                        finish();
       */
                    }

                }
                else if(turn < list.size())
                {
                    turn++;
                    newQue(turn);
                    button3.setBackgroundResource ( R.color.Wrong );
                    Toast.makeText(Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();
                    player = MediaPlayer.create(getApplicationContext(), R.raw.buzz);
                    //player.setLooping(true);
                    player.start();
                    // Toast.makeText(Quiz.this, "Better luck next time", Toast.LENGTH_SHORT).show();
                    // finish();

                    button3.postDelayed ( new Runnable () {
                        @Override
                        public void run() {
                            button3.setBackgroundColor ( Color.parseColor ( "#FFFFFF" ));
                            //   mScore=mScore++;
                            // txtvwView.setText ( mScore );
                        }
                    }, 3000);


                }
                else  {
                    Intent intent = new Intent(getApplicationContext(), Result.class);
                    intent.putExtra ( "CurrentSc", mScore );
                    startActivity ( intent );
                  //  intent.putExtra("score",  mScore);
                    //startActivity(intent);
                }

            }
        });

         button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())) {
                    button4.setBackgroundColor (Color.parseColor ("#0BA710"));
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                    player = MediaPlayer.create(getApplicationContext(), R.raw.yes);
                    //player.setLooping(true);
                    player.start();
                    //player.pause();


                    button4.postDelayed ( new Runnable () {
                        @Override
                        public void run() {
                            button4.setBackgroundColor ( Color.parseColor ( "#FFFFFF" ));
                            mScore++;
                            txtvwView.setText ( "Score is "+mScore );
                           // mScore=mScore++;
                            //txtvwView.setText ( mScore );
                        }
                    }, 3000);

                    if (turn < list.size()) {
                        turn++;
                        newQue(turn);
                    } else {
                        Toast.makeText(Quiz.this, "Bravo You finished the game", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Result.class);
                        intent.putExtra ( "CurrentSc", mScore );
                        startActivity ( intent );
                      /*  intent.putExtra("score", mScore);
                        startActivity(intent);
                        finish();
*/
                    }

                }
                else if(turn < list.size())
                {
                    turn++;
                    newQue(turn);
                    button4.setBackgroundResource ( R.color.Wrong );
                    Toast.makeText(Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();
                    player = MediaPlayer.create(getApplicationContext(), R.raw.buzz);
                    //player.setLooping(true);
                    player.start();
                    // Toast.makeText(Quiz.this, "Better luck next time", Toast.LENGTH_SHORT).show();
                    // finish();

                    button4.postDelayed ( new Runnable () {
                        @Override
                        public void run() {
                            button4.setBackgroundColor ( Color.parseColor ( "#FFFFFF" ));

                            // mScore=mScore++;
                            //txtvwView.setText ( mScore );
                        }
                    }, 3000);


                }
                else  {
                    Intent intent = new Intent(getApplicationContext(),Result.class);
                    intent.putExtra ( "CurrentSc", mScore );
                    startActivity ( intent );
  //                  intent.putExtra("score",  mScore);
    //                startActivity(intent);
                }

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(button5.getText().toString().equalsIgnoreCase(list.get(turn-1).getName()) && (button5.getText ().equals ( "Mixed" ))) {
                    button5.setBackgroundColor ( Color.parseColor ("#0BA710"));
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();

                    player = MediaPlayer.create(getApplicationContext(), R.raw.yes);
                    //player.setLooping(true);
                    player.start();
                    //player.pause();


                    button5.postDelayed ( new Runnable () {
                        @Override
                        public void run() {
                            button5.setBackgroundColor ( Color.parseColor ( "#FFFFFF" ));
                            mScore++;
                            txtvwView.setText ( "Score is "+mScore );
                            //mScore=mScore++;
                            //txtvwView.setText ( mScore );
                        }
                    }, 3000);

                    if (turn < list.size()) {
                        turn++;
                        newQue(turn);
                    } else {
                        Toast.makeText(Quiz.this, "Bravo You finished the game", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Result.class);
                        intent.putExtra ( "CurrentSc", mScore );
                        startActivity ( intent );
                      /*  intent.putExtra("score", mScore);
                        startActivity(intent);
                        finish();
*/
                    }

                }
                else if(turn < list.size())
                {
                    turn++;
                    newQue(turn);
                    button5.setBackgroundResource(R.color.Wrong);
                    Toast.makeText(Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();
                    player = MediaPlayer.create(getApplicationContext(), R.raw.buzz);
                    //player.setLooping(true);
                    player.start();
                    // Toast.makeText(Quiz.this, "Better luck next time", Toast.LENGTH_SHORT).show();
                    // finish();

                    button5.postDelayed ( new Runnable () {
                        @Override
                        public void run() {
                            button5.setBackgroundColor ( Color.parseColor ( "#FFFFFF" ));
                            //mScore=mScore++;
                            //txtvwView.setText ( mScore );
                        }
                    }, 3000);

                }
                else  {

                    Intent intent = new Intent(getApplicationContext(),Result.class);
                    intent.putExtra ( "CurrentSc", mScore );
                    startActivity ( intent );
                    //                  intent.putExtra("score",  mScore);
                    //                startActivity(intent);
                }

            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button6.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())) {
                    button6.setBackgroundColor (Color.parseColor ("#0BA710"));
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                    player = MediaPlayer.create(getApplicationContext(), R.raw.yes);
                    //player.setLooping(true);
                    player.start();
                    //player.pause();


                    button6.postDelayed ( new Runnable () {
                        @Override
                        public void run() {
                            button6.setBackgroundColor ( Color.parseColor ( "#FFFFFF" ));
                            mScore++;
                            txtvwView.setText ( "Score is "+mScore );
                          //  Log.d("Message tag",txtvwView.getText().toString());
                           // mScore=mScore++;
                            //txtvwView.setText ( mScore );
                        }
                    }, 3000);

                    if (turn < list.size())
                    {
                        turn++;
                        newQue(turn);
                    }

                    else
                        {
                        Toast.makeText(Quiz.this, "Bravo You finished the game", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Result.class);
                        intent.putExtra ( "CurrentSc", mScore );
                        startActivity ( intent );
                      /*  intent.putExtra("score", mScore);
                        startActivity(intent);
                        finish();
*/
                    }

                }
                else if(turn < list.size())
                {
                    turn++;
                    newQue(turn);
                    button6.setBackgroundResource ( R.color.Wrong );
                    Toast.makeText(Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();
                    player = MediaPlayer.create(getApplicationContext(), R.raw.buzz);
                    //player.setLooping(true);
                    player.start();
                    // Toast.makeText(Quiz.this, "Better luck next time", Toast.LENGTH_SHORT).show();
                    // finish();
                    button6.postDelayed ( new Runnable () {
                        @Override
                        public void run() {
                            button6.setBackgroundColor ( Color.parseColor ( "#FFFFFF" ));
                            // mScore=mScore++;
                            //txtvwView.setText ( mScore );
                        }
                    }, 3000);


                }
                else  {
                    Intent intent = new Intent(getApplicationContext(),Result.class);
                    intent.putExtra ( "CurrentSc", mScore );
                    startActivity ( intent );
                    //                  intent.putExtra("score",  mScore);
                    //                startActivity(intent);
                }

            }
        });


    }

        public void score(int mScore)
        {
          mScore=0;


        }

        public void newQue(int number){
        question.setImageResource(list.get(number - 1).getImage());

       int correct_answer = r.nextInt();


       int firstButton = number - 1;
       int secondButton ;
       int thirdButton;
       int forthButton ;
       int fifthButton;
       int sixthButton;

       switch (correct_answer) {
           case 1:
               button.setText(list.get(firstButton).getName());
               do {
                   secondButton = r.nextInt(list.size());
               }
               while (secondButton == firstButton);
               do {
                   thirdButton = r.nextInt(list.size());
               }
               while (thirdButton == firstButton || thirdButton == secondButton);

               do {
                   forthButton = r.nextInt(list.size());
               }
               while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

               do {
                   fifthButton = r.nextInt(list.size());
               }
               while ( fifthButton == firstButton || fifthButton == secondButton || fifthButton == thirdButton || fifthButton == forthButton);

               do {
                   sixthButton = r.nextInt(list.size());
               }
               while (sixthButton == firstButton || sixthButton == secondButton || sixthButton == thirdButton || sixthButton == forthButton || sixthButton == fifthButton);

               button2.setText(list.get(secondButton).getName());
               button3.setText(list.get(thirdButton).getName());
               button4.setText(list.get(forthButton).getName());
               button5.setText(list.get(fifthButton).getName());
               button6.setText(list.get(sixthButton).getName());


               break;

           case 2:
               button2.setText(list.get(firstButton).getName());
               do {
                   secondButton = r.nextInt(list.size());
               }
               while (secondButton == firstButton);
               do {
                   thirdButton = r.nextInt(list.size());
               }
               while (thirdButton == firstButton || thirdButton == secondButton);

               do {
                   forthButton = r.nextInt(list.size());
               }
               while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

               do {
                   fifthButton = r.nextInt(list.size());
               }
               while ( fifthButton == firstButton || fifthButton == secondButton || fifthButton == thirdButton || fifthButton == forthButton);

               do {
                   sixthButton = r.nextInt(list.size());
               }
               while (sixthButton == firstButton || sixthButton == secondButton || sixthButton == thirdButton || sixthButton == forthButton || sixthButton == fifthButton);

               button.setText(list.get(secondButton).getName());
               button3.setText(list.get(thirdButton).getName());
               button4.setText(list.get(forthButton).getName());
               button5.setText(list.get(fifthButton).getName());
               button6.setText(list.get(sixthButton).getName());

               break;
           case 3:
               button3.setText(list.get(firstButton).getName());
               do {
                   secondButton = r.nextInt(list.size());
               }
               while (secondButton == firstButton);
               do {
                   thirdButton = r.nextInt(list.size());
               }
               while (thirdButton == firstButton || thirdButton == secondButton);

               do {
                   forthButton = r.nextInt(list.size());
               }
               while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

               do {
                   fifthButton = r.nextInt(list.size());
               }
               while ( fifthButton == firstButton || fifthButton == secondButton || fifthButton == thirdButton || fifthButton == forthButton);

               do {
                   sixthButton = r.nextInt(list.size());
               }
               while (sixthButton == firstButton || sixthButton == secondButton || sixthButton == thirdButton || sixthButton == forthButton || sixthButton == fifthButton);

               button2.setText(list.get(secondButton).getName());
               button.setText(list.get(thirdButton).getName());
               button4.setText(list.get(forthButton).getName());
               button5.setText(list.get(fifthButton).getName());
               button6.setText(list.get(sixthButton).getName());


               break;

           case 4:

               button4.setText(list.get(firstButton).getName());
               do {
                   secondButton = r.nextInt(list.size());
               }
               while (secondButton == firstButton);
               do {
                   thirdButton = r.nextInt(list.size());
               }
               while (thirdButton == firstButton || thirdButton == secondButton);

               do {
                   forthButton = r.nextInt(list.size());
               }
               while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

               do {
                   fifthButton = r.nextInt(list.size());
               }
               while ( fifthButton == firstButton || fifthButton == secondButton || fifthButton == thirdButton || fifthButton == forthButton);

               do {
                   sixthButton = r.nextInt(list.size());
               }
               while (sixthButton == firstButton || sixthButton == secondButton || sixthButton == thirdButton || sixthButton == forthButton || sixthButton == fifthButton);

               button2.setText(list.get(secondButton).getName());
               button3.setText(list.get(thirdButton).getName());
               button.setText(list.get(forthButton).getName());
               button5.setText(list.get(fifthButton).getName());
               button6.setText(list.get(sixthButton).getName());


               break;

           case 5:
               button5.setText(list.get(firstButton).getName());
               do {
                   secondButton = r.nextInt(list.size());
               }
               while (secondButton == firstButton);
               do {
                   thirdButton = r.nextInt(list.size());
               }
               while (thirdButton == firstButton || thirdButton == secondButton);

               do {
                   forthButton = r.nextInt(list.size());
               }
               while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

               do {
                   fifthButton = r.nextInt(list.size());
               }
               while ( fifthButton == firstButton || fifthButton == secondButton || fifthButton == thirdButton || fifthButton == forthButton);

               do {
                   sixthButton = r.nextInt(list.size());
               }
               while (sixthButton == firstButton || sixthButton == secondButton || sixthButton == thirdButton || sixthButton == forthButton || sixthButton == fifthButton);

               button2.setText(list.get(secondButton).getName());
               button3.setText(list.get(thirdButton).getName());
               button4.setText(list.get(forthButton).getName());
               button.setText(list.get(fifthButton).getName());
               button6.setText(list.get(sixthButton).getName());



               break;

           case 6:
               button6.setText(list.get(firstButton).getName());
               do {
                   secondButton = r.nextInt(list.size());
               }
               while (secondButton == firstButton);
               do {
                   thirdButton = r.nextInt(list.size());
               }
               while (thirdButton == firstButton || thirdButton == secondButton);

               do {
                   forthButton = r.nextInt(list.size());
               }
               while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

               do {
                   fifthButton = r.nextInt(list.size());
               }
               while ( fifthButton == firstButton || fifthButton == secondButton || fifthButton == thirdButton || fifthButton == forthButton);

               do {
                   sixthButton = r.nextInt(list.size());
               }
               while (sixthButton == firstButton || sixthButton == secondButton || sixthButton == thirdButton || sixthButton == forthButton || sixthButton == fifthButton);

               button2.setText(list.get(secondButton).getName());
               button3.setText(list.get(thirdButton).getName());
               button4.setText(list.get(forthButton).getName());
               button5.setText(list.get(fifthButton).getName());
               button.setText(list.get(sixthButton).getName());




               break;

       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater ();
        inflater.inflate( R.menu.example_menu, menu );
        return true;
    }

    //to perform item pressed tasks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId ())
        {
            case R.id.item1:
                Toast.makeText ( this, "You pressed Pause", Toast.LENGTH_SHORT ).show ();
                return true;
            case R.id.item2:
                AlertDialog.Builder alertbox= new AlertDialog.Builder (  this);

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
                //  Toast.makeText ( this, "You pressed Quit", Toast.LENGTH_SHORT ).show ();
                return true;

            default:
                return super.onOptionsItemSelected ( item );

        }

    }

}
