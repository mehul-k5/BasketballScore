package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score_a = 0,score_b=0,foul_a=0,foul_b=0;
    String msg="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addOneForTeamA(View v) {
        score_a++;
        displayForTeamA();
    }

    public void addTwoForTeamA(View v) {
        score_a +=2;
        displayForTeamA();
    }

    public void addThreeForTeamA(View v) {
        score_a +=3;
        displayForTeamA();
    }

    public void foulForTeamA(View v) {
        foul_a++;
        if(foul_a%4==0){
            score_b++;
        }
        displayForTeamA();
        displayForTeamB();
    }

    public void displayForTeamA() {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText("Score: "+score_a+"\nFoul: "+foul_a);
    }

    public void addOneForTeamB(View v) {
        score_b++;
        displayForTeamB();
    }

    public void addTwoForTeamB(View v) {
        score_b +=2;
        displayForTeamB();
    }

    public void addThreeForTeamB(View v) {
        score_b +=3;
        displayForTeamB();
    }

    public void foulForTeamB(View v) {
        foul_b++;
        if(foul_b%4==0){
            score_a++;
        }
        displayForTeamB();
        displayForTeamA();
    }

    public void displayForTeamB() {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText("Score: "+score_b+"\nFoul: "+foul_b);
    }

    public void resetScore(View v){
        score_b=0;
        score_a=0;
        foul_a=0;
        foul_b=0;
        msg="";
        displayForTeamA();
        displayForTeamB();
        displayWinner(v);
    }

    public void displayWinner(View v){
        if(score_a>score_b){
            msg= "Team A is the winner!";
        }
        else if(score_b>score_a){
            msg= "Team B is the winner!";
        }
        else if(score_b==score_a&&score_a>0&&score_b>0){
            msg= "It's a tie!";
        }
        TextView scoreView = (TextView) findViewById(R.id.win);
        scoreView.setText(msg);
    }
}