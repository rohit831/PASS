package com.gr.pass.suits;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gr.pass.model.Item;
import com.gr.pass.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuitsCategory extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<String> categoryNames=new ArrayList<String>(10);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_suits_category,container,false );

        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view_category_suits);
//        categoryNames.add("Anarkali");
//        categoryNames.add("Angrakha");
//        categoryNames.add("Silk");
//        categoryNames.add("Chanderi");
//        categoryNames.add("Ikat");
//        categoryNames.add("Kalamkari");
//        categoryNames.add("ChikanKari");
//        categoryNames.add("Bandhani");

        getCategory();

        return view;
    }

    private void getCategory() {
        SuitsCategoryAPI suitsCategoryAPI = SuitsGenerator.createService(SuitsCategoryAPI.class);
        Call<ArrayList<Item>> categoryNames = suitsCategoryAPI.getSuitsCategory();

        categoryNames.enqueue(new Callback<ArrayList<Item>>() {
            @Override
            public void onResponse(Call<ArrayList<Item>> call, Response<ArrayList<Item>> response) {
                adapter = new SuitCategoryAdapter(getActivity(), response.body());
                layoutManager = new GridLayoutManager(getActivity(), 2);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<ArrayList<Item>> call, Throwable t) {
                Toast.makeText(getActivity(), "Unable to connect to server!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Suits");
    }
}

