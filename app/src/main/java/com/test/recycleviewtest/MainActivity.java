package com.test.recycleviewtest;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyRecycleView recyclerView;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        final List<Integer> datas = new ArrayList<>(Arrays.asList(R.mipmap.a, R.mipmap.b, R.mipmap.c,
                R.mipmap.d, R.mipmap.e, R.mipmap.f, R.mipmap.g, R.mipmap.h, R.mipmap.j));
        iv = (ImageView) findViewById(R.id.image);
        recyclerView = (MyRecycleView) findViewById(R.id.rv);
        recyclerView.setListener(new MyRecycleView.onItemScrollChangeListener() {
            @Override
            public void onItemChange(View v, int position) {
                iv.setImageResource(datas.get(position));
            }
        });
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(lm);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));
        GalleryAdapter adapter = new GalleryAdapter(datas);
        adapter.setOnItemClickListener(new GalleryAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                iv.setImageResource(datas.get(position));
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}
