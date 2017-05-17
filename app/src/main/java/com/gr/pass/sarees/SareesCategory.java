package com.gr.pass.sarees;

import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
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

public class SareesCategory extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    private  RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_sarees_category,container,false);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreh_recycler_view_category_sarees);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view_category_sarees);
//        categoryNames.add("Cotton");
//        categoryNames.add("Silk");
//        categoryNames.add("Chiffon");
//        categoryNames.add("Crepe");
//        categoryNames.add("Georgette");
//        categoryNames.add("kanjeevaram");
//        categoryNames.add("Banarasi");

        getCategory();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getCategory();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        return view;
    }

    private void getCategory()
    {
        SareesCategoryAPI sareesCategoryAPI = SareesGenerator.createService(SareesCategoryAPI.class);
        Call<ArrayList<Item>> categoryNames = sareesCategoryAPI.getSareesCategory();

        categoryNames.enqueue(new Callback<ArrayList<Item>>() {
            @Override
            public void onResponse(Call<ArrayList<Item>> call, Response<ArrayList<Item>> response) {
                adapter=new SareeCategoryAdapter(getActivity(),response.body());
                layoutManager=new GridLayoutManager(getActivity(),2);
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Sarees");
    }
}
