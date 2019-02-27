package com.politicalquiz.poliquiz;

import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreKeeper {
    private int mXCoordinate;
    private int mYCoordinate;
    private TextView mIdeology;

    /**
     * Default ScoreKeeper constructor
     */
    public ScoreKeeper(){
        mXCoordinate = 0;
        mYCoordinate = 0;
        mIdeology.setText(R.string.centrist);
    }

    public ScoreKeeper(int xCoordinate, int yCoordinate, TextView ideology){
        mXCoordinate = xCoordinate;
        mYCoordinate = yCoordinate;
        mIdeology = ideology;
    }

    /**
     * Getter method for users x-coordinate
     * @return current x-coordinate of users political ideology
     */
    public int getXCoordinate() {
        return mXCoordinate;
    }

    /**
     * Setter method for users x-coordinate
     * @param XCoordinate
     */
    public void setXCoordinate(int XCoordinate) {
        mXCoordinate = XCoordinate;
    }

    /**
     * Getter method for users y-coordinate
     * @return current y-coordinate of users political ideology
     */
    public int getYCoordinate() {
        return mYCoordinate;
    }

    /**
     * Setter method for users y-coordinate
     * @param YCoordinate
     */
    public void setYCoordinate(int YCoordinate) {
        mYCoordinate = YCoordinate;
    }

    /**
     * Getter method of users current ideology
     * @return users current ideology
     */
    public TextView getIdeology() {
        return mIdeology;
    }

    /**
     * Setter method for users current ideology
     * @param ideology
     */
    public void setIdeology(TextView ideology) {
        if (mXCoordinate == 0 && mYCoordinate == 0){
            ideology.setText(R.string.centrist);
        }
        if(isBetween(mXCoordinate, -1000, 0) && mYCoordinate == 0){
            ideology.setText(R.string.general_collectivist);
        }
        if(mXCoordinate == 0 && isBetween(mYCoordinate, 0, 1000)){
            ideology.setText(R.string.general_authoritarian);
        }
        if(isBetween(mXCoordinate, 0, 1000)&& mYCoordinate == 0){
            ideology.setText(R.string.general_libertarian);
        }
        if(isBetween(mXCoordinate, -1000, 0) && mYCoordinate == 0){
            ideology.setText(R.string.general_libertarian);
        }


        if (isBetween(mXCoordinate, -1000, 0) && isBetween(mYCoordinate, 0, 1000)){
            leftAuthoritarian(ideology);
        }
        if (isBetween(mXCoordinate, 0, 1000) && isBetween(mYCoordinate, 0, 1000)){
            rightAuthoritarian(ideology);
        }
        if (isBetween(mXCoordinate, 0, 1000) && isBetween(mYCoordinate, -1000, 0)){
            rightLibertarian(ideology);
        }
        if (isBetween(mXCoordinate, -1000, 0) && isBetween(mYCoordinate, -1000, 0)){
            leftLibertarian(ideology);
        }

        mIdeology = ideology;
    }


    /**
     * Method that updates users current political score
     * @param axisType of question (Collectivist, Authoritarian, Capitalist, Libertarian)
     * @param degree of question (Extreme, Moderate, Weak)
     * @param scale of question based on Strongly Agree, Agree, etc.
     */
    public void updateScore(int axisType, String degree, int scale) {
        // Collectivist question
        if (axisType == 1) {
            switch (degree) {
                case "E":
                    setXCoordinate(mXCoordinate - scale);
                    break;
                case "M":
                    setXCoordinate(mXCoordinate - (scale - 30));
                    break;
                case "W":
                    setXCoordinate(mXCoordinate - (scale - 70));
                    break;
                default:
                    break;
            }
        }

        // Authoritarian question
        if (axisType == 2) {
            switch (degree) {
                case "E":
                    setXCoordinate(mYCoordinate + scale);
                    break;
                case "M":
                    setXCoordinate(mYCoordinate + (scale - 30));
                    break;
                case "W":
                    setXCoordinate(mYCoordinate + (scale - 70));
                    break;
                default:
                    break;
            }

        }

        // Capitalist question
        if (axisType == 3) {
            switch (degree) {
                case "E":
                    setXCoordinate(mXCoordinate + scale);
                    break;
                case "M":
                    setXCoordinate(mXCoordinate + (scale - 30));
                    break;
                case "W":
                    setXCoordinate(mXCoordinate + (scale - 70));
                    break;
                default:
                    break;
            }

        }

        // Libertarian question
        if (axisType == 4) {
            switch (degree) {
                case "E":
                    setXCoordinate(mYCoordinate - scale);
                    break;
                case "M":
                    setXCoordinate(mYCoordinate - (scale - 30));
                    break;
                case "W":
                    setXCoordinate(mYCoordinate - (scale - 70));
                    break;
                default:
                    break;
            }

        }

    }

    private boolean isBetween(int nums, int low, int high){
       return (low <= nums) && (nums <= high);
    }

    private void leftAuthoritarian(TextView ideology){
        if (isBetween(mXCoordinate,-150, 0) && isBetween(mYCoordinate, 0, 150)){
            ideology.setText(R.string.left_centrist);
        }
        if (isBetween(mXCoordinate, -150, 0) && isBetween(mYCoordinate, 150, 550)){
            ideology.setText(R.string.neoliberal);
        }
        if (isBetween(mXCoordinate, -700, -150) && isBetween(mYCoordinate, 150, 550)){
            ideology.setText(R.string.general_liberal);
        }
        if (isBetween(mXCoordinate, -500, 150) && isBetween(mYCoordinate, 150, 550)){
            ideology.setText(R.string.progressive);
        }
        if (isBetween(mXCoordinate, -750, 500) && isBetween(mYCoordinate, 0, 150)){
            ideology.setText(R.string.social_liberal);
        }
        if (isBetween(mXCoordinate, -1000, -750) && isBetween(mYCoordinate, 0, 400)){
            ideology.setText(R.string.general_socialist);
        }
        if (isBetween(mXCoordinate, -750, -500) && isBetween(mYCoordinate, 150, 400)){
            ideology.setText(R.string.general_socialist);
        }
        if (isBetween(mXCoordinate, -1000, 500) && isBetween(mYCoordinate, 450, 600)){
            ideology.setText(R.string.state_socialist);
        }
        if (isBetween(mXCoordinate, -500, 0) && isBetween(mYCoordinate, 550, 700)){
            ideology.setText(R.string.state_socialist);
        }
        if (isBetween(mXCoordinate, -1000, 500) && isBetween(mYCoordinate, 600, 700)){
            ideology.setText(R.string.left_communist);
        }
        if (isBetween(mXCoordinate, -750, -500) && isBetween(mYCoordinate, 700, 750)){
            ideology.setText(R.string.orthodox_marxist);
        }
        if (isBetween(mXCoordinate, -500, 0) && isBetween(mYCoordinate, 700, 850)){
            ideology.setText(R.string.general_communist);
        }
        if (isBetween(mXCoordinate, -750, 500) && isBetween(mYCoordinate, 750, 850)){
            ideology.setText(R.string.general_communist);
        }

        if (isBetween(mXCoordinate, -1000, -750) && isBetween(mYCoordinate, 700, 800)){
            ideology.setText(R.string.trotskyist);
        }
        if (isBetween(mXCoordinate, -1000, -750) && isBetween(mYCoordinate, 850, 900)){
            ideology.setText(R.string.marxist_leninist_maoist);
        }
        if (isBetween(mXCoordinate, -1000, -750) && isBetween(mYCoordinate, 900, 1000)){
            ideology.setText(R.string.maoist);
        }
        if (isBetween(mXCoordinate, -750, -300) && isBetween(mYCoordinate, 850, 1000)){
            ideology.setText(R.string.marxist_leninist);
        }
        if (isBetween(mXCoordinate, -300, 0) && isBetween(mYCoordinate, 850, 1000)){
            ideology.setText(R.string.stalinist);
        }

    }
    private void rightAuthoritarian(TextView ideology){
        if (isBetween(mXCoordinate, 0, 150) && isBetween(mYCoordinate, 0, 150)){
            ideology.setText(R.string.right_centrist);
        }
        if (isBetween(mXCoordinate, 150, 1000) && isBetween(mYCoordinate, 300, 550)){
            ideology.setText(R.string.general_conservative);
        }
        if (isBetween(mXCoordinate, 0, 150) && isBetween(mYCoordinate, 150, 550)){
            ideology.setText(R.string.neoconservative);
        }
        if (isBetween(mXCoordinate, 150, 700) && isBetween(mYCoordinate, 150, 300)){
            ideology.setText(R.string.paleoconservative);
        }
        if (isBetween(mXCoordinate, 150, 700) && isBetween(mYCoordinate, 0, 150)){
            ideology.setText(R.string.libertarian_conservative);
        }
        if (isBetween(mXCoordinate, 0, 150) && isBetween(mYCoordinate, 0, 150)){
            ideology.setText(R.string.right_centrist);
        }
        if (isBetween(mXCoordinate, 700, 1000) && isBetween(mYCoordinate, 0, 300)){
            ideology.setText(R.string.right_populist);
        }
        if (isBetween(mXCoordinate, 500, 100) && isBetween(mYCoordinate, 650, 800)){
            ideology.setText(R.string.alt_right_conservative);
        }
        if (isBetween(mXCoordinate, 0, 500) && isBetween(mYCoordinate, 650, 800)){
            ideology.setText(R.string.general_nationalist);
        }
        if (isBetween(mXCoordinate, 0, 500) && isBetween(mYCoordinate, 550, 650)){
            ideology.setText(R.string.civic_nationalist);
        }
        if (isBetween(mXCoordinate, 0, 500) && isBetween(mYCoordinate, 800, 900)){
            ideology.setText(R.string.ethno_nationalist);
        }
        if (isBetween(mXCoordinate, 0, 500) && isBetween(mYCoordinate, 900, 1000)){
            ideology.setText(R.string.ultra_nationalist);
        }
        if (isBetween(mXCoordinate, 500, 800) && isBetween(mYCoordinate, 800, 950)){
            ideology.setText(R.string.general_fascist);
        }
        if (isBetween(mXCoordinate, 800, 1000) && isBetween(mYCoordinate, 800, 900)){
            ideology.setText(R.string.corporatist);
        }
        if (isBetween(mXCoordinate, 900, 1000) && isBetween(mYCoordinate, 900, 1000)){
            ideology.setText(R.string.monarchist);
        }
        if (isBetween(mXCoordinate, 500, 800) && isBetween(mYCoordinate, 950,1000)){
            ideology.setText(R.string.fundamentalist);
        }

    }

    private void rightLibertarian(TextView ideology){
        if (isBetween(mXCoordinate, 0, 500) && isBetween(mYCoordinate, -350, 0)){
            ideology.setText(R.string.classic_liberal);
        }
        if (isBetween(mXCoordinate, 400, 1000) && isBetween(mYCoordinate, -500, 0)){
            ideology.setText(R.string.libertarian_capitalist);
        }
        if (isBetween(mXCoordinate, 0, 350) && isBetween(mYCoordinate, -600, -350)){
            ideology.setText(R.string.agorist);
        }
        if (isBetween(mXCoordinate, 250, 500) && isBetween(mYCoordinate, -850, -600)){
            ideology.setText(R.string.voluntaryist);
        }
        if (isBetween(mXCoordinate, 0, 500) && isBetween(mYCoordinate, -1000, -850)){
            ideology.setText(R.string.minarchist);
        }
        if (isBetween(mXCoordinate, 0, 250) && isBetween(mYCoordinate, -850, -650)){
            ideology.setText(R.string.right_individualist);
        }
        if (isBetween(mXCoordinate, 500, 1000) && isBetween(mYCoordinate, -700, -500)){
            ideology.setText(R.string.paleolibertarian);
        }
        if (isBetween(mXCoordinate, 400, 500) && isBetween(mYCoordinate, -600, -500)){
            ideology.setText(R.string.paleolibertarian);
        }
        if (isBetween(mXCoordinate, 500, 1000) && isBetween(mYCoordinate, -1000, -700)){
            ideology.setText(R.string.anarcho_capitalist);
        }

    }

    private void leftLibertarian(TextView ideology){
        if (isBetween(mXCoordinate, -1000, -500) && isBetween(mYCoordinate, -300, 0)){
            ideology.setText(R.string.democratic_socialist);
        }
        if (isBetween(mXCoordinate, -500, 0) && isBetween(mYCoordinate, -250, 0)){
            ideology.setText(R.string.social_democrat);
        }
        if (isBetween(mXCoordinate, -500, 0) && isBetween(mYCoordinate, -450, -250)){
            ideology.setText(R.string.libertarian_socialist);
        }
        if (isBetween(mXCoordinate, -1000, -450) && isBetween(mYCoordinate, -450, -300)){
            ideology.setText(R.string.communalist);
        }
        if (isBetween(mXCoordinate, -1000, -550) && isBetween(mYCoordinate, -700, -550)){
            ideology.setText(R.string.social_anarchist);
        }
        if (isBetween(mXCoordinate, -1000, -450) && isBetween(mYCoordinate, -550, -450)){
            ideology.setText(R.string.general_anarchist);
        }
        if (isBetween(mXCoordinate, -1000, -450) && isBetween(mYCoordinate, -600, -450)){
            ideology.setText(R.string.general_anarchist);
        }
        if (isBetween(mXCoordinate, -1000, -650) && isBetween(mYCoordinate, -1000, -700)){
            ideology.setText(R.string.anarcho_communist);
        }
        if (isBetween(mXCoordinate, -650, -250) && isBetween(mYCoordinate, -850, -600)){
            ideology.setText(R.string.anarcho_syndicalist);
        }
        if (isBetween(mXCoordinate, -450, 0) && isBetween(mYCoordinate, -600, -450)){
            ideology.setText(R.string.mutualist);
        }
        if (isBetween(mXCoordinate, -650, -450) && isBetween(mYCoordinate, -1000, -850)){
            ideology.setText(R.string.anarcho_primitivist);
        }
        if (isBetween(mXCoordinate, -450, -300) && isBetween(mYCoordinate, -1000, -850)){
            ideology.setText(R.string.egoist);
        }
        if (isBetween(mXCoordinate, -250, 0) && isBetween(mYCoordinate, -1000, -850)){
            ideology.setText(R.string.left_market_anarchist);
        }
        if (isBetween(mXCoordinate, -250, 0) && isBetween(mYCoordinate, -850, -600)){
            ideology.setText(R.string.left_individualist);
        }


    }



}
