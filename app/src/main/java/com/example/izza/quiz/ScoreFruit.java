package com.example.izza.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import com.example.izza.quiz.Common.Adapter;
import com.example.izza.quiz.DB.Db1;
import com.example.izza.quiz.Model.Rank;

public class ScoreFruit extends AppCompatActivity {
    ListView lstView;
    Button btnTryAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_fruit);

        lstView = (ListView)findViewById(R.id.lstRanking);
        Db1 db = new Db1(this);
        List<Rank> lstRanking = db.getRanking();
        if(lstRanking.size() > 0)
        {
            Adapter adapter = new Adapter(this,lstRanking);
            lstView.setAdapter(adapter);
        }
        btnTryAgain = (Button) findViewById(R.id.btnTryAgain);
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Categ.class);
                startActivity(intent);
                finish();
            }
        });

    }
}

