package com.politicalquiz.poliquiz;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.*;

public class PoliQuizActivity extends AppCompatActivity {
    private Button mStrongAgreeButton;
    private Button mAgreeButton;
    private Button mNeutralButton;
    private Button mDisagreeButton;
    private Button mStrongDisagreeButton;
    private Button mSubmitQuizButton;

    private ImageButton mNextButton;
    private ImageButton mBackButton;

    private ArrayList<Question> mQuestionBank = new ArrayList<>();

    private TextView mQuestionTextView;
    private int mCurrentIndex;

    private TextView mIdeologyTextView;
    private ScoreKeeper mKeeper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poli_quiz);

        // create question bank to hold questions
        mQuestionBank = makeQuestions();
        mCurrentIndex = 0;

        // get reference to question and set its text to the question at the current index
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        final int question = mQuestionBank.get(mCurrentIndex).getTextResId();
        mQuestionTextView.setText(question);

        // get reference to ideology and set its text to default ideology
        mIdeologyTextView = (TextView) findViewById(R.id.ideology_text_view);
        mIdeologyTextView.setText(R.string.centrist);
        mIdeologyTextView.setVisibility(View.INVISIBLE);

        // create Scorekeeper object to hold and update score
        mKeeper = new ScoreKeeper(0, 0, mIdeologyTextView);



        // get references to the buttons we need for the quiz
        mStrongAgreeButton = (Button) findViewById(R.id.strong_agree_button);
        mAgreeButton = (Button) findViewById(R.id.agree_button);
        mNeutralButton = (Button) findViewById(R.id.neutral_button);
        mDisagreeButton = (Button) findViewById(R.id.disagree_button);
        mStrongDisagreeButton = (Button) findViewById(R.id.strong_disagree_button);
        mSubmitQuizButton = (Button) findViewById(R.id.submit_quiz_button);

        // make submit quiz button invisible until its needed
        mSubmitQuizButton.setVisibility(View.INVISIBLE);

        // wire up the next button to function as desired
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if we are on the second to last button and we press this button, disable this button
                if (mCurrentIndex == mQuestionBank.size() - 2){
                    mNextButton.setVisibility(View.INVISIBLE);
                    mSubmitQuizButton.setVisibility(View.VISIBLE);
                }
                // if we are on the first question and we press this button, enable the back button
                if (mCurrentIndex == 0){
                    mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size();
                    mBackButton.setVisibility(View.VISIBLE);
                    updateQuestion();
                }
                else {
                    mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size();
                    mBackButton.setVisibility(View.VISIBLE);
                    updateQuestion();
                }
            }
        });


        // wire up the back button to function as desired
        mBackButton = (ImageButton) findViewById(R.id.back_button);
        mBackButton.setVisibility(View.INVISIBLE);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex == mQuestionBank.size() - 1){
                    // if we are on the last question and we press back, enable the next button
                    mNextButton.setVisibility(View.VISIBLE);
                    mCurrentIndex = mCurrentIndex - 1;
                    updateQuestion();
                }
                // if we go back to the first question, disable this button
                if (mCurrentIndex == 1){
                    mCurrentIndex = mCurrentIndex - 1;
                    updateQuestion();
                    mBackButton.setVisibility(View.INVISIBLE);
                }
                else {
                    mBackButton.setEnabled(true);
                    mCurrentIndex = mCurrentIndex - 1;
                    updateQuestion();
                }

            }
        });



        // set listeners for each button to react to user pressing button
        // Strongly Agree button implementation
        mStrongAgreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // implement what needs to happen on clicking this button
                int scale = 100;
                switch(mCurrentIndex){
                    case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
                        if (0 <= mCurrentIndex && mCurrentIndex <= 2){
                            mKeeper.updateScore(1, "E", scale);
                        }
                        if (3 <= mCurrentIndex && mCurrentIndex <= 6){
                            mKeeper.updateScore(1, "M", scale);
                        }
                        if (7 <= mCurrentIndex && mCurrentIndex <= 9){
                            mKeeper.updateScore(1, "W", scale);
                        }
                    case 10: case 11: case 12: case 13: case 14: case 15: case 16: case 17: case 18: case 19:
                        if (10 <= mCurrentIndex && mCurrentIndex <= 12){
                            mKeeper.updateScore(2, "E", scale);
                        }
                        if (13 <= mCurrentIndex && mCurrentIndex <= 16){
                            mKeeper.updateScore(2, "M", scale);
                        }
                        if (17 <= mCurrentIndex && mCurrentIndex <= 19){
                            mKeeper.updateScore(2, "W", scale);
                        }

                    case 20: case 21: case 22: case 23: case 24: case 25: case 26: case 27: case 28: case 29:
                        if (10 <= mCurrentIndex && mCurrentIndex <= 12){
                            mKeeper.updateScore(3, "E", scale);
                        }
                        if (13 <= mCurrentIndex && mCurrentIndex <= 16){
                            mKeeper.updateScore(3, "M", scale);
                        }
                        if (17 <= mCurrentIndex && mCurrentIndex <= 19){
                            mKeeper.updateScore(3, "W", scale);
                        }
                    case 30: case 31: case 32: case 33: case 34: case 35: case 36: case 37: case 38: case 39:
                        if (10 <= mCurrentIndex && mCurrentIndex <= 12){
                            mKeeper.updateScore(4, "E", scale);
                        }
                        if (13 <= mCurrentIndex && mCurrentIndex <= 16){
                            mKeeper.updateScore(4, "M", scale);
                        }
                        if (17 <= mCurrentIndex && mCurrentIndex <= 19){
                            mKeeper.updateScore(4, "W", scale);
                        }
                }
                displayScore();
            }
        });

        //Agree button implementation
        mAgreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scale = 70;
                switch(mCurrentIndex){
                    case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
                        if (0 <= mCurrentIndex && mCurrentIndex <= 2){
                            mKeeper.updateScore(1, "E", scale);
                        }
                        if (3 <= mCurrentIndex && mCurrentIndex <= 6){
                            mKeeper.updateScore(1, "M", scale);
                        }
                        if (7 <= mCurrentIndex && mCurrentIndex <= 9){
                            mKeeper.updateScore(1, "W", scale);
                        }
                    case 10: case 11: case 12: case 13: case 14: case 15: case 16: case 17: case 18: case 19:
                        if (10 <= mCurrentIndex && mCurrentIndex <= 12){
                            mKeeper.updateScore(2, "E", scale);
                        }
                        if (13 <= mCurrentIndex && mCurrentIndex <= 16){
                            mKeeper.updateScore(2, "M", scale);
                        }
                        if (17 <= mCurrentIndex && mCurrentIndex <= 19){
                            mKeeper.updateScore(2, "W", scale);
                        }

                    case 20: case 21: case 22: case 23: case 24: case 25: case 26: case 27: case 28: case 29:
                        if (10 <= mCurrentIndex && mCurrentIndex <= 12){
                            mKeeper.updateScore(3, "E", scale);
                        }
                        if (13 <= mCurrentIndex && mCurrentIndex <= 16){
                            mKeeper.updateScore(3, "M", scale);
                        }
                        if (17 <= mCurrentIndex && mCurrentIndex <= 19){
                            mKeeper.updateScore(3, "W", scale);
                        }
                    case 30: case 31: case 32: case 33: case 34: case 35: case 36: case 37: case 38: case 39:
                        if (10 <= mCurrentIndex && mCurrentIndex <= 12){
                            mKeeper.updateScore(4, "E", scale);
                        }
                        if (13 <= mCurrentIndex && mCurrentIndex <= 16){
                            mKeeper.updateScore(4, "M", scale);
                        }
                        if (17 <= mCurrentIndex && mCurrentIndex <= 19){
                            mKeeper.updateScore(4, "W", scale);
                        }
                }
                displayScore();
            }
        });

        mNeutralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // implement what needs to happen on clicking this button

            }
        });

        // Disagree Button implementation
        mDisagreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scale = -70;
                switch(mCurrentIndex){
                    case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
                        if (0 <= mCurrentIndex && mCurrentIndex <= 2){
                            mKeeper.updateScore(1, "E", scale);
                        }
                        if (3 <= mCurrentIndex && mCurrentIndex <= 6){
                            mKeeper.updateScore(1, "M", scale);
                        }
                        if (7 <= mCurrentIndex && mCurrentIndex <= 9){
                            mKeeper.updateScore(1, "W", scale);
                        }
                    case 10: case 11: case 12: case 13: case 14: case 15: case 16: case 17: case 18: case 19:
                        if (10 <= mCurrentIndex && mCurrentIndex <= 12){
                            mKeeper.updateScore(2, "E", scale);
                        }
                        if (13 <= mCurrentIndex && mCurrentIndex <= 16){
                            mKeeper.updateScore(2, "M", scale);
                        }
                        if (17 <= mCurrentIndex && mCurrentIndex <= 19){
                            mKeeper.updateScore(2, "W", scale);
                        }

                    case 20: case 21: case 22: case 23: case 24: case 25: case 26: case 27: case 28: case 29:
                        if (10 <= mCurrentIndex && mCurrentIndex <= 12){
                            mKeeper.updateScore(3, "E", scale);
                        }
                        if (13 <= mCurrentIndex && mCurrentIndex <= 16){
                            mKeeper.updateScore(3, "M", scale);
                        }
                        if (17 <= mCurrentIndex && mCurrentIndex <= 19){
                            mKeeper.updateScore(3, "W", scale);
                        }
                    case 30: case 31: case 32: case 33: case 34: case 35: case 36: case 37: case 38: case 39:
                        if (10 <= mCurrentIndex && mCurrentIndex <= 12){
                            mKeeper.updateScore(4, "E", scale);
                        }
                        if (13 <= mCurrentIndex && mCurrentIndex <= 16){
                            mKeeper.updateScore(4, "M", scale);
                        }
                        if (17 <= mCurrentIndex && mCurrentIndex <= 19){
                            mKeeper.updateScore(4, "W", scale);
                        }
                }
                displayScore();
            }
        });

        // Strongly Disagree button implementation
        mStrongDisagreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scale = -100;
                switch(mCurrentIndex){
                    case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
                        if (0 <= mCurrentIndex && mCurrentIndex <= 2){
                            mKeeper.updateScore(1, "E", scale);
                        }
                        if (3 <= mCurrentIndex && mCurrentIndex <= 6){
                            mKeeper.updateScore(1, "M", scale);
                        }
                        if (7 <= mCurrentIndex && mCurrentIndex <= 9){
                            mKeeper.updateScore(1, "W", scale);
                        }
                    case 10: case 11: case 12: case 13: case 14: case 15: case 16: case 17: case 18: case 19:
                        if (10 <= mCurrentIndex && mCurrentIndex <= 12){
                            mKeeper.updateScore(2, "E", scale);
                        }
                        if (13 <= mCurrentIndex && mCurrentIndex <= 16){
                            mKeeper.updateScore(2, "M", scale);
                        }
                        if (17 <= mCurrentIndex && mCurrentIndex <= 19){
                            mKeeper.updateScore(2, "W", scale);
                        }

                    case 20: case 21: case 22: case 23: case 24: case 25: case 26: case 27: case 28: case 29:
                        if (10 <= mCurrentIndex && mCurrentIndex <= 12){
                            mKeeper.updateScore(3, "E", scale);
                        }
                        if (13 <= mCurrentIndex && mCurrentIndex <= 16){
                            mKeeper.updateScore(3, "M", scale);
                        }
                        if (17 <= mCurrentIndex && mCurrentIndex <= 19){
                            mKeeper.updateScore(3, "W", scale);
                        }
                    case 30: case 31: case 32: case 33: case 34: case 35: case 36: case 37: case 38: case 39:
                        if (10 <= mCurrentIndex && mCurrentIndex <= 12){
                            mKeeper.updateScore(4, "E", scale);
                        }
                        if (13 <= mCurrentIndex && mCurrentIndex <= 16){
                            mKeeper.updateScore(4, "M", scale);
                        }
                        if (17 <= mCurrentIndex && mCurrentIndex <= 19){
                            mKeeper.updateScore(4, "W", scale);
                        }
                }
                displayScore();
            }
        });

        // Submit Quiz for final ideology implementation
        mSubmitQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mKeeper.setIdeology(mIdeologyTextView);
                mIdeologyTextView = mKeeper.getIdeology();
                mIdeologyTextView.setVisibility(View.VISIBLE);

            }
        });



        // set initial question
        updateQuestion();

    }

    /**
     * Private method to handle back/next button
     */
    private void updateQuestion(){
        int question = mQuestionBank.get(mCurrentIndex).getTextResId();
        mQuestionTextView.setText(question);

    }

    private void displayScore(){
        String scoreHolder = "(" + mKeeper.getXCoordinate() + ", " + mKeeper.getYCoordinate() + " )";
    }




    /**
     * Private method for adding questions to question bank
     * @return ArrayList of questions
     */
    private ArrayList<Question> makeQuestions(){
        ArrayList<Question> result = new ArrayList<>();
        result.add(new Question(R.string.question1, 1,"E"));
        result.add(new Question(R.string.question2, 1,"E"));
        result.add(new Question(R.string.question3, 1,"E"));
        result.add(new Question(R.string.question4, 1,"M"));
        result.add(new Question(R.string.question5, 1,"M"));
        result.add(new Question(R.string.question6, 1,"M"));
        result.add(new Question(R.string.question7, 1,"M"));
        result.add(new Question(R.string.question8, 1,"W"));
        result.add(new Question(R.string.question9, 1,"W"));
        result.add(new Question(R.string.question10, 1,"W"));

        result.add(new Question(R.string.question11, 2,"E"));
        result.add(new Question(R.string.question12, 2,"E"));
        result.add(new Question(R.string.question13, 2,"E"));
        result.add(new Question(R.string.question14, 2,"M"));
        result.add(new Question(R.string.question15, 2,"M"));
        result.add(new Question(R.string.question16, 2,"M"));
        result.add(new Question(R.string.question17, 2,"M"));
        result.add(new Question(R.string.question18, 2,"W"));
        result.add(new Question(R.string.question19, 2,"W"));
        result.add(new Question(R.string.question20, 2,"W"));

        result.add(new Question(R.string.question21, 2,"E"));
        result.add(new Question(R.string.question22, 2,"E"));
        result.add(new Question(R.string.question23, 2,"E"));
        result.add(new Question(R.string.question24, 2,"M"));
        result.add(new Question(R.string.question25, 2,"M"));
        result.add(new Question(R.string.question26, 2,"M"));
        result.add(new Question(R.string.question27, 2,"M"));
        result.add(new Question(R.string.question28, 2,"W"));
        result.add(new Question(R.string.question29, 2,"W"));
        result.add(new Question(R.string.question30, 2,"W"));

        result.add(new Question(R.string.question31, 2,"E"));
        result.add(new Question(R.string.question32, 2,"E"));
        result.add(new Question(R.string.question33, 2,"E"));
        result.add(new Question(R.string.question34, 2,"M"));
        result.add(new Question(R.string.question35, 2,"M"));
        result.add(new Question(R.string.question36, 2,"M"));
        result.add(new Question(R.string.question37, 2,"M"));
        result.add(new Question(R.string.question38, 2,"W"));
        result.add(new Question(R.string.question39, 2,"W"));
        result.add(new Question(R.string.question40, 2,"W"));

        return result;
    }
}
