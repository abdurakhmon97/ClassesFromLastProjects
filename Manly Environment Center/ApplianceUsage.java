package com.muntasir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class ApplianceUsage extends AppCompatActivity {

    private String date = this.getDate();

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView dateShower;
    private TextView mQuestionView;
    private Button mNext;
    private EditText mInput;

    private int mQuestionNumber = 0;
    private ArrayList<String> tempArr = new ArrayList<>();
    private ArrayList<String> tempArr2 = new ArrayList<>();
    private ArrayList<String> dateArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicance_usage);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mNext = (Button)findViewById(R.id.next);
        mInput = (EditText)findViewById((R.id.input));
        dateShower = (TextView) findViewById(R.id.score);


        updateQuestion();

        //Start of Button Listener for Button1
        mNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here
                if(!mInput.getText().toString().isEmpty()){
                    File path = getApplicationContext().getFilesDir();
                    File applianceHistory = new File(path, "applianceRating.txt");
                    String prevUsage = "";
                    String temp = "";
                    tempArr.add(mInput.getText().toString());
                    dateArr.add(date);


                    File path2 = getApplicationContext().getFilesDir();
                    File applianceHistory2 = new File(path2, "date.txt");
                    String prevUsage2 = "";
                    String temp2 = "";



                    try
                    {
                        System.out.println("Checking old file");
                        System.out.println("--------------------------------------------");
                        int length = (int)applianceHistory.length();
                        byte[] usageInBytes = new byte[length];
                        FileInputStream read = new FileInputStream(applianceHistory);
                        read.read(usageInBytes);
                        prevUsage += new String(usageInBytes);
                        temp += new String(usageInBytes);
                        System.out.println("Old file contains : " + prevUsage);
                        read.close();

                        System.out.println("Checking old file2");
                        System.out.println("--------------------------------------------");
                        int length2 = (int)applianceHistory2.length();
                        byte[] usageInBytes1 = new byte[length2];
                        FileInputStream read2 = new FileInputStream(applianceHistory2);
                        read2.read(usageInBytes1);
                        prevUsage2 += new String(usageInBytes1);
                        temp2 += new String(usageInBytes1);
                        System.out.println("Old file contains 2: " + prevUsage2);
                        read2.close();



                    }
                    catch (Exception e)
                    {
                        System.out.println("--------------------------------------------");
                        System.out.println("Opening file not working");
                        System.out.println("--------------------------------------------");
                    }

                    try
                    {

                        String update = prevUsage;
                        System.out.println(update + " -------------------- I AM HERE");
                        if(!mNext.getText().toString().equals("SUBMIT")){
                            update.equals(prevUsage);
                            System.out.println("IAMHERE THIS TIME");
                        }
                        else{
                            System.out.println(update + "WHO IS HERE?");
                            for(String s: tempArr){
                                update += " " + s;
                            }
                            System.out.println(update + "THISTIME123");
                            tempArr = tempArr2;
                            FileOutputStream write = new FileOutputStream(applianceHistory);
                            write.write(update.getBytes());
                            write.close();
                        }

                        System.out.println("--------------------------------------------");
                        System.out.println("File successfully created and stored at " + getFilesDir());
                        System.out.println("--------------------------------------------");

                        System.out.println();


                        String update2 = prevUsage2;
                        if(!mNext.getText().toString().equals("SUBMIT")){
                            update2.equals(prevUsage2);
                        }
                        else{
                            for(String s: dateArr){
                                update2 += " " + s;
                            }
                            dateArr = tempArr2;
                            FileOutputStream write2 = new FileOutputStream(applianceHistory2);
                            write2.write(update2.getBytes());
                            write2.close();
                        }

                        System.out.println("--------------------------------------------");
                        System.out.println("File successfully created and stored at " + getFilesDir());
                        System.out.println("--------------------------------------------");

                        //System.out.println(date);

                    }
                    catch (Exception e)
                    {
                        System.out.println("--------------------------------------------");
                        System.out.println("File not found");
                        System.out.println("--------------------------------------------");
                    }
                    if(mQuestionNumber == mQuestionLibrary.mQuestions.length - 1) {
                        updateQuestion();
                        mInput.setVisibility(View.GONE);
                        mNext.setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View v) {
                                                         //openMain();
                                                         finish();
                                                     }
                                                 }

                        );
                    }
                    else {
                        updateQuestion();

                    }
                }
                else if(mQuestionNumber == mQuestionLibrary.mQuestions.length - 1 && mInput.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "You have not inserted your input", Toast.LENGTH_SHORT);
                    toast.show();
                }

                else if(mQuestionNumber == mQuestionLibrary.mQuestions.length - 1) {
                    updateQuestion();
                    mInput.setVisibility(View.GONE);
                    mNext.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     finish();
                                                     //openMain();
                                                 }
                                             }

                    );
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "You have not inserted your input", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

    }

    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mQuestionNumber++;
        mInput.setText("");
        dateShower.setText(this.getDate());
        if(mQuestionNumber == mQuestionLibrary.mQuestions.length - 1)
            mNext.setText("SUBMIT");
        else if (mQuestionNumber == mQuestionLibrary.mQuestions.length)
            mNext.setText("FINISH");
    }


    /*private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }*/

    private void openMain() {
        Intent main = new Intent(this, MainActivity.class );
        startActivity(main);
    }

    public String getDate(){
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MMM-yyyy");
        return dFormat.format(currentDate);

    }

}