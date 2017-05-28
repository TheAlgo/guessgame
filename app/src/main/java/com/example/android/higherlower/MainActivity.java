package com.example.android.higherlower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random randomGenerator=new Random();
        randomNumber=randomGenerator.nextInt(21);
    }

    public void Guessit(View view) {

        EditText guess=(EditText)findViewById(R.id.guess);
        String message = "";
        String guessnumber=guess.getText().toString();
        if(!guessnumber.equals("")) {
            int gnumber = Integer.parseInt(guessnumber);

            if (gnumber > randomNumber)
                message = "Too High!";
            else if (gnumber < randomNumber)
                message = "Too low!";
            else {
                message = "Correct Well Done!";
                Random randomGenerator = new Random();
                randomNumber = randomGenerator.nextInt(21);
            }
        }
        else {
            message = "Please enter a number!";
           // Random randomGenerator = new Random();
            //randomNumber = randomGenerator.nextInt(21);
        }
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
        guess.setText("");
    }

}
