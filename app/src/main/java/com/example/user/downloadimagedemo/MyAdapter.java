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
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by User on 24/04/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> list;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public MyAdapter(Context context, List<String> list) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = mLayoutInflater.inflate(R.layout.recycle_view_item, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String url = list.get(position);
        new DownloadImageTask(holder.imgView).execute(url);
        LruCache<String, Bitmap> cache = new LruCache<>(4096);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public ImageView getImageView() {
        View item = mLayoutInflater.inflate(R.layout.recycle_view_item, null, false);
        MyViewHolder myViewHolder = new MyViewHolder(item);

        return myViewHolder.imgView;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgView = (ImageView) itemView.findViewById(R.id.imgItem);
        }
    }

    class DownloadImageTask extends AsyncTask<String, Bitmap, Bitmap> {

        private ImageView imageView;

        public DownloadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String urldisplay = params[0];
            Bitmap bitmap = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                System.out.println("đã tải xong");
            }
        }
    }
}
