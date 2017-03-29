package com.gr.pass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SareesCategory extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;
    ArrayList<String> categoryNames=new ArrayList<String>(10);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sarees_category);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view_category_sarees);
        categoryNames.add("Cotton");
        categoryNames.add("Silk");
        categoryNames.add("Chiffon");
        categoryNames.add("Crepe");
        categoryNames.add("Georgette");
        categoryNames.add("kanjeevaram");
        categoryNames.add("Banarasi");

        adapter=new SareeCategoryAdapter(categoryNames);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}
