package com.hanna.makeup4you.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = AppDataBase.LOGIN_TABLE)
public class LoginEntityClass {

    @PrimaryKey(autoGenerate = true)
    public int mLoginId;

    @ColumnInfo(name = "mUsername")
    String mUsername;
    @ColumnInfo(name = "mPassword")
    String mPassword;

    public int getmLoginId() {
        return mLoginId;
    }

    public void setmLoginId(int mLoginId) {
        this.mLoginId = mLoginId;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public LoginEntityClass(String mUsername, String mPassword) {
        this.mUsername = mUsername;
        this.mPassword = mPassword;
    }
}
