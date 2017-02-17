package com.almeida.search.di;

import com.almeida.search.MainActivity;

import dagger.Component;

/**
 * Created by jalmei14 on 2/17/17.
 */

@Component ( dependencies = RetrofitComponent.class )
public interface ApplicationComponents {

    void inject(MainActivity mainActivity);

}
