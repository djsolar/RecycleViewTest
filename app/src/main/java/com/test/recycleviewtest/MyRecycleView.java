package com.test.recycleviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhouyiran on 16/5/30.
 */
public class MyRecycleView extends RecyclerView {

    private View currentView;

    public MyRecycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addOnScrollListener(new MyScrollListener());
    }


    public interface onItemScrollChangeListener {

        void onItemChange(View v, int position);
    }

    private onItemScrollChangeListener listener;


    public void setListener(onItemScrollChangeListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        currentView = getChildAt(0);
        if(listener != null) {
            listener.onItemChange(currentView, getChildLayoutPosition(currentView));
        }
    }

    class MyScrollListener extends OnScrollListener {

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            View newView = getChildAt(0);
            if(listener != null) {
                if(newView != null && newView != currentView) {
                    currentView = newView;
                    listener.onItemChange(currentView, getChildLayoutPosition(currentView));
                }
            }
        }
    }
}
