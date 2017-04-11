package com.henderson.ant.holdthefrontpage.api;


import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Ant on 11/04/2017.
 */

public interface HTFPapi {

    @GET("test-mobile/iOS/json/test2.json")
    Observable<String> getArticles();
}
