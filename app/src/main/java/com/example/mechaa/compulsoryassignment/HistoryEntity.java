package com.example.mechaa.compulsoryassignment;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Mechaa on 01-03-2018.
 */

public class HistoryEntity implements Serializable {
    private String timeStamp;
    private ArrayList<Integer> rolls;
    private int Result;


    public HistoryEntity(String timeStamp, ArrayList<Integer> rolls, int result) {
        this.timeStamp = timeStamp;
        this.rolls = rolls;
        Result = result;
    }

    public int getResult() {
        return Result;
    }

    public void setResult(int result) {
        Result = result;
    }

    public ArrayList<Integer> getRolls() {
        return rolls;
    }

    public void setRolls(ArrayList<Integer> rolls) {
        this.rolls = rolls;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
