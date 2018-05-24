package com.example.irfan.layouting;

import android.app.Application;

import com.example.irfan.layouting.data.database.DaoMaster;
import com.example.irfan.layouting.data.database.DaoSession;
import com.facebook.stetho.Stetho;

public class MainApp extends Application {
    private DaoSession daoSession; // <--- belum ada, auto generated

    @Override
    public void onCreate() {
        super.onCreate();

        daoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(this, "nama_database.db").getWritableDb()
        ).newSession();

        Stetho.initializeWithDefaults(this);
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
