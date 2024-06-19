package com.sparta.mg.final_example;

public class FinalConsumer extends FinalExample{

    private final static int FINAL_SCORE = 100;

    @Override
    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }
}
