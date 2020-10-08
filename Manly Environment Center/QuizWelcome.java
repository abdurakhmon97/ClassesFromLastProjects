package com.muntasir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizWelcome extends AppCompatActivity {

    private Button yesButton;
    private Button noButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_welcome);

        yesButton = (Button)findViewById(R.id.yes);
        yesButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              finish();
                                              openQuizAudit();
                                          }
                                      }

        );

        noButton = (Button)findViewById(R.id.no);
        noButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              //openMain();
                                              finish();
                                          }
                                      }

        );

    }

    private void openQuizAudit() {
        Intent quiz = new Intent(this, QuizAudit.class);
        startActivity(quiz);
    }

    private void openMain() {
        Intent pamphletQuestionIntent = new Intent(this, MainActivity.class);
        startActivity(pamphletQuestionIntent);
    }



}
