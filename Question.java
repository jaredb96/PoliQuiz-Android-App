package com.politicalquiz.poliquiz;

import java.util.*;

public class Question {
    private int mTextResId;
    private int mAxisType;
    private String mDegree;

    public Question(int textResId, int axisType, String degree){
        mTextResId = textResId;
        mAxisType = axisType;
        mDegree = degree;
    }

    /**
     * Getter method for text resource ID for question
     * @return text resource ID
     */
    public int getTextResId() {
        return mTextResId;
    }

    /**
     * Setter method for text resource ID
     * @param textResId we wish to set
     */
    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    /**
     * Getter method for axis the question belongs to
     * @return axis type of question
     */
    public int getAxisType() {
        return mAxisType;
    }


    /**
     * Setter method for axis type of question
     * @param axisType we wish to set
     */
    public void setAxisType(int axisType) {
        mAxisType = axisType;
    }

    /**
     * Getter method for extremity degree of question
     * @return degree of question
     */
    public String getDegree() {
        return mDegree;
    }

    /**
     * Setter method for extremity degree of question
     * @param degree we wish to set
     */
    public void setDegree(String degree) {
        mDegree = degree;
    }
}
