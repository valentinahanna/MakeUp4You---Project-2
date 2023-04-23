package com.hanna.makeup4you;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanna.makeup4you.DB.AppDataBase;
import com.hanna.makeup4you.DB.Helper;
import com.hanna.makeup4you.DB.LoginEntityClass;
import com.hanna.makeup4you.databinding.ActivityMainBinding;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    TextView mMainDisplay;
    EditText mUsername;
    EditText mPassword;
    Button mSignIn;
    AppDataBase appDataBase;
    List<LoginEntityClass> mLoginActivityList;
    public static Boolean isAdmin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mMainDisplay = binding.makeup4youLabelTextview;
        mUsername = binding.usernameInputEdittext;
        mPassword = binding.passwordInputEdittext;
        mSignIn = binding.signinConvertButtom;

        appDataBase = AppDataBase.getInstance(getApplicationContext());
        mLoginActivityList = appDataBase.loginActivityDAO().getUsers();


        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInLoginActivity();
            }
        });
    }

    private void signInLoginActivity() {
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        if (username.isEmpty()){
            Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show();
        }else if (password.isEmpty()){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
        }else{
            Boolean flag = false;
            for (LoginEntityClass users : mLoginActivityList) {
                Helper.users = users;
                if (username.equals(users.getmUsername()) && password.equals(users.getmPassword())) {
                    flag = true;
                    if (username.equals("testuser1") && password.equals("testuser1")){
                        isAdmin = false;
                    }else{
                        isAdmin = true;
                    }
                    Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, LandingActivity.class));
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                Toast.makeText(LoginActivity.this, "Error check username or password", Toast.LENGTH_SHORT).show();
            }

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mLoginActivityList.isEmpty()){
            LoginEntityClass loginEntityClass1 = new LoginEntityClass("testuser1", "testuser1");
            appDataBase.loginActivityDAO().insert(loginEntityClass1);
            LoginEntityClass loginEntityClass2 = new LoginEntityClass("admin2", "admin2");
            appDataBase.loginActivityDAO().insert(loginEntityClass2);
        }
    }
}