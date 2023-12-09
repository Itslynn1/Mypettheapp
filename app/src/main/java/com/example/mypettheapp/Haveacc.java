package com.example.mypettheapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Haveacc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haveacc);
    }
    public void startNewActivity3(View v){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
        finish();
    }
}