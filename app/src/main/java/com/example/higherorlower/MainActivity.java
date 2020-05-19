package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int maxGuess = 20;
    int minGuess = 1;
    int randomInt;

    public void generateRandomNumber() {
        randomInt = (int) (Math.random() * ((maxGuess - minGuess) + 1)) + minGuess;
    }

    public void guess(View view) {

        EditText guessEditText = (EditText) findViewById(R.id.editNumberText);
        Log.i("Info", Integer.toString(randomInt));
        Log.i("Info", guessEditText.getText().toString());
        Integer guessInt = Integer.parseInt(guessEditText.getText().toString());

        Toast.makeText(this, getResponse(guessInt), Toast.LENGTH_LONG).show();
    }

    private String getResponse(Integer guessInt) {
        String response = "";
        if (guessInt > maxGuess || guessInt < minGuess){
            response = "Please guess a number between 1 and 20";
        } else if (guessInt > randomInt) {
            response = "Too high";
        } else if (guessInt < randomInt) {
            response = "Too low";
        } else if (guessInt == randomInt) {
            response = "Correct!";
            generateRandomNumber();
        }
        return response;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
    }
}
