package com.almeida.search;

import android.app.Application;

import com.almeida.search.di.ApplicationComponents;
import com.almeida.search.di.DaggerApplicationComponents;
import com.almeida.search.di.DaggerRetrofitComponent;
import com.almeida.search.di.RetrofitComponent;
import com.almeida.search.di.RetrofitModule;

/**
 * Created by jalmei14 on 2/17/17.
 */

public class MyApplication extends Application {

    private static ApplicationComponents applicationComponents;

    @Override
    public void onCreate() {
        super.onCreate();

        RetrofitComponent retrofitComponent = DaggerRetrofitComponent.builder()
                .retrofitModule(new RetrofitModule())
                .build();

        applicationComponents = DaggerApplicationComponents.builder()
                .retrofitComponent(retrofitComponent)
                .build();


    }

    public static ApplicationComponents getApplicationComponents() {
        return applicationComponents;
    }
}
