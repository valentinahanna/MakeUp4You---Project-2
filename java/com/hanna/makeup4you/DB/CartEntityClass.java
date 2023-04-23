package com.hanna.makeup4you.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = AppDataBase.CART_TABLE)
public class CartEntityClass {

    @PrimaryKey(autoGenerate = true)
    int mProductId;

    @ColumnInfo(name = "mProductName")
    String mProductName;
    @ColumnInfo(name = "mProductPrice")
    String mProductPrice;
    @ColumnInfo(name = "mProductPicture")
    String mProductPicture;

    public int getmProductId() {
        return mProductId;
    }

    public void setmProductId(int mProductId) {
        this.mProductId = mProductId;
    }

    public String getmProductName() {
        return mProductName;
    }

    public void setmProductName(String mProductName) {
        this.mProductName = mProductName;
    }

    public String getmProductPrice() {
        return mProductPrice;
    }

    public void setmProductPrice(String mProductPrice) {
        this.mProductPrice = mProductPrice;
    }

    public String getmProductPicture() {
        return mProductPicture;
    }

    public void setmProductPicture(String mProductPicture) {
        this.mProductPicture = mProductPicture;
    }

}
