package com.gr.pass;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class SareeCategoryAdapter extends RecyclerView.Adapter<SareeCategoryAdapter.SareesCategoryViewHolder> {

    ArrayList<String> categoryNames;
    Context context;

    public SareeCategoryAdapter(Context context, ArrayList<String> categoryNames)
    {
        this.categoryNames=categoryNames;
        this.context = context;
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
        if(position%4==0 || position%4==3)
        {
            holder.vh_category_saree_name.setBackground(context.getResources().getDrawable(R.drawable.border));
        }
        else
            holder.vh_category_saree_name.setBackground(context.getResources().getDrawable(R.drawable.border_grey));
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
