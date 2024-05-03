package com.itspace.demoandroidapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView resultView;
    private EditText numberField1;
    private EditText numberField2;
    private Button plusButton;
    private Button minusButton;
    private static final String EXIT_DIALOG_TEXT = "Dou you want to leave the program?";

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
        resultView = findViewById(R.id.result_view);
        numberField1 = findViewById(R.id.number_field_1);
        numberField2 = findViewById(R.id.number_field_2);
        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(numberField1.getText().toString());
                float num2 = Float.parseFloat(numberField2.getText().toString());
                resultView.setText(String.valueOf(num1 + num2));
            }
        });
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(numberField1.getText().toString());
                float num2 = Float.parseFloat(numberField2.getText().toString());
                resultView.setText(String.valueOf(num1 - num2));
            }
        });
    }
    public void onClickExit(View v){
        showExitAlert();
    }

    private void showExitAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit")
                .setMessage(EXIT_DIALOG_TEXT)
                .setCancelable(false)
                .setPositiveButton("exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}