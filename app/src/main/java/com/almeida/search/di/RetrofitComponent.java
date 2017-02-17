package com.almeida.search.di;

import com.almeida.search.network.Service;

import dagger.Component;

/**
 * Created by jalmei14 on 2/17/17.
 */

@Component ( modules = RetrofitModule.class )
public interface RetrofitComponent {

    Service service();

}
