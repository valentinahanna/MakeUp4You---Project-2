package com.hanna.makeup4you.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {LoginEntityClass.class, ProductsEntityClass.class, CartEntityClass.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public static final String DATABASE_NAME = "makeUpProducts.db";
    public static final String LOGIN_TABLE = "login_table";
    public static final String PRODUCTS_TABLE = "products_table";
    public static final String CART_TABLE = "cart_table";

    private static AppDataBase instance;
    public abstract LoginActivityDAO loginActivityDAO();

    public static AppDataBase getInstance(Context context) {
        if(instance == null) {
            synchronized (AppDataBase.class) {
                if (instance == null) {
                    instance= Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class,
                            DATABASE_NAME).allowMainThreadQueries().build();
                }
            }
        }
        return instance;
    }

}
