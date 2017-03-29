package com.gr.pass;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class LeggingsCategory extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private  RecyclerView.LayoutManager layoutManager;
    ArrayList<String> categoryNames=new ArrayList<String>(10);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_leggings_category,container,false);

        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view_category_leggings);
        categoryNames.add("Ankle");
        categoryNames.add("Mid-Calf");
        categoryNames.add("Stirrup");
        categoryNames.add("Footed");
        categoryNames.add("Jeggings");
        categoryNames.add("Short");
        categoryNames.add("Printed");

        adapter=new LeggingsCategoryAdapter(getActivity(),categoryNames);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Leggings");
    }
}
