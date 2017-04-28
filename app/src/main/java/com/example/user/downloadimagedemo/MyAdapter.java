package com.example.user.downloadimagedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Objects;

/**
 * Created by User on 24/04/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List listAll;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public MyAdapter(Context context, List listAll) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.listAll = listAll;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = mLayoutInflater.inflate(R.layout.recycle_view_item, parent, false);
        View item2 = mLayoutInflater.inflate(R.layout.second_view_item, parent, false);

        if (viewType == 0) {
            return new MyViewHolder(item);
        } else {
            return new SecondViewHolder(item2);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).loadImage((String) listAll.get(position));
        }

        if (holder instanceof SecondViewHolder) {
            ((SecondViewHolder) holder).isChecked((Boolean) listAll.get(position));
        }

        //     new DownloadImageTask(holder.imgView).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,url);
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return listAll.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgView = (ImageView) itemView.findViewById(R.id.imgItem);
        }

        public void loadImage(String url) {
//            Picasso.with(mContext).load(url).networkPolicy(NetworkPolicy.OFFLINE).into(imgView);
            ImageLoader.getInstance().loadImage(url, imgView);
        }
    }

    class SecondViewHolder extends RecyclerView.ViewHolder {

        private CheckBox cb;

        public SecondViewHolder(View itemView) {
            super(itemView);
            cb = (CheckBox) itemView.findViewById(R.id.cb);
        }

        public void isChecked(boolean isChecked) {
            if (isChecked) {
                cb.setChecked(true);
            } else {
                cb.setChecked(false);
            }
        }
    }
}
