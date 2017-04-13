package com.example.android.androidquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    String userNameForDisplaying;
    int amountOfCorrectAnswers = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        userNameForDisplaying = getIntent().getStringExtra("USER_NAME");

    }

    /**
     * This method checks all the answers of the quiz.
     */
    public void checkQuizAndShowResult(View view) {

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
    }

    /**
     * Checks if answer is correct
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionOne() {
        return ((RadioButton) findViewById(R.id.q1_rb_2)).isChecked();
    }

    /**
     * Checks if answer is correct
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionTwo() {
        return (!((CheckBox) findViewById(R.id.q2_checkbox_1)).isChecked() && ((CheckBox) findViewById(R.id.q2_checkbox_2)).isChecked()
                && !((CheckBox) findViewById(R.id.q2_checkbox_3)).isChecked() && !((CheckBox) findViewById(R.id.q2_checkbox_4)).isChecked());
    }


    /**
     * Checks if answer is correct
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionThree() {
        String answer = ((EditText) findViewById(R.id.q3_editTextField)).getText().toString().toLowerCase();
        return answer.contains("relativelayout");
    }


    /**
     * Checks if answer is correct
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionFour() {
        return (((CheckBox) findViewById(R.id.q4_checkbox_1)).isChecked() && ((CheckBox) findViewById(R.id.q4_checkbox_2)).isChecked()
                && !((CheckBox) findViewById(R.id.q4_checkbox_3)).isChecked() && !((CheckBox) findViewById(R.id.q4_checkbox_4)).isChecked());
    }

    /**
     * Checks if answer is correct
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionFive() {
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
        } else if (amountOfCorrectAnswers < 5) {
            specialMessage = "Your score can be better!";
        } else if (amountOfCorrectAnswers == 0) {
            specialMessage = "Try again, you are close!";
        }

        Toast.makeText(this, userNameForDisplaying + ", you got " + amountOfCorrectAnswers + "/5! " + specialMessage, Toast.LENGTH_SHORT).show();
        return;
    }

}
