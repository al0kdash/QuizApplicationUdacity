package com.example.aloknath.myquizapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int correct_ans=0;
    String grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        correct_ans = 0;

        //Question1
        RadioButton rb1=(RadioButton)findViewById(R.id.rb12);
        if(rb1.isChecked())
            correct_ans++;

        //Question2
        CheckBox cb1=(CheckBox)findViewById(R.id.cb1);
        CheckBox cb2=(CheckBox)findViewById(R.id.cb2);
        CheckBox cb3=(CheckBox)findViewById(R.id.cb3);
        CheckBox cb4=(CheckBox)findViewById(R.id.cb4);
        if(cb1.isChecked() && cb2.isChecked() && ! cb3.isChecked() && ! cb4.isChecked())
            correct_ans=correct_ans+1;

        //Question3
        RadioButton rb2=(RadioButton)findViewById(R.id.rb21);
        if(rb2.isChecked())
            correct_ans=correct_ans+1;

        //Question4
        RadioButton rb3=(RadioButton)findViewById(R.id.rb31);
        if(rb3.isChecked())
            correct_ans=correct_ans+1;

        //Question5
        RadioButton rb4=(RadioButton)findViewById(R.id.rb43);
        if(rb4.isChecked())
            correct_ans=correct_ans+1;

        //Question6
        EditText editText1 = (EditText)findViewById(R.id.answer);
        String check_string = editText1.getText().toString().toLowerCase();
        String[] arr = {"p","android p"};
        for(int i=0;i<2;i++){
            if(check_string.equals(arr[i]))
                correct_ans=correct_ans+1;
        }

        //CalculateGrade
        if(correct_ans==5)
            grade = "A";
        else if(correct_ans==4)
            grade = "B";
        else if(correct_ans==3)
            grade = "C";
        else if(correct_ans==2)
            grade = "D";
        else if(correct_ans==1)
            grade = "E";
        else if(correct_ans==0)
            grade = "F";
        else
            grade = "A+";

        Toast.makeText(this,"Total Correct Answer: "+correct_ans+"\nYou have received Grade: "+grade,Toast.LENGTH_LONG).show();
    }

    public void Clear(View view) {
        correct_ans=0;
        CheckBox cb1 = (CheckBox) findViewById(R.id.cb1);
        CheckBox cb2 = (CheckBox) findViewById(R.id.cb2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.cb3);
        CheckBox cb4  = (CheckBox) findViewById(R.id.cb4);
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.rg2);
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.rg3);
        RadioGroup rg4 = (RadioGroup) findViewById(R.id.rg4);
        EditText editText1=(EditText) findViewById(R.id.answer);
        rg1.clearCheck();
        rg2.clearCheck();
        rg3.clearCheck();
        rg4.clearCheck();
        editText1.setText("");
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);
    }
}
