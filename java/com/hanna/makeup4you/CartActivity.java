package com.hanna.makeup4you;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.hanna.makeup4you.DB.AppDataBase;
import com.hanna.makeup4you.DB.CartEntityClass;
import com.hanna.makeup4you.DB.ProductsEntityClass;
import com.hanna.makeup4you.adapter.CartAdapter;
import com.hanna.makeup4you.adapter.ProductsAdapter;
import com.hanna.makeup4you.databinding.ActivityCartBinding;
import com.hanna.makeup4you.databinding.ActivityLandingBinding;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    ActivityCartBinding binding;
    AppDataBase appDataBase;
    CartAdapter adapter;
    List<CartEntityClass> mCartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Initializing the Database Class
        appDataBase = AppDataBase.getInstance(getApplicationContext());
        //Getting data from database and adding to list
        mCartList = appDataBase.loginActivityDAO().getAllCartProducts();
        //setting adapter on recycler view
        adapter = new CartAdapter(mCartList, this);
        binding.rvItems.setLayoutManager(new LinearLayoutManager(this));
        binding.rvItems.setAdapter(adapter);

        //If list is empty then show the user no product found
        if (mCartList.isEmpty()){
            binding.tvNoDataFound.setVisibility(View.VISIBLE);
            binding.rvItems.setVisibility(View.GONE);
        }else{
            binding.tvNoDataFound.setVisibility(View.GONE);
            binding.rvItems.setVisibility(View.VISIBLE);
        }

    }
}