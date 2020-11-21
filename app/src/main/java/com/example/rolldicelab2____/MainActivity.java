package com.example.rolldicelab2____;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 6;




    Random letfSide;
    Random rightSide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickRoll(View view){
        //Reaching textviews
        TextView output = findViewById(R.id.output);
        TextView result = findViewById(R.id.result);


        //generating two random number
        letfSide = new Random();
        rightSide = new Random();
        int diceLeft = letfSide.nextInt((MAX_NUMBER - MIN_NUMBER)+1) + MIN_NUMBER;
        int diceRight = rightSide.nextInt((MAX_NUMBER - MIN_NUMBER)+1) + MIN_NUMBER;

        //comparison of l = r  --- l > r --- r < l
        if(diceLeft == diceRight){
            output.setText(""+diceLeft+" - "+diceRight);
            result.setText("DRAW!!!");
        }
        else if(diceLeft > diceRight){
            output.setText(""+diceLeft+" - "+diceRight);
            result.setText("LEFT WON");
        }else{
            output.setText(""+diceLeft+" - "+diceRight);
            result.setText("RIGHT WON");

        }
    }

    public void onClickReset(View view){
        //Reaching textviews
        TextView output = findViewById(R.id.output);
        TextView result = findViewById(R.id.result);

        //removing output screen
        output.setText("_   -   _");

        //re-initialize result screen
        result.setText("WHO WON?");
    }

}