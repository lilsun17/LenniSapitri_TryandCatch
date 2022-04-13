package com.example.lennisapitri_tryandcatch;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CollationKey;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
import java.util.RandomAccess;

public class MainActivity extends AppCompatActivity {
    Integer randomNumber;
    public void randomNumberGenerator() //for repeating the game
    {
        Random random = new Random(100);
        randomNumber = random.nextInt();
    }
    public void onGuess(View view)
    {
        String message;
        EditText EditTextNumber = (EditText) findViewById(R.id.editTextNumber);
        Integer guessNumber = Integer.parseInt(EditTextNumber.getText().toString());
        if (guessNumber < randomNumber)
                message = "higher !!";
        else if (guessNumber > randomNumber)
            message = "Lower !!";
        else
        {
            message = "You got me !!";
            randomNumberGenerator();    //kinda recurtion
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        randomNumber = random.nextInt(100)+1;   //limit up to 100 from 1
    }
}