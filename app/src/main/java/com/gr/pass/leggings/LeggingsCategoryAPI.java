package com.gr.pass.leggings;

import com.gr.pass.model.Item;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rohit on 12/5/17.
 */
public interface LeggingsCategoryAPI {

    @GET("category/")
    Call<ArrayList<Item>> getLeggingsCategory();
}
