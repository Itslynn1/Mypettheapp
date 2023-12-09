package com.example.mypettheapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class PushSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_setup);
        Switch switch1 = findViewById(R.id.switch7);
        Switch switch2= findViewById(R.id.switch6);
        Switch switch3 = findViewById(R.id.switch1);
        Switch switch4 = findViewById(R.id.switch11);
        Switch switch5 = findViewById(R.id.switch12);
        Switch switch6 = findViewById(R.id.switch14);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showNotification("Лекарства", isChecked);
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showNotification("Вакцинация", isChecked);
            }
        });

        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showNotification("Имидж", isChecked);
            }
        });

        switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showNotification("Блохи", isChecked);
            }
        });

        switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showNotification("Прогулка", isChecked);
            }
        });

        switch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showNotification("Еда", isChecked);
            }
        });
    }

    private void showNotification(String reminder, boolean isChecked) {
        String message = isChecked ? "Напоминание включено: " + reminder : "Напоминание выключено: " + reminder;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private Calendar reminderCalendar = Calendar.getInstance();


    // Метод, вызываемый при нажатии на кнопку "Настроить напоминание"
    public void onSetReminderClick(View view) {
        showDateTimePicker();
    }

    private void showDateTimePicker() {
        // Инициализация DatePickerDialog с текущей датой
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                dateSetListener,
                reminderCalendar.get(Calendar.YEAR),
                reminderCalendar.get(Calendar.MONTH),
                reminderCalendar.get(Calendar.DAY_OF_MONTH)
        );

        // Устанавливаем минимальную дату на сегодняшний день
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

    private void showTimePicker() {
        // Инициализация TimePickerDialog с текущим временем
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                timeSetListener,
                reminderCalendar.get(Calendar.HOUR_OF_DAY),
                reminderCalendar.get(Calendar.MINUTE),
                true
        );

        timePickerDialog.show();
    }

    private final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            // Установка выбранной даты и вызов TimePicker
            reminderCalendar.set(Calendar.YEAR, year);
            reminderCalendar.set(Calendar.MONTH, month);
            reminderCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            showTimePicker();
        }
    };

    private final TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Установка выбранного времени и сохранение напоминания
            reminderCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            reminderCalendar.set(Calendar.MINUTE, minute);

            saveNotification();

            // Вывод уведомления о сохранении
            Toast.makeText(PushSetup.this, "Напоминание сохранено", Toast.LENGTH_SHORT).show();
        }
    };
    private void saveNotification() {
// Используем SharedPreferences для сохранения данных о напоминании

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Сохраняем данные
        editor.putLong("reminderTime", reminderCalendar.getTimeInMillis());
        editor.putBoolean("isReminderEnabled", true);
        editor.apply();
        startActivity(new Intent(PushSetup.this, AcountActivity.class));
    }

    }




