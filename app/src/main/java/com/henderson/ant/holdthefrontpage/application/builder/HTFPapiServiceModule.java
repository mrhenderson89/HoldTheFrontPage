package com.henderson.ant.holdthefrontpage.application.builder;

import com.henderson.ant.holdthefrontpage.api.HTFPapi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ant on 11/04/2017.
 */
@Module
public class HTFPapiServiceModule {

    //TODO: Change this to reflect real usage of Retrofit network calls

    private static final String BASE_URL = "http://coemygroup.fr/";
    @AppScope
    @Provides
    HTFPapi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter)
    {
        Retrofit retrofit =   new Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gson).
                        addCallAdapterFactory(rxAdapter).build();

        return  retrofit.create(HTFPapi.class);
    }


}
