package com.example.claculate_project1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView result;
     String operator="";
     String firstNumber="";
    boolean isOperatorClicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        result= findViewById(R.id.textViewResult);
        result.setText("");
    }

    public void numberFunc(View view) {
        Button button = (Button) view;
        if (isOperatorClicked) {
            result.setText(button.getText());
            isOperatorClicked = false;
        } else {
            if (result.getText().toString().equals("0")) {
                result.setText(button.getText());
            } else {
                result.append(button.getText());
            }

    }
        }

    public void deleteFunc(View view) {
        result.setText("0");
        firstNumber = "";
        operator = "";
        isOperatorClicked = false;
    }

    public void equelFunc(View view) {
        String secondNumber= result.getText().toString();
        double num1 = Double.parseDouble(firstNumber);
        double num2 = Double.parseDouble(secondNumber);
        double answer = 0;

        if (operator.equals("+")) {
            answer = num1 + num2;
        } else if (operator.equals("-")) {
            answer = num1 - num2;
        } else if (operator.equals("X")) {
            answer = num1 * num2;
        } else if (operator.equals("%")) {
            answer = num1 / num2;
        }
        result.setText(String.valueOf(answer));

    }

    public void opertorFunc(View view) {
        Button button= (Button) view;
        operator= button.getText().toString();
        firstNumber=result.getText().toString();
        isOperatorClicked = true;

    }
}