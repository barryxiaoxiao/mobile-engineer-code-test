package com.mytest.xiaoyu.greendao.database;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.mytest.xiaoyu.greendao.database.CurrencyDetail;

import com.mytest.xiaoyu.greendao.database.CurrencyDetailDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig currencyDetailDaoConfig;

    private final CurrencyDetailDao currencyDetailDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        currencyDetailDaoConfig = daoConfigMap.get(CurrencyDetailDao.class).clone();
        currencyDetailDaoConfig.initIdentityScope(type);

        currencyDetailDao = new CurrencyDetailDao(currencyDetailDaoConfig, this);

        registerDao(CurrencyDetail.class, currencyDetailDao);
    }
    
    public void clear() {
        currencyDetailDaoConfig.clearIdentityScope();
    }

    public CurrencyDetailDao getCurrencyDetailDao() {
        return currencyDetailDao;
    }

}
