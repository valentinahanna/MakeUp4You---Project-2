package com.hanna.makeup4you.adapter;

import static com.hanna.makeup4you.LoginActivity.isAdmin;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hanna.makeup4you.AddProductsActivity;
import com.hanna.makeup4you.DB.AppDataBase;
import com.hanna.makeup4you.DB.CartEntityClass;
import com.hanna.makeup4you.DB.ProductsEntityClass;
import com.hanna.makeup4you.R;
import com.hanna.makeup4you.databinding.ListProductsBinding;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.Vh> {
    private List<ProductsEntityClass> list;
    private Context context;

    public ProductsAdapter(List<ProductsEntityClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(List<ProductsEntityClass> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListProductsBinding binding = ListProductsBinding.inflate(LayoutInflater.from(context), parent, false);
        return new Vh(binding.getRoot());
    }

    @SuppressLint({"SimpleDateFormat", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull Vh holder, @SuppressLint("RecyclerView") int position) {

        if (isAdmin == true){
            holder.binding.ivEdit.setVisibility(View.VISIBLE);
            holder.binding.ivDelete.setVisibility(View.VISIBLE);
            holder.binding.btnCart.setVisibility(View.GONE);
        }else{
            holder.binding.ivEdit.setVisibility(View.GONE);
            holder.binding.ivDelete.setVisibility(View.GONE);
            holder.binding.btnCart.setVisibility(View.VISIBLE);
        }

        ProductsEntityClass productModel = list.get(position);
        holder.binding.tvName.setText(productModel.getmProductName());
        holder.binding.tvPrice.setText("Price: "+productModel.getmProductPrice()+"$");
        Glide.with(context).load(productModel.getmProductPicture()).into(holder.binding.ivImage);

        holder.binding.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddProductsActivity.class);
                intent.putExtra("data", list.get(position));
                context.startActivity(intent);

            }
        });

        holder.binding.btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartEntityClass cartEntityClass = new CartEntityClass();
                cartEntityClass.setmProductName(productModel.getmProductName());
                cartEntityClass.setmProductPrice(productModel.getmProductPrice());
                cartEntityClass.setmProductPicture(productModel.getmProductPicture());
                AppDataBase.getInstance(context).loginActivityDAO().addCart(cartEntityClass);
                Toast.makeText(context, "Successfully Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });

        //Clicking on Delete Button
        holder.binding.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating the Alert Dialog
                AlertDialog.Builder alert = new AlertDialog.Builder(v.getRootView().getContext());
                alert.setTitle("MakeUp4You");
                alert.setMessage("Are you sure want to Delete this Product?");
                alert.setIcon(R.drawable.ic_baseline_delete_24);
                alert.setCancelable(false);

                alert.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //If delete button is pressed then we have to delete the item with specific id
                        ProductsEntityClass entityClass = new ProductsEntityClass();
                        int ID = list.get(position).getmProductId();
                        entityClass.setmProductId(ID);
                        AppDataBase.getInstance(context).loginActivityDAO().deleteProduct(entityClass);
                        list.remove(position);
                        notifyItemRemoved(position);
                        Toast.makeText(context, "Product Deleted Successfully", Toast.LENGTH_SHORT).show();
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
