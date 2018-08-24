package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //Variables for the correct answers
    private String answerQ1;
    private String answerQ2;
    private String answerQ3;
    private List<String> answersQ4 = new ArrayList<String>();
    private List<String> answersQ5 = new ArrayList<String>();
    private String answerQ6;

    //Variables for user answers
    private String userAnswerQ1 = "";
    private String userAnswerQ2 = "";
    private String userAnswerQ3 = "";
    private List<String> userAnswersQ4 = new ArrayList<String>();
    private List<String> userAnswersQ5 = new ArrayList<String>();
    private String userAnswerQ6 = "";

    //Variables for tracking responses
    private int correctResponse = 0;
    private int incorrectResponse = 0;
    private final static int NUMBER_OF_QUESTIONS = 6;
    private boolean allQuestionsAnswered = false;
    private String finalMessage = "";


    //Objects used in more than one method
    private RadioGroup rgQuestion1;
    private RadioGroup rgQuestion2;
    private RadioGroup rgQuestion3;
    private CheckBox chkQuestion4_1;
    private CheckBox chkQuestion4_2;
    private CheckBox chkQuestion4_3;
    private CheckBox chkQuestion5_1;
    private CheckBox chkQuestion5_2;
    private CheckBox chkQuestion5_3;
    private TextView txtQuestion6;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgQuestion1 = (RadioGroup) findViewById(R.id.question_1_group);
        rgQuestion2 = (RadioGroup) findViewById(R.id.question_2_group);
        rgQuestion3 = (RadioGroup) findViewById(R.id.question_3_group);
        chkQuestion4_1 = (CheckBox) findViewById(R.id.question_4_1);
        chkQuestion4_2 = (CheckBox) findViewById(R.id.question_4_2);
        chkQuestion4_3 = (CheckBox) findViewById(R.id.question_4_3);
        chkQuestion5_1 = (CheckBox) findViewById(R.id.question_5_1);
        chkQuestion5_2 = (CheckBox) findViewById(R.id.question_5_2);
        chkQuestion5_3 = (CheckBox) findViewById(R.id.question_5_3);
        txtQuestion6 = (TextView) findViewById(R.id.question_6_1);
        submit = (Button) findViewById(R.id.submit);

    }


    /**
     * Public methods
     */

    public void submit(View v) {

        try {
            grade();
            allQuestionsAnswered = true;
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, R.string.answer_all_questions, Toast.LENGTH_SHORT).show();
        }

        if (allQuestionsAnswered) {
            Toast.makeText(MainActivity.this, finalMessage, Toast.LENGTH_SHORT).show();
            submit = (Button) findViewById(R.id.submit);
            submit.setEnabled(false);
        }
    }

    //Resets the quiz
    public void reset(View v) {

        submit.setEnabled(true);
        rgQuestion1.clearCheck();
        rgQuestion2.clearCheck();
        rgQuestion3.clearCheck();
        chkQuestion4_1.setChecked(false);
        chkQuestion4_2.setChecked(false);
        chkQuestion4_3.setChecked(false);
        chkQuestion5_1.setChecked(false);
        chkQuestion5_2.setChecked(false);
        chkQuestion5_3.setChecked(false);
        txtQuestion6.setText("");
        correctResponse = 0;
        incorrectResponse = 0;
        allQuestionsAnswered = false;
        userAnswersQ4.clear();
        userAnswersQ5.clear();
    }

    /**
     * Private methods
     */

    //Compare user answers to actual answers
    private void compare() {

        getUserResponses();
        setAnswers();

        //Check answer for question 1
        if (userAnswerQ1.equals(answerQ1))
            correctResponse += 1;
        else
            incorrectResponse += 1;

        //Check answer for question 2
        if (userAnswerQ2.equals(answerQ2))
            correctResponse += 1;
        else
            incorrectResponse += 1;

        //Check answer for question 3
        if (userAnswerQ3.equals(answerQ3))
            correctResponse += 1;
        else
            incorrectResponse += 1;

        //Check answer for question 4
        if (userAnswersQ4.equals(answersQ4))
            correctResponse += 1;
        else
            incorrectResponse += 1;

        //Check answer for question 5
        if (userAnswersQ5.equals(answersQ5))
            correctResponse += 1;
        else
            incorrectResponse += 1;

        //Check answer for question 6
        if (userAnswerQ6.equalsIgnoreCase(answerQ6))
            correctResponse += 1;
        else
            incorrectResponse += 1;

    }

    private void getUserResponses() {

        //create variables
        int radioButtonID = 0;
        RadioButton selectedButton;

        //Get answer for question 1
        radioButtonID = rgQuestion1.getCheckedRadioButtonId();
        selectedButton = (RadioButton) rgQuestion1.findViewById(radioButtonID);

        userAnswerQ1 = (String) selectedButton.getText();

        //Get answer for question 2
        radioButtonID = rgQuestion2.getCheckedRadioButtonId();
        selectedButton = (RadioButton) rgQuestion2.findViewById(radioButtonID);

        userAnswerQ2 = (String) selectedButton.getText();

        //Get answer for question 3
        radioButtonID = rgQuestion3.getCheckedRadioButtonId();
        selectedButton = (RadioButton) rgQuestion3.findViewById(radioButtonID);

        userAnswerQ3 = (String) selectedButton.getText();

        //Get answer for question 4
        if (chkQuestion4_1.isChecked())
            userAnswersQ4.add(chkQuestion4_1.getText().toString());
        if (chkQuestion4_2.isChecked())
            userAnswersQ4.add(chkQuestion4_2.getText().toString());
        if (chkQuestion4_3.isChecked())
            userAnswersQ4.add(chkQuestion4_3.getText().toString());

        //Get answer for question 5
        if (chkQuestion5_1.isChecked())
            userAnswersQ5.add(chkQuestion5_1.getText().toString());
        if (chkQuestion5_2.isChecked())
            userAnswersQ5.add(chkQuestion5_2.getText().toString());
        if (chkQuestion5_3.isChecked())
            userAnswersQ5.add(chkQuestion5_3.getText().toString());

        //Get answer for question 6
        userAnswerQ6 = txtQuestion6.getText().toString();

    }

    private void setAnswers() {

        answerQ1 = "Seven";
        answerQ2 = "The Galilean Moons";
        answerQ3 = "The North Star";
        answersQ4.add("Plasma");
        answersQ4.add("Solid");
        answersQ5.add("Bohrium");
        answersQ5.add("Neptunium");
        answerQ6 = "fainting";
    }

    private void grade() {

        //Call the compare method
        compare();

        if (incorrectResponse > 0)
            finalMessage = getString(R.string.final_message_wrong, correctResponse, NUMBER_OF_QUESTIONS);
        else
            finalMessage = getString(R.string.final_message_right, correctResponse, NUMBER_OF_QUESTIONS);

    }

}
