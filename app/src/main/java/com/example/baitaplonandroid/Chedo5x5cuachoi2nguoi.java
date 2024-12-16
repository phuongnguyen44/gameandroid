package com.example.baitaplonandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Chedo5x5cuachoi2nguoi extends AppCompatActivity {
    Button playagain;
    TextView ht;
    int[] gameState={2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
    int[][] winningPositions={{0,1,2,3,4},{5,6,7,8,9},{10,11,12,13,14},{15,16,17,18,19},{20,21,22,23,24},{0,5,10,15,20},{1,6,11,16,21},{2,7,12,17,22},{3,8,13,18,23},{4,9,14,19,24},{0,6,12,18,24},{4,8,12,16,20}};
    int activePlayer=0;
    boolean gameActive=true;
    public void dropin(View view){
        ImageView counter=(ImageView) view;
        int tappedCounter= Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter]==2 && gameActive){
            gameState[tappedCounter]=activePlayer;

            if(activePlayer ==0){
                counter.setImageResource(R.drawable.cho);
                activePlayer=1;
            } else if (activePlayer==1) {
                counter.setImageResource(R.drawable.chx);
                activePlayer=0;
            }
            for (int[] winningPosition : winningPositions){
                if(gameState[winningPosition[0]]==gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] &&gameState[winningPosition[2]] == gameState[winningPosition[3]]&&gameState[winningPosition[3]] == gameState[winningPosition[4]] && gameState[winningPosition[0]] !=2){
                    gameActive=false;
                    String winner="";
                    if(activePlayer ==1){
                        winner="Player 1 win";
                        ht.setText(winner);
                        playagain.setVisibility(View.VISIBLE);

                    }
                    else{
                        winner="Player 2 win";
                        ht.setText(winner);
                        playagain.setVisibility(View.VISIBLE);
                    }
                }
            }


            int count=0;
            for(int i=0 ;i<gameState.length;i++){
                if(gameState[i] !=2){
                    count++;
                }
            }
            if(count ==25 && gameActive){
                ht.setText("Draw");
                playagain.setVisibility(View.VISIBLE);
                gameActive=false;
            }




        }
    }
    public void reset(View view){
        GridLayout gridLayout=(GridLayout) findViewById(R.id.table3);
        for (int i=0;i<gridLayout.getChildCount();i++){
            ImageView counter=(ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }
        for(int i=0;i<25;i++){
            gameState[i]=2;
        }
        ht.setText("");
        view.setVisibility(View.INVISIBLE);
        gameActive=true;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chedo5x5cuachoi2nguoi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ht=(TextView) findViewById(R.id.hienthiketqua3);
        playagain=(Button) findViewById(R.id.btnReset3);

    }
}