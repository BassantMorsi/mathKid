package com.example.bassant.kidsmath;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    int locationOfCorrectAnswer;
    MediaPlayer mp;
    LinearLayout l ;
    Button b0;
    Button b1;
    Button b2;
    Button b3;
    ArrayList<Integer> answers;
    Random rand;
    String opName;
    TextView equation;
    public void chosenAnswer(View view)
    {

        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            l.setBackgroundColor(Color.GREEN);
            mp=MediaPlayer.create(this,R.raw.t);
            mp.start();
            generateQuestion();
        }
        else{
            mp=MediaPlayer.create(this,R.raw.w);
            l.setBackgroundColor(Color.RED);
            mp.start();
        }

        //Log.i("Tag", (String) view.getTag());
    }

 public void generateQuestion()
    {
        int a,b;
        l.setBackgroundColor(Color.WHITE);
        rand =new Random();
        answers.clear();
        locationOfCorrectAnswer =rand.nextInt(4);
        if(opName.equals("+"))
        {
            a = rand.nextInt(101);
            b = rand.nextInt(101);

            equation.setText(Integer.toString(a)+" + "+Integer.toString(b));
            for (int i=0;i<4;i++)
            {
                if(i==locationOfCorrectAnswer)
                {
                    answers.add(a+b);
                }else
                {
                    int inCorrectAnswer = rand.nextInt(201);
                    while(inCorrectAnswer == a+b)
                    {inCorrectAnswer = rand.nextInt(201);}
                    answers.add(inCorrectAnswer);
                }

            }
            b0.setText(Integer.toString(answers.get(0)));
            b1.setText(Integer.toString(answers.get(1)));
            b2.setText(Integer.toString(answers.get(2)));
            b3.setText(Integer.toString(answers.get(3)));
        }else if(opName.equals("-"))
        {
            a = rand.nextInt(101);
            b = rand.nextInt(101);
            while(b>a)
            {
                b = rand.nextInt(101);
            }

            equation.setText(Integer.toString(a)+" - "+Integer.toString(b));
            for (int i=0;i<4;i++)
            {
                if(i==locationOfCorrectAnswer)
                {
                    answers.add(a-b);
                }else
                {
                    int inCorrectAnswer = rand.nextInt(101);
                    while(inCorrectAnswer == a-b)
                    {inCorrectAnswer = rand.nextInt(101);}
                    answers.add(inCorrectAnswer);
                }

            }
            b0.setText(Integer.toString(answers.get(0)));
            b1.setText(Integer.toString(answers.get(1)));
            b2.setText(Integer.toString(answers.get(2)));
            b3.setText(Integer.toString(answers.get(3)));
        }
        else if(opName.equals("*"))
        {
            a = rand.nextInt(16);
            b = rand.nextInt(16);

            equation.setText(Integer.toString(a)+" * "+Integer.toString(b));
            for (int i=0;i<4;i++)
            {
                if(i==locationOfCorrectAnswer)
                {
                    answers.add(a*b);
                }else
                {
                    int inCorrectAnswer = rand.nextInt(226);
                    while(inCorrectAnswer == a*b)
                    {inCorrectAnswer = rand.nextInt(226);}
                    answers.add(inCorrectAnswer);
                }

            }
            b0.setText(Integer.toString(answers.get(0)));
            b1.setText(Integer.toString(answers.get(1)));
            b2.setText(Integer.toString(answers.get(2)));
            b3.setText(Integer.toString(answers.get(3)));
        }
        else if(opName.equals("÷"))
        {
            a = rand.nextInt(16);
            b = rand.nextInt(16);
            int r = a*b;
            equation.setText(r+" ÷ "+Integer.toString(b));
            for (int i=0;i<4;i++)
            {
                if(i==locationOfCorrectAnswer)
                {
                    answers.add(a);
                }else
                {
                    int inCorrectAnswer = rand.nextInt(16);
                    while(inCorrectAnswer == a ||inCorrectAnswer == b)
                    {inCorrectAnswer = rand.nextInt(16);}
                    answers.add(inCorrectAnswer);
                }

            }
            b0.setText(Integer.toString(answers.get(0)));
            b1.setText(Integer.toString(answers.get(1)));
            b2.setText(Integer.toString(answers.get(2)));
            b3.setText(Integer.toString(answers.get(3)));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
         opName= intent.getStringExtra("operation");
        Toast.makeText(getApplicationContext(),opName,Toast.LENGTH_LONG).show();
        l = (LinearLayout)findViewById(R.id.background)  ;
        b0 =(Button) findViewById(R.id.button0);
        b1 =(Button) findViewById(R.id.button1);
        b2 =(Button) findViewById(R.id.button2);
        b3 =(Button) findViewById(R.id.button3);
        answers =new ArrayList<>();
        equation = (TextView)findViewById(R.id.textView);
     generateQuestion();
    }
}
