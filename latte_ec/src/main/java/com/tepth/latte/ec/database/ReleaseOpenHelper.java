package com.tepth.latte.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Description:数据库的SqLitOpenHelper
 *
 * @author Hequn.Lee
 * @date 2018/10/19
 */
public class ReleaseOpenHelper extends DaoMaster.OpenHelper {
    ReleaseOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }
}
