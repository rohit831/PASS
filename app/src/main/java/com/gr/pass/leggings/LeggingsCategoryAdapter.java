package com.gr.pass.leggings;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gr.pass.model.Item;
import com.gr.pass.R;

import java.util.ArrayList;

/**
 * Created by gaurav on 30/3/17.
 */

public class LeggingsCategoryAdapter extends RecyclerView.Adapter<LeggingsCategoryAdapter.LeggingsCategoryViewHolder> {

    ArrayList<Item> categoryNames;
    Context context;

    public LeggingsCategoryAdapter(Context context, ArrayList<Item> categoryNames) {
        this.categoryNames = categoryNames;
        this.context = context;
    }

    @Override
    public LeggingsCategoryAdapter.LeggingsCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout, parent, false);

        LeggingsCategoryAdapter.LeggingsCategoryViewHolder holder = new LeggingsCategoryAdapter.LeggingsCategoryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(LeggingsCategoryAdapter.LeggingsCategoryViewHolder holder, int position) {

        holder.vh_category_legging_name.setText(categoryNames.get(position).getCategory());
        if (position % 4 == 0 || position%4 == 3) {
            holder.vh_category_legging_name.setBackground(context.getResources().getDrawable(R.drawable.rectangle_shape_red));
        } else
            holder.vh_category_legging_name.setBackground(context.getResources().getDrawable(R.drawable.rectangle_shape_grey));
    }

    @Override
    public int getItemCount() {
        return categoryNames.size();
    }

    public static class LeggingsCategoryViewHolder extends RecyclerView.ViewHolder {
        TextView vh_category_legging_name;

        public LeggingsCategoryViewHolder(View itemView) {
            super(itemView);

            vh_category_legging_name = (TextView) itemView.findViewById(R.id.category_item_name);

        }
    }
}
