package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 0: for yellow , 1: for red & 2:for empty
    int[] gameState ={2,2,2,2,2,2,2,2,2};
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activePlayer=0;
    boolean gameActive=true;
    public void dropIn(View view){
        ImageView counter=(ImageView) view;

        int tappedCounter=Integer.parseInt(counter.getTag().toString());
      if(gameState[tappedCounter]==2&& gameActive){
       gameState[tappedCounter]=activePlayer;

        counter.setTranslationY(-1500);
        if(activePlayer==0) {
            counter.setImageResource(R.drawable.yellow);
            activePlayer = 1;
        }else{
            counter.setImageResource(R.drawable.red);
            activePlayer = 0;
        }
        counter.animate().translationYBy(1500).rotationBy(360).setDuration(1);
        for(int[] winningposition : winningPositions) {
            if (gameState[winningposition[0]] == gameState[winningposition[1]] && gameState[winningposition[1]] == gameState[winningposition[2]]
                    && gameState[winningposition[0]] != 2) {
                //some has won
                gameActive=false;
                String winner = "";
                if (activePlayer == 1) {
                    winner = "  YELLOW HAS WON!!!!";  // it means winner is yellow guy
                } else {
                    winner = " RED HAS WON!!!!";      // it means winner is red guy
                }
              //  Toast.makeText(this, winner, Toast.LENGTH_LONG).show();
                Button playAgainButton=(Button) findViewById(R.id.button);
                TextView winnerTextView=(TextView) findViewById(R.id.textView);
                winnerTextView.setText(winner);
                playAgainButton.setVisibility(View.VISIBLE);
                winnerTextView.setVisibility(View.VISIBLE);
            }
        }
        }
    }
    public void qwe(View view){
        Button  playAgainButton=(Button) findViewById(R.id.button);

        TextView winnerTextView=(TextView) findViewById(R.id.textView);

        playAgainButton.setVisibility(View.INVISIBLE);

        winnerTextView.setVisibility(View.INVISIBLE);

        GridLayout grid = (GridLayout) findViewById(R.id.gridLayout);

        for(int ab=0 ; ab<grid.getChildCount() ; ab++){

            ImageView counter=(ImageView) grid.getChildAt(ab);

            counter.setImageDrawable(null);
        }
        for(int j=0 ; j<gameState.length ; j++) {
            gameState[j]=2;
        }

        activePlayer=0;
        gameActive=true;
    }
    public void rest(View view){Button  playAgainButton=(Button) findViewById(R.id.button);

        TextView winnerTextView=(TextView) findViewById(R.id.textView);

        playAgainButton.setVisibility(View.INVISIBLE);

        winnerTextView.setVisibility(View.INVISIBLE);
        GridLayout grid = (GridLayout) findViewById(R.id.gridLayout);

        for(int ab=0 ; ab<grid.getChildCount() ; ab++){

            ImageView counter=(ImageView) grid.getChildAt(ab);

            counter.setImageDrawable(null);
        }
        for(int j=0 ; j<gameState.length ; j++) {
            gameState[j]=2;
        }

        activePlayer=0;
        gameActive=true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //translation annimatoin for grid layout
        GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLayout);
        gridLayout.setX(-970);
        gridLayout.animate().translationXBy(970).rotationBy(360*8).setDuration(2100);

        //translation annimation for constraint layout
        ConstraintLayout constrain=(ConstraintLayout) findViewById(R.id.constrain);
        constrain.setX(-1000);
        constrain.animate().translationXBy(1000) .setDuration(2100);

        //translation annimation for rest button
        Button  button2=(Button) findViewById(R.id.button2);
        button2.setX(-2100);
        button2.animate().translationXBy(2100).rotationBy(360*4).setDuration(2100);

        //translate annimation for text view which shows tic tac heading
        TextView textView2=(TextView)findViewById(R.id.textView2);
        textView2.setX(-2100);
        textView2.animate().translationXBy(2000).rotationBy(360*4).setDuration(2100);
    }
}
