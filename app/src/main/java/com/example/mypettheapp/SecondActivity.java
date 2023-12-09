package com.example.mypettheapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


     public void startNewActivity(View v) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
        finish();
    }
    public void startNewActivity2(View v) {
        Intent intent = new Intent(this, Haveacc.class);
        startActivity(intent);
        finish();
    }
}


