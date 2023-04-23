package com.hanna.makeup4you.DB;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LoginActivityDAO_Impl implements LoginActivityDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LoginEntityClass> __insertionAdapterOfLoginEntityClass;

  private final EntityInsertionAdapter<ProductsEntityClass> __insertionAdapterOfProductsEntityClass;

  private final EntityInsertionAdapter<CartEntityClass> __insertionAdapterOfCartEntityClass;

  private final EntityDeletionOrUpdateAdapter<LoginEntityClass> __deletionAdapterOfLoginEntityClass;

  private final EntityDeletionOrUpdateAdapter<ProductsEntityClass> __deletionAdapterOfProductsEntityClass;

  private final EntityDeletionOrUpdateAdapter<CartEntityClass> __deletionAdapterOfCartEntityClass;

  private final EntityDeletionOrUpdateAdapter<LoginEntityClass> __updateAdapterOfLoginEntityClass;

  private final EntityDeletionOrUpdateAdapter<ProductsEntityClass> __updateAdapterOfProductsEntityClass;

  private final EntityDeletionOrUpdateAdapter<CartEntityClass> __updateAdapterOfCartEntityClass;

  public LoginActivityDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLoginEntityClass = new EntityInsertionAdapter<LoginEntityClass>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `login_table` (`mLoginId`,`mUsername`,`mPassword`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LoginEntityClass value) {
        stmt.bindLong(1, value.mLoginId);
        if (value.mUsername == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.mUsername);
        }
        if (value.mPassword == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.mPassword);
        }
      }
    };
    this.__insertionAdapterOfProductsEntityClass = new EntityInsertionAdapter<ProductsEntityClass>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `products_table` (`mProductId`,`mProductName`,`mProductPrice`,`mProductPicture`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductsEntityClass value) {
        stmt.bindLong(1, value.mProductId);
        if (value.mProductName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.mProductName);
        }
        if (value.mProductPrice == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.mProductPrice);
        }
        if (value.mProductPicture == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.mProductPicture);
        }
      }
    };
    this.__insertionAdapterOfCartEntityClass = new EntityInsertionAdapter<CartEntityClass>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `cart_table` (`mProductId`,`mProductName`,`mProductPrice`,`mProductPicture`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CartEntityClass value) {
        stmt.bindLong(1, value.mProductId);
        if (value.mProductName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.mProductName);
        }
        if (value.mProductPrice == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.mProductPrice);
        }
        if (value.mProductPicture == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.mProductPicture);
        }
      }
    };
    this.__deletionAdapterOfLoginEntityClass = new EntityDeletionOrUpdateAdapter<LoginEntityClass>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `login_table` WHERE `mLoginId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LoginEntityClass value) {
        stmt.bindLong(1, value.mLoginId);
      }
    };
    this.__deletionAdapterOfProductsEntityClass = new EntityDeletionOrUpdateAdapter<ProductsEntityClass>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `products_table` WHERE `mProductId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductsEntityClass value) {
        stmt.bindLong(1, value.mProductId);
      }
    };
    this.__deletionAdapterOfCartEntityClass = new EntityDeletionOrUpdateAdapter<CartEntityClass>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `cart_table` WHERE `mProductId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CartEntityClass value) {
        stmt.bindLong(1, value.mProductId);
      }
    };
    this.__updateAdapterOfLoginEntityClass = new EntityDeletionOrUpdateAdapter<LoginEntityClass>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `login_table` SET `mLoginId` = ?,`mUsername` = ?,`mPassword` = ? WHERE `mLoginId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LoginEntityClass value) {
        stmt.bindLong(1, value.mLoginId);
        if (value.mUsername == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.mUsername);
        }
        if (value.mPassword == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.mPassword);
        }
        stmt.bindLong(4, value.mLoginId);
      }
    };
    this.__updateAdapterOfProductsEntityClass = new EntityDeletionOrUpdateAdapter<ProductsEntityClass>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `products_table` SET `mProductId` = ?,`mProductName` = ?,`mProductPrice` = ?,`mProductPicture` = ? WHERE `mProductId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductsEntityClass value) {
        stmt.bindLong(1, value.mProductId);
        if (value.mProductName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.mProductName);
        }
        if (value.mProductPrice == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.mProductPrice);
        }
        if (value.mProductPicture == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.mProductPicture);
        }
        stmt.bindLong(5, value.mProductId);
      }
    };
    this.__updateAdapterOfCartEntityClass = new EntityDeletionOrUpdateAdapter<CartEntityClass>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `cart_table` SET `mProductId` = ?,`mProductName` = ?,`mProductPrice` = ?,`mProductPicture` = ? WHERE `mProductId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CartEntityClass value) {
        stmt.bindLong(1, value.mProductId);
        if (value.mProductName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.mProductName);
        }
        if (value.mProductPrice == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.mProductPrice);
        }
        if (value.mProductPicture == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.mProductPicture);
        }
        stmt.bindLong(5, value.mProductId);
      }
    };
  }

  @Override
  public void insert(final LoginEntityClass loginEntityClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLoginEntityClass.insert(loginEntityClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addProduct(final ProductsEntityClass productsEntityClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProductsEntityClass.insert(productsEntityClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addCart(final CartEntityClass cartEntityClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCartEntityClass.insert(cartEntityClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final LoginEntityClass loginEntityClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfLoginEntityClass.handle(loginEntityClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteProduct(final ProductsEntityClass productsEntityClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProductsEntityClass.handle(productsEntityClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCart(final CartEntityClass cartEntityClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCartEntityClass.handle(cartEntityClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final LoginEntityClass loginEntityClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfLoginEntityClass.handle(loginEntityClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateProduct(final ProductsEntityClass productsEntityClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfProductsEntityClass.handle(productsEntityClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCart(final CartEntityClass cartEntityClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCartEntityClass.handle(cartEntityClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<LoginEntityClass> getUsers() {
    final String _sql = "SELECT * FROM login_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMLoginId = CursorUtil.getColumnIndexOrThrow(_cursor, "mLoginId");
      final int _cursorIndexOfMUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "mUsername");
      final int _cursorIndexOfMPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "mPassword");
      final List<LoginEntityClass> _result = new ArrayList<LoginEntityClass>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LoginEntityClass _item;
        final String _tmpMUsername;
        if (_cursor.isNull(_cursorIndexOfMUsername)) {
          _tmpMUsername = null;
        } else {
          _tmpMUsername = _cursor.getString(_cursorIndexOfMUsername);
        }
        final String _tmpMPassword;
        if (_cursor.isNull(_cursorIndexOfMPassword)) {
          _tmpMPassword = null;
        } else {
          _tmpMPassword = _cursor.getString(_cursorIndexOfMPassword);
        }
        _item = new LoginEntityClass(_tmpMUsername,_tmpMPassword);
        _item.mLoginId = _cursor.getInt(_cursorIndexOfMLoginId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ProductsEntityClass> getAllProducts() {
    final String _sql = "SELECT * FROM products_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "mProductId");
      final int _cursorIndexOfMProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "mProductName");
      final int _cursorIndexOfMProductPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "mProductPrice");
      final int _cursorIndexOfMProductPicture = CursorUtil.getColumnIndexOrThrow(_cursor, "mProductPicture");
      final List<ProductsEntityClass> _result = new ArrayList<ProductsEntityClass>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ProductsEntityClass _item;
        _item = new ProductsEntityClass();
        _item.mProductId = _cursor.getInt(_cursorIndexOfMProductId);
        if (_cursor.isNull(_cursorIndexOfMProductName)) {
          _item.mProductName = null;
        } else {
          _item.mProductName = _cursor.getString(_cursorIndexOfMProductName);
        }
        if (_cursor.isNull(_cursorIndexOfMProductPrice)) {
          _item.mProductPrice = null;
        } else {
          _item.mProductPrice = _cursor.getString(_cursorIndexOfMProductPrice);
        }
        if (_cursor.isNull(_cursorIndexOfMProductPicture)) {
          _item.mProductPicture = null;
        } else {
          _item.mProductPicture = _cursor.getString(_cursorIndexOfMProductPicture);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<CartEntityClass> getAllCartProducts() {
    final String _sql = "SELECT * FROM cart_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "mProductId");
      final int _cursorIndexOfMProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "mProductName");
      final int _cursorIndexOfMProductPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "mProductPrice");
      final int _cursorIndexOfMProductPicture = CursorUtil.getColumnIndexOrThrow(_cursor, "mProductPicture");
      final List<CartEntityClass> _result = new ArrayList<CartEntityClass>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CartEntityClass _item;
        _item = new CartEntityClass();
        _item.mProductId = _cursor.getInt(_cursorIndexOfMProductId);
        if (_cursor.isNull(_cursorIndexOfMProductName)) {
          _item.mProductName = null;
        } else {
          _item.mProductName = _cursor.getString(_cursorIndexOfMProductName);
        }
        if (_cursor.isNull(_cursorIndexOfMProductPrice)) {
          _item.mProductPrice = null;
        } else {
          _item.mProductPrice = _cursor.getString(_cursorIndexOfMProductPrice);
        }
        if (_cursor.isNull(_cursorIndexOfMProductPicture)) {
          _item.mProductPicture = null;
        } else {
          _item.mProductPicture = _cursor.getString(_cursorIndexOfMProductPicture);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
