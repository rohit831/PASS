package com.gr.pass;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SareesCategory extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private  RecyclerView.LayoutManager layoutManager;
    ArrayList<String> categoryNames=new ArrayList<String>(10);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_sarees_category,container,false);

        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view_category_sarees);
        categoryNames.add("Cotton");
        categoryNames.add("Silk");
        categoryNames.add("Chiffon");
        categoryNames.add("Crepe");
        categoryNames.add("Georgette");
        categoryNames.add("kanjeevaram");
        categoryNames.add("Banarasi");

        adapter=new SareeCategoryAdapter(getActivity(),categoryNames);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Sarees");
    }
}
