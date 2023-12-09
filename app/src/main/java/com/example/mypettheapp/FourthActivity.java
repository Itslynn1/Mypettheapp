package com.example.mypettheapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class FourthActivity extends AppCompatActivity {

    private String userId;
    private Map<Integer, PetTypeData> typesDictionary = new HashMap<Integer, PetTypeData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        typesDictionary.put(R.id.buttonDog, new PetTypeData(R.drawable.dogicon, "Dog"));
        typesDictionary.put(R.id.buttonCat, new PetTypeData(R.drawable.caticon, "Cat"));
        typesDictionary.put(R.id.buttonHorse, new PetTypeData(R.drawable.horseicon, "Horse"));
        typesDictionary.put(R.id.buttonBunny, new PetTypeData(R.drawable.rabbit, "Rabbit"));
        typesDictionary.put(R.id.buttonBird, new PetTypeData(R.drawable.bird, "Bird"));
        typesDictionary.put(R.id.buttonHamster, new PetTypeData(R.drawable.hamster, "Hamster"));
        typesDictionary.put(R.id.buttonSnake, new PetTypeData(R.drawable.snake, "Snake"));
        typesDictionary.put(R.id.buttonOther, new PetTypeData(R.drawable.another, "Other"));

        userId = getIntent().getStringExtra("userId");
    }

    public void selectType(View v) {
        int id = v.getId();

        PetTypeData typeData = typesDictionary.get(id);

        Intent intent = new Intent(FourthActivity.this, FifthActivity.class);
        intent.putExtra("userId", userId);
        intent.putExtra("drawable", typeData.drawable);
        intent.putExtra("typeName", typeData.typeName);
        startActivity(intent);
    }

    public void startNewActivity(View v) {
        String g = "";
    }
}
