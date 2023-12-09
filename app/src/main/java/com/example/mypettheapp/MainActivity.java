package com.example.mypettheapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mypettheapp.ui.LocaleHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Добавленный код для кнопки смены языка
        Button changeLanguageButton = findViewById(R.id.changeLanguageButton);
        changeLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Получаем текущий язык
                String currentLanguage = LocaleHelper.getLanguage(MainActivity.this);

                // Проверяем текущий язык и меняем на другой
                if (currentLanguage.equals("kk")) {
                    setNewLocale("ru", MainActivity.this);
                } else {
                    setNewLocale("kk", MainActivity.this);
                }

                // Перезапустите активность, чтобы изменения вступили в силу
                recreate();
            }
        });
    }

    public void startNewActivity(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }

    private void setNewLocale(String language, Context context) {
        LocaleHelper.setLocale(context, language);
    }
}
