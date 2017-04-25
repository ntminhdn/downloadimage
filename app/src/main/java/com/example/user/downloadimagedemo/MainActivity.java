package com.example.user.downloadimagedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LruCache;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private List<String> images = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        addControl();
        addEvent();
    }

    private void initData() {
        images.add("https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1");
        images.add("https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1");
        images.add("https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1");
        images.add("https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1");
        images.add("https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1");
        images.add("https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1");
        images.add("https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1");
    }

    private void addEvent() {
//        for (int i = 0; i < images.size(); i++) {
//            new DownloadImageTask()
//        }
    }

    private void addControl() {
        myAdapter = new MyAdapter(MainActivity.this, images);
        recyclerView = (RecyclerView) findViewById(R.id.rcView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}
