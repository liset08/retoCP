package com.cayhualla.ecommerce_cineplanet.service;


import com.cayhualla.ecommerce_cineplanet.model.CandyStore;
import com.cayhualla.ecommerce_cineplanet.model.Premiers;
import com.cayhualla.ecommerce_cineplanet.response.PaymentResponse;
import com.cayhualla.ecommerce_cineplanet.response.ResponseMessage;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    String API_BASE_URL = "http://ec2-18-219-76-53.us-east-2.compute.amazonaws.com:8080/cp/v1/";
    String API_PAY_U = "https://sandbox.api.payulatam.com/payments-api/4.0/";


    @GET("candystore")
    Call<CandyStore> list_candy_store();

    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @POST("service.cgi")
    Call<PaymentResponse> make_transaction(@Body RequestBody body);

    @GET("premieres")
    Call<Premiers> list_premiers();

    @FormUrlEncoded
    @POST("complete")
    Call<ResponseMessage> store_complete(@Field("name") String name,
                                @Field("mail") String mail,
                                @Field("dni") String dni,
                                @Field("operation_date") String operation_date
    );
}
