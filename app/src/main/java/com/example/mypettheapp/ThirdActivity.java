package com.example.mypettheapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mypettheapp.api.API;
import com.example.mypettheapp.api.dto.CreateUserRequestDto;
import com.example.mypettheapp.api.dto.CreateUserResponseDto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThirdActivity extends AppCompatActivity {


    public void startNewActivity(View v) {
        Intent intent = new Intent(this, FourthActivity.class);
        startActivity(intent);
        finish(); // Закрываем текущую активность, чтобы нельзя было вернуться назад
    }


    private API api;
    private EditText usernameEditText, passwordEditText, confirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        api = API.getInstance();
        usernameEditText = findViewById(R.id.email_input);
        passwordEditText = findViewById(R.id.password_input);
        confirmPasswordEditText = findViewById(R.id.confirmPassword);

        ImageButton registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получение данных из полей ввода
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();
                Log.d("ThirdActivity", "Нажата кнопка регистрации");


                // Проверка паролей на совпадение
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(ThirdActivity.this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Создание объекта запроса
                CreateUserRequestDto createUserRequestDto = new CreateUserRequestDto();
                createUserRequestDto.username = username;
                createUserRequestDto.password = password;

                // Вызов метода регистрации
                Call<CreateUserResponseDto> call = api.getApi().createUser(createUserRequestDto);
                call.enqueue(new Callback<CreateUserResponseDto>() {
                    @Override
                    public void onResponse(Call<CreateUserResponseDto> call, Response<CreateUserResponseDto> response) {
                        if (response.isSuccessful()) {
                            // Регистрация успешна
                            CreateUserResponseDto createUserResponseDto = response.body();
                            String userId = createUserResponseDto.id;

                            Toast.makeText(ThirdActivity.this, "Регистрация успешна. ID пользователя: " + userId, Toast.LENGTH_SHORT).show();
                            Log.d("ThirdActivity", "Нажата кнопка регистрации");

                            // Create an Intent to start the new activity
                            Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);

                            // Pass data to the new activity if needed
                            intent.putExtra("userId", userId);

                            // Start the new activity
                            startActivity(intent);

                            // Finish the current activity if you want
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<CreateUserResponseDto> call, Throwable t) {
                        // Ошибка сети или другая ошибка
                        Log.e("ThirdActivity", "Ошибка при выполнении запроса", t);
                        Toast.makeText(ThirdActivity.this, "Ошибка при выполнении запроса", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}