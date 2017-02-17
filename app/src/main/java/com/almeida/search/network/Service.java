package com.almeida.search.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jalmei14 on 2/17/17.
 */

public interface Service {

    @GET("users/{username}")
    Observable<String> fetchUser(@Path("username") String userName);

}
