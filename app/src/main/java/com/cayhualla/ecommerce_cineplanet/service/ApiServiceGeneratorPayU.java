package com.cayhualla.ecommerce_cineplanet.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ApiServiceGeneratorPayU {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(ApiService.API_PAY_U)
           // .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(SimpleXmlConverterFactory.create());

    private static Retrofit retrofit;

    private ApiServiceGeneratorPayU() {
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