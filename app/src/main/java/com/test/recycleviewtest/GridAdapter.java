package com.test.recycleviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouyiran on 16/5/31.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    private List<String> chars;
    public GridAdapter() {
        chars = new ArrayList<>();
        for(int i = 'A'; i <= 'z'; i++) {
            chars.add("" + (char)i);
        }
    }

    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.grid_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridAdapter.ViewHolder holder, int position) {
        holder.tv.setText(this.chars.get(position));
    }

    @Override
    public int getItemCount() {
        return chars.size();
    }

    public void add(int position) {
        chars.add(position, "zhou");
        notifyItemInserted(position);
    }

    public void remove(int position) {
        chars.remove(position);
        notifyItemRemoved(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.char_name);
        }
    }
}
