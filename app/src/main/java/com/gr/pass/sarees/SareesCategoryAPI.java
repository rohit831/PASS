package com.gr.pass.sarees;

import com.gr.pass.model.Item;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rohit on 9/5/17.
 */
public interface SareesCategoryAPI {

    @GET("category/")
    Call<ArrayList<Item>> getSareesCategory();
}
