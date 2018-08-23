package com.ricardogwill.datepickerdialogapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentDateDefault();
        datePickerDialogButtonOnClick();
    }

    Button datePickerDialogButton;
    int yearX, monthX, dayX;
    static final int DIALOG_ID = 0;

    // Method to have the calendar show the current date by default.
    public void currentDateDefault() {
        final Calendar calendar = Calendar.getInstance();
        yearX = calendar.get(Calendar.YEAR);
        monthX = calendar.get(Calendar.MONTH);
        dayX = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public void datePickerDialogButtonOnClick() {
        datePickerDialogButton = findViewById(R.id.datepicker_dialog_button);

        datePickerDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }
    // This takes an "onDateSetListener" as a parameter, so we need another object below this.
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID) {
            return new DatePickerDialog(this, onDateSetListener, yearX, monthX, dayX);
        } else {
            return null;
        }
    }
    // Here is the "onDateSetListener" with the Toast.  Note that "monthX = month + 1".
    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            yearX = year;
            monthX = month + 1;
            dayX = dayOfMonth;
            Toast.makeText(MainActivity.this, "The date picked is: "
                    + monthX + "/" + dayX + "/" + yearX, Toast.LENGTH_SHORT).show();
        }
    };
}
