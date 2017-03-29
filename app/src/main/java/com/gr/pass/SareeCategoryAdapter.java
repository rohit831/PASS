package com.gr.pass;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class SareeCategoryAdapter extends RecyclerView.Adapter<SareeCategoryAdapter.SareesCategoryViewHolder> {

    ArrayList<String> categoryNames;

    public SareeCategoryAdapter(ArrayList<String> categoryNames)
    {
        this.categoryNames=categoryNames;
    }

    @Override
    public SareesCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout,parent,false);

        SareesCategoryViewHolder holder =new SareesCategoryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SareesCategoryViewHolder holder, int position) {

        holder.vh_category_saree_name.setText(categoryNames.get(position));
        if(position%2==0)
        {
            holder.vh_category_saree_name.setBackgroundColor(Color.parseColor("f02b3d"));
        }
        else
            holder.vh_category_saree_name.setBackgroundColor(Color.parseColor("cdc8c9"));
    }

    @Override
    public int getItemCount() {
        return categoryNames.size();
    }

    public static class SareesCategoryViewHolder extends RecyclerView.ViewHolder
    {
        TextView vh_category_saree_name;
        public SareesCategoryViewHolder(View itemView) {
            super(itemView);

            vh_category_saree_name=(TextView)itemView.findViewById(R.id.category_saree_name);
        }
    }
}
