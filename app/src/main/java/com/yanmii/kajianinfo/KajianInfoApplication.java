package com.yanmii.kajianinfo;


import android.app.Application;

public class KajianInfoApplication extends Application{


    @Override
    public void onCreate() {
        super.onCreate();

        /** initialise database config*/
       /* Configuration dbConfiguration = new Configuration.Builder(this).setDatabaseName("kajianinfoapp.db").
                setDatabaseVersion(1).create();

        ActiveAndroid.initialize(dbConfiguration);*/
        //ActiveAndroid.initialize(this);
    }
}
