package com.example.izza.quiz.Model;

/**
 * Created by izza on 19/07/2017.
 */

public class Rank {
    private int Id;
    private double Score;

    public Rank(int id, double score) {
        Id = id;
        Score = score;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }
}
