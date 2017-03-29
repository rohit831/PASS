package com.gr.pass;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

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
        categoryNames.add("Anarkali");
        categoryNames.add("Angrakha");
        categoryNames.add("Silk");
        categoryNames.add("Chanderi");
        categoryNames.add("Ikat");
        categoryNames.add("Kalamkari");
        categoryNames.add("ChikanKari");
        categoryNames.add("Bandhani");

        adapter=new SuitCategoryAdapter(categoryNames,getActivity());
        layoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Suits");
    }
}

