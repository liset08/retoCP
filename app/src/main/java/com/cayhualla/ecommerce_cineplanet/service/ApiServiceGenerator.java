package com.cayhualla.ecommerce_cineplanet.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceGenerator {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(ApiService.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit;

    private ApiServiceGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass) {
        if(retrofit == null) {
            retrofit = builder.client(httpClient.connectTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS).build()).build();
        }
        return retrofit.create(serviceClass);
    }


}