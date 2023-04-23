package com.hanna.makeup4you;

import static com.hanna.makeup4you.LoginActivity.isAdmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.hanna.makeup4you.DB.AppDataBase;
import com.hanna.makeup4you.DB.Helper;
import com.hanna.makeup4you.DB.ProductsEntityClass;
import com.hanna.makeup4you.adapter.ProductsAdapter;
import com.hanna.makeup4you.databinding.ActivityLandingBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LandingActivity extends AppCompatActivity {

    ActivityLandingBinding binding;
    AppDataBase appDataBase;
    ProductsAdapter adapter;
    List<ProductsEntityClass> mProductsList;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLandingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (isAdmin == true){
            binding.fab.setVisibility(View.VISIBLE);
            binding.fabCart.setVisibility(View.GONE);
            binding.tvName.setVisibility(View.GONE);
        }else{
            binding.tvName.setText("Welcome "+Helper.users.getmUsername()+"!");
            binding.fab.setVisibility(View.GONE);
            binding.fabCart.setVisibility(View.VISIBLE);
            binding.tvName.setVisibility(View.VISIBLE);
        }

        //Initializing the Database Class
        appDataBase = AppDataBase.getInstance(getApplicationContext());
        //Getting data from database and adding to list
        mProductsList = appDataBase.loginActivityDAO().getAllProducts();
        //setting adapter on recycler view
        adapter = new ProductsAdapter(mProductsList, this);
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search(newText);
                return false;
            }
        });
        binding.rvItems.setLayoutManager(new LinearLayoutManager(this));
        binding.rvItems.setAdapter(adapter);

        //If list is empty then show the user no product found
        if (mProductsList.isEmpty()){
            binding.tvNoDataFound.setVisibility(View.VISIBLE);
            binding.rvItems.setVisibility(View.GONE);
        }else{
            binding.tvNoDataFound.setVisibility(View.GONE);
            binding.rvItems.setVisibility(View.VISIBLE);
        }

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, AddProductsActivity.class));
            }
        });

        binding.fabCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, CartActivity.class));
            }
        });

        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, LoginActivity.class));
                finish();
            }
        });

    }

    public void search(String query) {
        List<ProductsEntityClass> queriedList = new ArrayList<>();
        for (ProductsEntityClass model : mProductsList) {
            if (model.getmProductName().toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT))) {
                queriedList.add(model);
            }
        }
        adapter.setList(queriedList);

    }

}