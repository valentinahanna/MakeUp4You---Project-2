package com.hanna.makeup4you.DB;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDataBase_Impl extends AppDataBase {
  private volatile LoginActivityDAO _loginActivityDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `login_table` (`mLoginId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mUsername` TEXT, `mPassword` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `products_table` (`mProductId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mProductName` TEXT, `mProductPrice` TEXT, `mProductPicture` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `cart_table` (`mProductId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mProductName` TEXT, `mProductPrice` TEXT, `mProductPicture` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '22f77229a211363ffced860e5799ae05')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `login_table`");
        _db.execSQL("DROP TABLE IF EXISTS `products_table`");
        _db.execSQL("DROP TABLE IF EXISTS `cart_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsLoginTable = new HashMap<String, TableInfo.Column>(3);
        _columnsLoginTable.put("mLoginId", new TableInfo.Column("mLoginId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoginTable.put("mUsername", new TableInfo.Column("mUsername", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoginTable.put("mPassword", new TableInfo.Column("mPassword", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLoginTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLoginTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLoginTable = new TableInfo("login_table", _columnsLoginTable, _foreignKeysLoginTable, _indicesLoginTable);
        final TableInfo _existingLoginTable = TableInfo.read(_db, "login_table");
        if (! _infoLoginTable.equals(_existingLoginTable)) {
          return new RoomOpenHelper.ValidationResult(false, "login_table(com.hanna.makeup4you.DB.LoginEntityClass).\n"
                  + " Expected:\n" + _infoLoginTable + "\n"
                  + " Found:\n" + _existingLoginTable);
        }
        final HashMap<String, TableInfo.Column> _columnsProductsTable = new HashMap<String, TableInfo.Column>(4);
        _columnsProductsTable.put("mProductId", new TableInfo.Column("mProductId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductsTable.put("mProductName", new TableInfo.Column("mProductName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductsTable.put("mProductPrice", new TableInfo.Column("mProductPrice", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductsTable.put("mProductPicture", new TableInfo.Column("mProductPicture", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProductsTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProductsTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProductsTable = new TableInfo("products_table", _columnsProductsTable, _foreignKeysProductsTable, _indicesProductsTable);
        final TableInfo _existingProductsTable = TableInfo.read(_db, "products_table");
        if (! _infoProductsTable.equals(_existingProductsTable)) {
          return new RoomOpenHelper.ValidationResult(false, "products_table(com.hanna.makeup4you.DB.ProductsEntityClass).\n"
                  + " Expected:\n" + _infoProductsTable + "\n"
                  + " Found:\n" + _existingProductsTable);
        }
        final HashMap<String, TableInfo.Column> _columnsCartTable = new HashMap<String, TableInfo.Column>(4);
        _columnsCartTable.put("mProductId", new TableInfo.Column("mProductId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartTable.put("mProductName", new TableInfo.Column("mProductName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartTable.put("mProductPrice", new TableInfo.Column("mProductPrice", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartTable.put("mProductPicture", new TableInfo.Column("mProductPicture", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCartTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCartTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCartTable = new TableInfo("cart_table", _columnsCartTable, _foreignKeysCartTable, _indicesCartTable);
        final TableInfo _existingCartTable = TableInfo.read(_db, "cart_table");
        if (! _infoCartTable.equals(_existingCartTable)) {
          return new RoomOpenHelper.ValidationResult(false, "cart_table(com.hanna.makeup4you.DB.CartEntityClass).\n"
                  + " Expected:\n" + _infoCartTable + "\n"
                  + " Found:\n" + _existingCartTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "22f77229a211363ffced860e5799ae05", "2b927b02ee98db00ab99ef8dbea5173d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "login_table","products_table","cart_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `login_table`");
      _db.execSQL("DELETE FROM `products_table`");
      _db.execSQL("DELETE FROM `cart_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(LoginActivityDAO.class, LoginActivityDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public LoginActivityDAO loginActivityDAO() {
    if (_loginActivityDAO != null) {
      return _loginActivityDAO;
    } else {
      synchronized(this) {
        if(_loginActivityDAO == null) {
          _loginActivityDAO = new LoginActivityDAO_Impl(this);
        }
        return _loginActivityDAO;
      }
    }
  }
}
