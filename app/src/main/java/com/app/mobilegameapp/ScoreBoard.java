package com.app.mobilegameapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ScoreBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        DatabaseHandler db = new DatabaseHandler(this);
        List<HIScore> hiScores = db.getAllHiScores();

        db.emptyHiScores();     // empty table if required

        // Inserting hi scores
        Log.i("Insert: ", "Inserting ..");



        // Reading all scores
        Log.i("Reading: ", "Reading all scores..");



        for (HIScore hs : hiScores) {
            String log =
                    "Id: " + hs.getScore_id() +
                            ", Date: " + hs.getGame_date() +
                            " , Player: " + hs.getPlayer_name() +
                            " , Score: " + hs.getScore();

            // Writing HiScore to log
            Log.i("Score: ", log);
        }

        Log.i("divider", "====================");

        HIScore singleScore = db.getHiScore(5);
        Log.i("High Score 5 is by ", singleScore.getPlayer_name() + " with a score of " +
                singleScore.getScore());

        Log.i("divider", "====================");

        // Calling SQL statement
        List<HIScore> top5HiScores = db.getTopFiveScores();

        for (HIScore hs : top5HiScores) {
            String log =
                    "Id: " + hs.getScore_id() +
                            ", Date: " + hs.getGame_date() +
                            " , Player: " + hs.getPlayer_name() +
                            " , Score: " + hs.getScore();

            // Writing HiScore to log
            Log.i("Score: ", log);
        }
        Log.i("divider", "====================");

        HIScore hiScore = top5HiScores.get(top5HiScores.size() - 1);
        // hiScore contains the 5th highest score
        Log.i("fifth Highest score: ", String.valueOf(hiScore.getScore()) );

        // simple test to add a hi score
        int myCurrentScore = 40;
        // if 5th highest score < myCurrentScore, then insert new score
        if (hiScore.getScore() < myCurrentScore) {

        }

        Log.i("divider", "====================");

        // Calling SQL statement
        top5HiScores = db.getTopFiveScores();

        for (HIScore hs : top5HiScores) {
            String log =
                    "Id: " + hs.getScore_id() +
                            ", Date: " + hs.getGame_date() +
                            " , Player: " + hs.getPlayer_name() +
                            " , Score: " + hs.getScore();

            // Writing HiScore to log
            Log.i("Score: ", log);
        }

    }
}

