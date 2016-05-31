package com.test.recycleviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class GridActivity extends AppCompatActivity {

    RecyclerView rv;

    GridAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        rv = (RecyclerView) findViewById(R.id.grid_rv);
        GridLayoutManager gm = new GridLayoutManager(this, 4);
        rv.setLayoutManager(gm);
        rv.addItemDecoration(new DividerGridItemDecoration(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        adapter = new GridAdapter();
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.grid_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.delete:
                adapter.remove(1);
                break;

            case R.id.add:
                adapter.add(1);
                break;
        }
        return true;
    }
}
