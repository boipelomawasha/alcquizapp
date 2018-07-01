package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.xeoh.android.checkboxgroup.CheckBoxGroup;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            checkBoxMap.put((CheckBox) findViewById(R.id.question_4_1), "Question4_Option1");
            checkBoxMap.put((CheckBox) findViewById(R.id.question_4_2), "Question4_Option2");
            checkBoxMap.put((CheckBox) findViewById(R.id.question_4_3), "Question4_Option3");
            checkBoxMap.put((CheckBox) findViewById(R.id.question_5_1), "Question5_Option1");
            checkBoxMap.put((CheckBox) findViewById(R.id.question_5_2), "Question5_Option2");
            checkBoxMap.put((CheckBox) findViewById(R.id.question_5_3), "Question5_Option3");
    }

    //Variables for the correct answers
    final String answerQ1 = "Scythe";
    final String answerQ2 = "Garganta";
    final String answerQ3 = "Mugetsu";
    final String[] answersQ4 = {"Rōjūrō Ōtoribashi", "Kensei Muguruma"};
    final String[] answersQ5 = {"Sternritter", "Jagdarmee"};
    final String answerQ6 = "Retsu Unohana";

    //Variables for user answers
    String userAnswerQ1 = "Scythe";
    String userAnswerQ2 = "Garganta";
    String userAnswerQ3 = "Mugetsu";
    String[] userAnswersQ4 = {"Rōjūrō Ōtoribashi", "Kensei Muguruma"};
    String[] userAnswersQ5 = {"Sternritter", "Jagdarmee"};
    String userAnswerQ6 = "Retsu Unohana";

    HashMap<CheckBox, String> checkBoxMap = new HashMap<>();



    int correctResponse = 0;
    int incorrectResponse = 0;
    String finalMessage = "";
    boolean allQuestionsAnswered = false;


    /**
     * Public methods
     */

    public void submit(View v){

    }

    //Resets the quiz
    public void reset(View v){


        RadioGroup rgQuestion1 = (RadioGroup) findViewById(R.id.question_1_group);
        RadioGroup rgQuestion2 = (RadioGroup) findViewById(R.id.question_2_group);
        RadioGroup rgQuestion3 = (RadioGroup) findViewById(R.id.question_3_group);
        CheckBox chkQuestion4_1 = (CheckBox) findViewById(R.id.question_4_1);
        CheckBox chkQuestion4_2 = (CheckBox) findViewById(R.id.question_4_2);
        CheckBox chkQuestion4_3 = (CheckBox) findViewById(R.id.question_4_3);
        CheckBox chkQuestion5_1 = (CheckBox) findViewById(R.id.question_5_1);
        CheckBox chkQuestion5_2 = (CheckBox) findViewById(R.id.question_5_2);
        CheckBox chkQuestion5_3 = (CheckBox) findViewById(R.id.question_5_3);
        TextView txtQuestion6 = (TextView) findViewById(R.id.question_6_1);

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

    }


    /**
     * Private methods
     */

}
