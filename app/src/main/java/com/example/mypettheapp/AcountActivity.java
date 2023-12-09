package com.example.mypettheapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class AcountActivity extends AppCompatActivity {

    private View drawerMenu;
    private ImageButton burgerMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acount);

        drawerMenu = findViewById(R.id.drawerMenu);
        burgerMenuButton = findViewById(R.id.Burger_menu);

        burgerMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDrawer();
            }
        });
    }

    private void toggleDrawer() {
        if (drawerMenu.getVisibility() == View.VISIBLE) {
            drawerMenu.setVisibility(View.INVISIBLE);
        } else {
            drawerMenu.setVisibility(View.VISIBLE);
        }
    }
}