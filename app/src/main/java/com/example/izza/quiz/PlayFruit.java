package com.example.izza.quiz;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.izza.quiz.DB.Db1;
import com.example.izza.quiz.Model.QuestionFruit;

import java.util.ArrayList;
import java.util.List;

public class PlayFruit extends AppCompatActivity implements View.OnClickListener{

    final static long INTERVAL = 1000; // 1 second
    final static long TIMEOUT = 7000; // 7 sconds
    int progressValue = 0;

    CountDownTimer mCountDown; // for progressbar
    List<QuestionFruit> questionPlay = new ArrayList<>(); //total Question
    Db1 db;
    int index=0,score=0,thisQuestion=0,totalQuestion,correctAnswer;
    String mode="";

    //Control
    ProgressBar progressBar;
    ImageView imageView;
    Button btnA,btnB,btnC;
    TextView txtScore,txtQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_fruit);

        //Get Data from MainActivity
        Bundle extra = getIntent().getExtras();
        if(extra != null)
            mode=extra.getString("MODE");

        db = new Db1(this);

        txtScore = (TextView)findViewById(R.id.txtScore);
        txtQuestion = (TextView)findViewById(R.id.txtQuestion);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        imageView = (ImageView)findViewById(R.id.question_Fruit);
        btnA=(Button)findViewById(R.id.btnAnswerA);
        btnB=(Button)findViewById(R.id.btnAnswerB);
        btnC=(Button)findViewById(R.id.btnAnswerC);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        questionPlay = db.getQuestionMode(mode);
        totalQuestion = questionPlay.size();

        mCountDown = new CountDownTimer(TIMEOUT,INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress(progressValue);
                progressValue++;
            }

            @Override
            public void onFinish() {
                mCountDown.cancel();
                showQuestion(++index);
            }
        };
        showQuestion(index);
    }

    private void showQuestion(int index) {
        if(index < totalQuestion){
            thisQuestion++;
            txtQuestion.setText(String.format("%d/%d",thisQuestion,totalQuestion));
            progressBar.setProgress(0);
            progressValue = 0;

            int ImageId=this.getResources().getIdentifier(questionPlay.get(index).getImage().toLowerCase(),"drawable",getPackageName());
            imageView.setBackgroundResource(ImageId);
            btnA.setText(questionPlay.get(index).getAnswerA());
            btnB.setText(questionPlay.get(index).getAnswerB());
            btnC.setText(questionPlay.get(index).getAnswerC());

            mCountDown.start();
        }
        else{
            Intent intent = new Intent(this,DoneFruit.class);
            Bundle dataSend = new Bundle();
            dataSend.putInt("SCORE",score);
            dataSend.putInt("TOTAL",totalQuestion);
            dataSend.putInt("CORRECT",correctAnswer);
            intent.putExtras(dataSend);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View v) {

        mCountDown.cancel();
        if(index < totalQuestion){
            Button clickedButton = (Button)v;
            if(clickedButton.getText().equals(questionPlay.get(index).getCorrectAnswer()))
            {
                score+=10; // increase score
                correctAnswer++ ; //increase correct answer
                showQuestion(++index);
            }
            else
                showQuestion(++index); // If choose right , just go to next question

            txtScore.setText(String.format("%d",score));
        }

    }
}
