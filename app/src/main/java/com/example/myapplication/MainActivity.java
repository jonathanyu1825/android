package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numInput1, numInput2;
    TextView res;
    int first, second;
    enum OP {ADD, SUBTRACT, MULTIPLY, DIVIDE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = findViewById(R.id.Add);
        Button subtract = findViewById(R.id.Subtract);
        Button multiply = findViewById(R.id.Multiply);
        Button divide = findViewById(R.id.Divide);

        numInput1 = findViewById(R.id.num1);
        numInput2 = findViewById(R.id.num2);
        res = findViewById(R.id.result);
        res.setText("");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(OP.ADD);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(OP.SUBTRACT);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(OP.MULTIPLY);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(OP.DIVIDE);
            }
        });
    }

    void calculate(OP oper) {
        try {
            first = Integer.parseInt(numInput1.getText().toString());
            second = Integer.parseInt(numInput2.getText().toString());
            float value = 0;
            switch (oper) {
                case ADD:
                    value = first + second;
                    break;
                case SUBTRACT:
                    value = first - second;
                    break;
                case MULTIPLY:
                    value = first * second;
                    break;
                case DIVIDE:
                    if (second == 0) {
                        Toast.makeText(this, "Cannot divide by 0.", Toast.LENGTH_SHORT).show();
                    } else {
                        value = (float) first / second;
                    }
                    break;
            }
            res.setText(String.valueOf(value));
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Please enter two valid numbers.", Toast.LENGTH_SHORT).show();
            res.setText("");
        }
    }
}



