package com.hanna.makeup4you;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hanna.makeup4you.DB.AppDataBase;
import com.hanna.makeup4you.DB.LoginEntityClass;
import com.hanna.makeup4you.databinding.ActivitySplashBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivitySplashBinding binding;
    AppDataBase appDataBase;
    List<LoginEntityClass> mLoginActivityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        appDataBase = AppDataBase.getInstance(getApplicationContext());
        mLoginActivityList = appDataBase.loginActivityDAO().getUsers();


        binding.btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });

        if (mLoginActivityList.isEmpty()){
            LoginEntityClass loginEntityClass1 = new LoginEntityClass("testuser1", "testuser1");
            appDataBase.loginActivityDAO().insert(loginEntityClass1);
            LoginEntityClass loginEntityClass2 = new LoginEntityClass("admin2", "admin2");
            appDataBase.loginActivityDAO().insert(loginEntityClass2);
        }

    }
}