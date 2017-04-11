package com.example.android.finalprojectquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * This app displays the quiz.
 */

public class MainActivity extends AppCompatActivity {

    //This score shows how many answers the user gt correct out of 100
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the check results button is clicked. It calculates the final score
     */

    public void checkResults(View view) {
        //Find users name
        EditText nameTextField = (EditText) findViewById(R.id.name_text_field);
        String name = nameTextField.getText().toString();

        //This section identifies all the checkboxes & radiobuttons that contain the correct answer.

        //Figure out if the user chose TRUE radiobutton for question 1
        RadioButton trueRadioButton1 = (RadioButton) findViewById(R.id.true_question_1);
        boolean isTrueRadioButton1 = trueRadioButton1.isChecked();

        //Figure out if the user chose FALSE radiobutton for question 3
        RadioButton falseRadioButton3 = (RadioButton) findViewById(R.id.false_question_3);
        boolean isFalseRadioButton3 = falseRadioButton3.isChecked();

        //Figure out if the user checked the pineal gland checkbox for question 6
        CheckBox pinealCheckBox = (CheckBox) findViewById(R.id.pineal_checkbox);
        boolean isPinealCheckbox = pinealCheckBox.isChecked();

        //Figure out if the user checked the pituitary gland checkbox for question 6
        CheckBox pituitaryCheckBox = (CheckBox) findViewById(R.id.pituitary_checkbox);
        boolean isPituitaryCheckbox = pituitaryCheckBox.isChecked();

        //Figure out if the user chose TRUE radiobutton for question 9
        RadioButton trueRadioButton9 = (RadioButton) findViewById(R.id.true_question_9);
        boolean isTrueRadioButton9 = trueRadioButton9.isChecked();

        //Figure out if the user chose FALSE radiobutton for question 10
        RadioButton falseRadioButton10 = (RadioButton) findViewById(R.id.false_question_10);
        boolean isFalseRadioButton10 = falseRadioButton10.isChecked();

        //Figure out if the user chose '2' radiobutton for question 5
        RadioButton _2 = (RadioButton) findViewById(R.id._2);
        Boolean is2 = _2.isChecked();

        //Figure out if the user chose 'heart' radiobutton for question 8
        RadioButton heartAnswer = (RadioButton) findViewById(R.id.heart_answer);
        Boolean isHeartAnswer = heartAnswer.isChecked();

        //This section changes the answers given in the EditText field(s) to lower case.
        // This is beneficial as it will allow the user to get the points whether the answer is in capitals or not
        EditText question2TextField = (EditText) findViewById(R.id.question_2_text_field);
        String question2Answer = question2TextField.getText().toString().toLowerCase();

        EditText question4TextField = (EditText) findViewById(R.id.question_4_text_field);
        String question4Answer = question4TextField.getText().toString().toLowerCase();

        EditText question7TextField = (EditText) findViewById(R.id.question_7_text_field);
        String question7Answer = question7TextField.getText().toString().toLowerCase();

        //Calculates the score
        score = calculateScore(isTrueRadioButton1, question2Answer, isFalseRadioButton3, question4Answer, is2, isPinealCheckbox, isPituitaryCheckbox, question7Answer, isHeartAnswer, isTrueRadioButton9, isFalseRadioButton10);

        //Display the result summary on the screen
        createResultSummary(name, score);

    }

    /**
     * Calculates the score of quiz.
     *
     * @param isTrueRadioButton1   is the true radiobutton for question 1
     * @param question2Answer      is the answer for question 2
     * @param isFalseRadioButton3  is the false radiobutton for question 3
     * @param question4Answer      is the answer for question 4
     * @param is2                  is the answer to question 5
     * @param isPinealCheckbox     is the pineal checkbox for question 6
     * @param isPituitaryCheckbox  is the pituitary checkbox for question 6
     * @param question7Answer      is the answer for question 7
     * @param isHeartAnswer        is the heart answer for question 8
     * @param isTrueRadioButton9   is the true radiobutton for question 9
     * @param isFalseRadioButton10 is the false radiobutton for question 10
     * @return total score
     */
    private int calculateScore(boolean isTrueRadioButton1, String question2Answer, boolean isFalseRadioButton3, String question4Answer, boolean is2, boolean isPinealCheckbox, boolean isPituitaryCheckbox, String question7Answer, boolean isHeartAnswer, boolean isTrueRadioButton9, boolean isFalseRadioButton10) {
        //Starting score
        score = 0;
        {

            //Using IF statement,  + 10 points for every time the right answer is given for checkboxes & radiobuttons

            if (isTrueRadioButton1) {
                score = score + 10;
            }

            //  This states what that answer in the Edit text field should be
            if (question2Answer.contains("yes")) {
                score = score + 10;
            }
            if (isFalseRadioButton3) {
                score = score + 10;
            }

            //  This states what th answer in the Edit text field should be
            if (question4Answer.contains("skull")) {
                score = score + 10;
            }

            if (is2) {
                score = score + 10;
            }

            //There are 2 right answers for question 6. Both answers have to be checked hence using "&&" operator
            if (isPinealCheckbox && isPituitaryCheckbox) {
                score = score + 10;
            }

            //  This states what the answer in the Edit text field should be
            if (question7Answer.contains("3.3")) {
                score = score + 10;
            }

            if (isHeartAnswer) {
                score = score + 10;
            }

            if (isTrueRadioButton9) {
                score = score + 10;
            }
            if (isFalseRadioButton10) {
                score = score + 10;
            }
        }
        return score;
    }

    /**
     * Creates summary of the results in a short toast.
     *
     * @param name  of user
     * @param score of quiz
     * @return text summary
     */
    private String createResultSummary(String name, int score) {
        String message = "Name : " + name;
        if (score >= 50) {
            message += "\nYour score is : " + score + "!! WOOHOO";
        } else if (score <= 50) {
            message += "\nYour score is : " + score + "\nTry again. You can do it";
        }
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();
        return message;
    }

}