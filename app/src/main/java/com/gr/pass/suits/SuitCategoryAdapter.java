package com.gr.pass.suits;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gr.pass.model.Item;
import com.gr.pass.R;

import java.util.ArrayList;

public class SuitCategoryAdapter extends RecyclerView.Adapter<SuitCategoryAdapter.SuitCategoryViewHolder> {

    ArrayList<Item> categoryNames;
    Context context;

    public SuitCategoryAdapter(Context context, ArrayList<Item> categoryNames) {
        this.categoryNames = categoryNames;
        this.context = context;
    }

    @Override
    public SuitCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout,parent,false);
        SuitCategoryViewHolder holder=new SuitCategoryViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(SuitCategoryViewHolder holder, int position) {

        holder.vh_category_suit_name.setText(categoryNames.get(position).getCategory());
        if(position%4==0 || position%4==3 )
        {
            holder.vh_category_suit_name.setBackground(context.getResources().getDrawable(R.drawable.rectangle_shape_red));
        }
        else
            holder.vh_category_suit_name.setBackground(context.getResources().getDrawable(R.drawable.rectangle_shape_grey));
    }

    @Override
    public int getItemCount() {
        return categoryNames.size();
    }

    public static class SuitCategoryViewHolder  extends RecyclerView.ViewHolder
    {
        TextView vh_category_suit_name;
        public SuitCategoryViewHolder(View itemView) {
            super(itemView);

            vh_category_suit_name=(TextView)itemView.findViewById(R.id.category_item_name);
        }
    }
}
