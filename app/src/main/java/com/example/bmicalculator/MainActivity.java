package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView result;
        EditText wt, ht_ft,ht_in;
        Button calculate;

        wt = findViewById(R.id.weight);
        ht_ft = findViewById(R.id.height_ft);
        ht_in = findViewById(R.id.height_in);
        result = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weight= Integer.parseInt(wt.getText().toString());
                int height_in = Integer.parseInt(ht_in.getText().toString());
                int height_ft = Integer.parseInt(ht_ft.getText().toString());
                int total_inches = height_ft*12 + height_in;
                double total_m = (total_inches * 2.53) / 100;

                double cal = weight / (total_m * total_m);

                if( cal > 25) {
                    result.setText("OVERWEIGHT");
                    result.setTextColor(getResources().getColor(R.color.Red));
                } else if (cal < 18) {
                    result.setText("UNDERWEIGHT");
                    result.setTextColor(getResources().getColor(R.color.Yellow));
                }
                else {
                    result.setText("HEALTHY");
                    result.setTextColor(getResources().getColor(R.color.Green));
                }


            }
        });


        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}