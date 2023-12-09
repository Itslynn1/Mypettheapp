package com.example.mypettheapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        int drawable = getIntent().getIntExtra("drawable", R.drawable.another);
        ImageView icon = findViewById(R.id.imageViewPet);
        icon.setImageResource(drawable);

        Button btn_boy = findViewById(R.id.btn_boy);
        Button btn_girl = findViewById(R.id.btn_girl);

        btn_boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPetDetailsActivity("Мальчик");
            }
        });

        btn_girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPetDetailsActivity("Девочка");
            }
        });
    }

    private void openPetDetailsActivity(String gender) {
        Intent intent = new Intent(this, PushSetup.class);
        intent.putExtra("gender", gender);
        startActivity(intent);
    }
}


