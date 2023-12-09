package com.example.mypettheapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    private static final String BASE_URL = "https://28a4-176-64-18-165.ngrok-free.app";

    private MyPetApiInterface api;

    private static API instance;

    private API() {
        buildClass();
    }

    public static API getInstance() {
        if (instance == null) {
            instance = new API();
        }

        return instance;
    }

    public MyPetApiInterface getApi() {
        return this.api;
    }

    private void buildClass() {
        Retrofit  retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.api = retrofit.create(MyPetApiInterface.class);
    }
}

