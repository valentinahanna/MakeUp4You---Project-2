package com.hanna.makeup4you;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hanna.makeup4you.DB.AppDataBase;
import com.hanna.makeup4you.DB.ProductsEntityClass;
import com.hanna.makeup4you.databinding.ActivityAddProductsBinding;
import com.hanna.makeup4you.databinding.ActivityLandingBinding;

public class AddProductsActivity extends AppCompatActivity {

    ActivityAddProductsBinding binding;
    AppDataBase appDataBase;
    int PICK_IMAGE_GALLERY = 123;
    String imageUri = "";
    String name, price;
    ProductsEntityClass model;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        appDataBase = AppDataBase.getInstance(getApplicationContext());

        //Checking if arguments are not empty then getting the data from adapter to show in fields for edit
        if (getIntent().getExtras() != null) {
            model = (ProductsEntityClass) getIntent().getSerializableExtra("data");
        }

        //Checking if model is not empty then setting the data into fileds
        if (model != null) {
            Glide.with(binding.ivImage).load(model.getmProductPicture()).into(binding.ivImage);
            binding.etProductName.setText(model.getmProductName());
            binding.etPrice.setText(model.getmProductPrice());
            imageUri = model.getmProductPicture();
            binding.btnAdd.setText("Update Product");
            binding.rlGone.setVisibility(View.GONE);
        }

        //Clicking to pick the image from the gallery
        binding.rlAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto, PICK_IMAGE_GALLERY);
            }
        });

        //Clicking on Add Product button
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAddMethod();
            }
        });

    }

    private void callAddMethod(){

        //Getting fields data into string variables
        name = binding.etProductName.getText().toString();
        price = binding.etPrice.getText().toString();

        //Checking if any of the field is empty then showing the toast message
        if (imageUri.isEmpty()){
            showToast("Please pick image");
        }else if (name.isEmpty()){
            showToast("Please enter product name");
        }else if (price.isEmpty()){
            showToast("Please enter product price");
        }else{
            //Creating variable of entity class and setting values
            ProductsEntityClass entityClass = new ProductsEntityClass();
            entityClass.setmProductPicture(imageUri);
            entityClass.setmProductName(name);
            entityClass.setmProductPrice(price);
            //Checking if model is not empty then we also have to set id and have to call the update method
            if (model != null) {
                entityClass.setmProductId(model.getmProductId());
                appDataBase.loginActivityDAO().updateProduct(entityClass);
                showToast("Successfully Updated");
            }else{
                //Checking if model is empty then have to call the insert method
                appDataBase.loginActivityDAO().addProduct(entityClass);
                showToast("Successfully Added");
            }
            startActivity(new Intent(AddProductsActivity.this, LandingActivity.class));
            finish();

        }

    }

    //Getting result and showing the image
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            if (data.getData()!=null){
                imageUri= String.valueOf(data.getData());
                Glide.with(binding.ivImage).load(imageUri).centerCrop().into(binding.ivImage);
                binding.rlGone.setVisibility(View.GONE);
            }
        }
    }

    //show Toast Message
    private void showToast(String message){
        Toast.makeText(AddProductsActivity.this, message, Toast.LENGTH_SHORT).show();
    }


}