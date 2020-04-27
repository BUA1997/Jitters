package com.example.jitters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class ExampleSwitch extends AppCompatActivity {
Switch aSwitch;
ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_switch);

        constraintLayout=findViewById(R.id.con1);
        aSwitch= findViewById(R.id.switch2);

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aSwitch.isChecked()) {
                    constraintLayout.setBackgroundColor(Color.BLUE);

                }
                else  constraintLayout.setBackgroundColor(Color.BLACK);
            }
        });
    }
}
