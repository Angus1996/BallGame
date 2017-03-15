package com.example.a88481.ballgame;

/**
 * Created by 88481 on 2017/3/15 0015.
 */

public class Player {
    private String name;

    private int score;

    private int lifeCount = 3;

    private int second;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLifeCount() {
        return lifeCount;
    }

    public void setLifeCount(int lifeCount) {
        this.lifeCount = lifeCount;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }


}
