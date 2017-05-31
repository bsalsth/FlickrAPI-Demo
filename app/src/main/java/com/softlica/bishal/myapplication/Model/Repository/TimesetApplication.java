package com.softlica.bishal.myapplication.Model.Repository;

import android.app.Application;

/**
 * Created by bishal on 2/10/2017.
 */

public class TimesetApplication extends Application {
    private static TimesetApplication uniqInstance;

    public  TimesetApplication() {
        uniqInstance = this;
    }

    public static TimesetApplication getInstance() {
        if (uniqInstance == null) {
            synchronized(TimesetApplication.class) {
                if (uniqInstance == null)
                    uniqInstance = new TimesetApplication();
            }
        }
        return uniqInstance;
    }
}
