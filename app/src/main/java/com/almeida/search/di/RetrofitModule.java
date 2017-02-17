package com.almeida.search.di;

import com.almeida.search.network.Service;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by jalmei14 on 2/17/17.
 */

@Module
public class RetrofitModule {

    public static final String BASE_URL = "https://api.github.com";

    @Provides
    Service providesService(){

        Gson gson = new Gson();
        GsonConverterFactory.create(gson);

        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory
                .createWithScheduler(Schedulers.io());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxAdapter)
                .client(new OkHttpClient())
                .build();

        return retrofit.create(Service.class);

    }
}
