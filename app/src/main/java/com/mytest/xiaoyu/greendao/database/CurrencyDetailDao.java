package com.mytest.xiaoyu.greendao.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CURRENCY_DETAIL".
*/
public class CurrencyDetailDao extends AbstractDao<CurrencyDetail, Long> {

    public static final String TABLENAME = "CURRENCY_DETAIL";

    /**
     * Properties of entity CurrencyDetail.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Symbol = new Property(1, String.class, "symbol", false, "SYMBOL");
        public final static Property Change = new Property(2, String.class, "change", false, "CHANGE");
        public final static Property Sell = new Property(3, String.class, "sell", false, "SELL");
        public final static Property Buy = new Property(4, String.class, "buy", false, "BUY");
    }


    public CurrencyDetailDao(DaoConfig config) {
        super(config);
    }
    
    public CurrencyDetailDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CURRENCY_DETAIL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"SYMBOL\" TEXT," + // 1: symbol
                "\"CHANGE\" TEXT," + // 2: change
                "\"SELL\" TEXT," + // 3: sell
                "\"BUY\" TEXT);"); // 4: buy
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CURRENCY_DETAIL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CurrencyDetail entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String symbol = entity.getSymbol();
        if (symbol != null) {
            stmt.bindString(2, symbol);
        }
 
        String change = entity.getChange();
        if (change != null) {
            stmt.bindString(3, change);
        }
 
        String sell = entity.getSell();
        if (sell != null) {
            stmt.bindString(4, sell);
        }
 
        String buy = entity.getBuy();
        if (buy != null) {
            stmt.bindString(5, buy);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CurrencyDetail entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String symbol = entity.getSymbol();
        if (symbol != null) {
            stmt.bindString(2, symbol);
        }
 
        String change = entity.getChange();
        if (change != null) {
            stmt.bindString(3, change);
        }
 
        String sell = entity.getSell();
        if (sell != null) {
            stmt.bindString(4, sell);
        }
 
        String buy = entity.getBuy();
        if (buy != null) {
            stmt.bindString(5, buy);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public CurrencyDetail readEntity(Cursor cursor, int offset) {
        CurrencyDetail entity = new CurrencyDetail( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // symbol
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // change
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sell
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // buy
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CurrencyDetail entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSymbol(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setChange(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSell(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBuy(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CurrencyDetail entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CurrencyDetail entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CurrencyDetail entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
