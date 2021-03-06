package com.gr.pass.suits;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rohit on 12/5/17.
 */
public class SuitsGenerator {

    private static final String BASE_URL="http://192.168.43.151:8000/suits/";

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static <S> S createService(
            Class<S> serviceClass)
    {
        return retrofit.create(serviceClass);
    }
}
