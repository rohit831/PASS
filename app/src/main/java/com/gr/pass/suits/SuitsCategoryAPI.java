package com.gr.pass.suits;

import com.gr.pass.model.Item;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rohit on 12/5/17.
 */
public interface SuitsCategoryAPI {

    @GET("category/")
    Call<ArrayList<Item>> getSuitsCategory();
}
