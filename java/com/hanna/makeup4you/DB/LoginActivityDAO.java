package com.hanna.makeup4you.DB;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LoginActivityDAO {

    @Insert
    void insert(LoginEntityClass loginEntityClass);

    @Update
    void update(LoginEntityClass loginEntityClass);

    @Delete
    void delete(LoginEntityClass loginEntityClass);

    @Query("SELECT * FROM " + AppDataBase.LOGIN_TABLE)
    List<LoginEntityClass> getUsers();

    @Insert
    void addProduct(ProductsEntityClass productsEntityClass);

    @Update
    void updateProduct(ProductsEntityClass productsEntityClass);

    @Delete
    void deleteProduct(ProductsEntityClass productsEntityClass);

    @Query("SELECT * FROM " + AppDataBase.PRODUCTS_TABLE)
    List<ProductsEntityClass> getAllProducts();

    @Insert
    void addCart(CartEntityClass cartEntityClass);

    @Update
    void updateCart(CartEntityClass cartEntityClass);

    @Delete
    void deleteCart(CartEntityClass cartEntityClass);

    @Query("SELECT * FROM " + AppDataBase.CART_TABLE)
    List<CartEntityClass> getAllCartProducts();

}
