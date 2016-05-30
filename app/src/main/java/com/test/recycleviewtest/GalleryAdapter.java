package com.test.recycleviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhouyiran on 16/5/30.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    public List<Integer> datas;

    private onItemClickListener listener;

    public GalleryAdapter(List<Integer> datas) {
        this.datas = datas;
    }

    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.scroll_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GalleryAdapter.ViewHolder holder, final int position) {
        holder.iv.setImageResource(datas.get(position));
        if(listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.datas.size();
    }

    public void setOnItemClickListener(GalleryAdapter.onItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public interface onItemClickListener {
        void onItemClick(View view, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView iv;

        public TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
