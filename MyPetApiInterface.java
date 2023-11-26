package com.example.mypettheapp.api;

import com.example.mypettheapp.api.dto.CreatePetDto;
import com.example.mypettheapp.api.dto.CreateUserRequestDto;
import com.example.mypettheapp.api.dto.CreateUserResponseDto;
import com.example.mypettheapp.api.dto.PetItemDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyPetApiInterface {

    // User section
    @Headers({"ngrok-skip-browser-warning: true"})
    @POST("user")
    Call<CreateUserResponseDto> createUser(@Body CreateUserRequestDto dto);

    // Pet section
    @GET("pet")
    Call<List<PetItemDto>> getPetsForUser(@Query("userId") String userId);

    @POST("pet")
    Call<Object> createPet(@Body CreatePetDto dto);

}
