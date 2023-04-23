package com.hanna.makeup4you.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hanna.makeup4you.DB.AppDataBase;
import com.hanna.makeup4you.DB.CartEntityClass;
import com.hanna.makeup4you.DB.ProductsEntityClass;
import com.hanna.makeup4you.R;
import com.hanna.makeup4you.databinding.ListProductsBinding;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Vh> {
    private List<CartEntityClass> list;
    private Context context;

    public CartAdapter(List<CartEntityClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListProductsBinding binding = ListProductsBinding.inflate(LayoutInflater.from(context), parent, false);
        return new Vh(binding.getRoot());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh holder, @SuppressLint("RecyclerView") int position) {
        CartEntityClass productModel = list.get(position);
        holder.binding.tvName.setText(productModel.getmProductName());
        holder.binding.tvPrice.setText("Price: "+productModel.getmProductPrice()+"$");
        Glide.with(context).load(productModel.getmProductPicture()).into(holder.binding.ivImage);

        //Clicking on Delete Button
        holder.binding.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating the Alert Dialog
                AlertDialog.Builder alert = new AlertDialog.Builder(v.getRootView().getContext());
                alert.setTitle("MakeUp4You");
                alert.setMessage("Are you sure want to Remove this Product?");
                alert.setIcon(R.drawable.ic_baseline_delete_24);
                alert.setCancelable(false);

                alert.setPositiveButton("Remove", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //If delete button is pressed then we have to delete the item with specific id
                        CartEntityClass entityClass = new CartEntityClass();
                        int ID = list.get(position).getmProductId();
                        entityClass.setmProductId(ID);
                        AppDataBase.getInstance(context).loginActivityDAO().deleteCart(entityClass);
                        list.remove(position);
                        notifyItemRemoved(position);
                        Toast.makeText(context, "Product Removed Successfully", Toast.LENGTH_SHORT).show();
                    }
                });
                //if cancel button is clicked then have to dismiss dialog
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Don't Worry, Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class Vh extends RecyclerView.ViewHolder {
        ListProductsBinding binding;

        public Vh(@NonNull View itemView) {
            super(itemView);
            binding = ListProductsBinding.bind(itemView);
        }
    }
}
