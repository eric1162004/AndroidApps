package com.example.dicee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String NUMBER1 = "number1";
    private final String NUMBER2 = "number2";

    private int number1 = 0;
    private int number2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            number1 = savedInstanceState.getInt(NUMBER1);
            number2= savedInstanceState.getInt(NUMBER2);
        }


        final Button rollButton =findViewById(R.id.rollButton);
        final ImageView leftDice =findViewById(R.id.image_leftDice);
        final ImageView rightDice =findViewById(R.id.image_rightDice);

        final int[] diceArray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6,
        };

        leftDice.setImageResource(diceArray[number1]);
        rightDice.setImageResource(diceArray[number2]);


        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random randomNumberGenerator = new Random();

                number1 = randomNumberGenerator.nextInt(6);
                number2 = randomNumberGenerator.nextInt(6);

                leftDice.setImageResource(diceArray[number1]);
                rightDice.setImageResource(diceArray[number2]);

            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NUMBER1, number1);
        outState.putInt(NUMBER2, number2);
    }
}
