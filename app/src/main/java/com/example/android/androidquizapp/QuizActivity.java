package com.example.android.androidquizapp;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private String userNameForDisplaying;
    private int amountOfCorrectAnswers = 0;
    private boolean submitted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Here is loaded user name which is getting from MainActivity screen and saving into String variable
        userNameForDisplaying = getIntent().getStringExtra("USER_NAME");

        /**
         * This method supports the SUBMIT button
         */
        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkQuizAndShowResult();
                submitted = true;
            }
        });
    }


    /**
     * This method checks all the answers of the quiz and show Toast message with amounts of achieved points
     */
    public void checkQuizAndShowResult() {

        if (!submitted) {
            if (this.checkQuestionOne()) {
                amountOfCorrectAnswers++;
            }
            if (this.checkQuestionTwo()) {
                amountOfCorrectAnswers++;
            }
            if (this.checkQuestionThree()) {
                amountOfCorrectAnswers++;
            }
            if (this.checkQuestionFour()) {
                amountOfCorrectAnswers++;
            }
            if (this.checkQuestionFive()) {
                amountOfCorrectAnswers++;
            }

            this.showToastResult(amountOfCorrectAnswers);

        } else {
            this.showToastResult(amountOfCorrectAnswers);
        }
    }


    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionOne() {
        RadioButton correctAnswer = (RadioButton) findViewById(R.id.q1_rb_2);
        correctAnswer.setTextColor(Color.parseColor("green"));
        return correctAnswer.isChecked();
    }

    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionTwo() {
        CheckBox correctAnswer1 = (CheckBox) findViewById(R.id.q2_checkbox_2);
        CheckBox correctAnswer2 = (CheckBox) findViewById(R.id.q2_checkbox_4);
        correctAnswer1.setTextColor(Color.parseColor("green"));
        correctAnswer2.setTextColor(Color.parseColor("green"));
        return (!((CheckBox) findViewById(R.id.q2_checkbox_1)).isChecked() && correctAnswer1.isChecked()
                && !((CheckBox) findViewById(R.id.q2_checkbox_3)).isChecked() && correctAnswer2.isChecked());
    }


    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionThree() {
        EditText answer = ((EditText) findViewById(R.id.q3_editTextField));

        String answerValue = answer.getText().toString().toLowerCase();
        if (answerValue.equals("scrollview")) {
            answer.getBackground().setColorFilter(getResources().getColor(R.color.startButtonColor), PorterDuff.Mode.SRC_ATOP);
        } else {
            answer.getBackground().setColorFilter(getResources().getColor(R.color.wrongAnswerColor), PorterDuff.Mode.SRC_ATOP);
        }
        return answerValue.contains("scrollview");
    }


    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect.
     */
    public boolean checkQuestionFour() {
        CheckBox correctAnswer1 = (CheckBox) findViewById(R.id.q4_checkbox_1);
        CheckBox correctAnswer2 = (CheckBox) findViewById(R.id.q4_checkbox_2);

        correctAnswer1.setTextColor(Color.parseColor("green"));
        correctAnswer2.setTextColor(Color.parseColor("green"));


        return (((CheckBox) findViewById(R.id.q4_checkbox_1)).isChecked() && ((CheckBox) findViewById(R.id.q4_checkbox_2)).isChecked()
                && !((CheckBox) findViewById(R.id.q4_checkbox_3)).isChecked() && !((CheckBox) findViewById(R.id.q4_checkbox_4)).isChecked());
    }

    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionFive() {
        RadioButton correctAnswer = (RadioButton) findViewById(R.id.q5_rb_2);
        correctAnswer.setTextColor(Color.parseColor("green"));
        return ((RadioButton) findViewById(R.id.q5_rb_2)).isChecked();
    }

    /**
     * Displays the TOAST with final message
     *
     * @param amountOfCorrectAnswers the number of correct answers
     */
    public void showToastResult(int amountOfCorrectAnswers) {

        String specialMessage = "";

        if (amountOfCorrectAnswers == 5) {
            specialMessage = "Congratulations!";
        } else if (amountOfCorrectAnswers == 0) {
            specialMessage = "Don't say anything, just close the app :(";
        } else if (amountOfCorrectAnswers < 5) {
            specialMessage = "Your score can be better!";
        }

        // This method shows Toast message with amount of achieved points and an extra message
        Toast.makeText(this, userNameForDisplaying + ", you got " + amountOfCorrectAnswers + "/5! " + specialMessage, Toast.LENGTH_SHORT).show();
    }

}
