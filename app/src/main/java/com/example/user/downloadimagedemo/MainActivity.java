package com.example.user.downloadimagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private List<String> images = new ArrayList<>();
    private List<Boolean> booleens = new ArrayList<>();
    private List listAll = new ArrayList();
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
//        images.addAll(Arrays.asList(mStrings));

        images.add("https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1");
        images.add("http://3.bp.blogspot.com/-_hwS-1Yy0qI/VQ_YJmB301I/AAAAAAAAB30/_5QJ_0gC11M/s1600/%E1%BA%A2nh%2B%C4%91%E1%BA%B9p%2Bthi%C3%AAn%2Bnhi%C3%AAn6.jpg");
        images.add("https://i.imgur.com/tbTRVIN.jpg");
        images.add("https://giaophanphucuong.org/Document/Images/Tin%20tuc/Tin%20GHVN/Tin%20tuc/tong-dai-dien-xuan-loc-4.jpg");
        images.add("http://taihinhanhdep.xyz/wp-content/uploads/2015/08/anh-thien-nhien-dep-1.jpg");
        images.add("http://hinhanhnen.biz/hinhanh/hinhfck/1419hinh-anh-con-duong-mon-tren-thao-nguyen-xanh.jpg");
        images.add("http://bachvietme.com/media/posts/image/1445008062617786.jpg");
        images.add("http://taihinhanhdep.xyz/wp-content/uploads/2016/06/hinh-anh-thien-nhien-dep-3d.jpg");
        images.add("http://images.tapchianhdep.net/15-10xem-bo-anh-thien-nhien-dep-nhat-moi-ngay8.jpg");
        images.add("http://images.tapchianhdep.net/15-11anh-thien-nhien-mua-thu-dep-nao-long-khap-the-gioi3.jpg");
        images.add("http://2.bp.blogspot.com/-k28hL8vED6A/VYKBoaO5EXI/AAAAAAAACBc/gaD63Oh5I8w/s1600/fog_over_mountains-HD.jpg");
        images.add("http://www.xemanh.net/wp-content/uploads/2015/10/nhung-hinh-anh-dep-thien-nhien-cua-que-huong-viet-nam-1.jpg");
        images.add("https://i.imgur.com/fkFfnBV.jpg");
        images.add("https://anhdephd.com/wp-content/uploads/2016/10/canh-dep-thien-nhien-tai-italia.jpg");
        images.add("https://khunganhonline.com/images/frame/frame_demo/khung-anh-thoi-tiet56b1dc92e75e7.jpg");
        images.add("http://biancuocsong.com/wp-content/uploads/2015/12/nhung-buc-anh-thien-nhien-tuyet-dep-1024x640.jpg");
        images.add("http://toananhdep.com/wp-content/uploads/2015/12/nhung-hinh-anh-thien-nhien-dep-an-tuong-va-day-tho-mong-danh-cho-may-tinh-2.jpg");
        images.add("http://www2.danviet.vn/upload/4-2016/images/2016-10-04/147556204864419-anhthiennhien2.jpg");
        images.add("http://1.bp.blogspot.com/-eNi_MgKMJIQ/UbcA422mNRI/AAAAAAAAKvU/MTeJU9imprY/s1600/hinh-anh-thien-nhien-dep-3.jpg");
        images.add("http://ngoisaostar.net/wp-content/uploads/2016/05/nhung-phong-canh-thien-nhien-dep-nhat-the-gioi-1.jpg");


        booleens.add(true);
        booleens.add(true);
        booleens.add(true);
        booleens.add(false);
        booleens.add(true);
        booleens.add(false);
        booleens.add(true);
        booleens.add(false);
        booleens.add(true);
        booleens.add(true);
        booleens.add(false);
        booleens.add(false);
        booleens.add(true);
        booleens.add(true);
        booleens.add(false);
        booleens.add(true);
        booleens.add(false);
        booleens.add(true);
        booleens.add(true);
        booleens.add(false);

        listAll.addAll(images);
        listAll.addAll(booleens);

        for (int i = 0; i < images.size(); i++) {
            listAll.set(i * 2, images.get(i));
        }

        for (int i = 0; i < booleens.size(); i++) {
            listAll.set(i * 2 + 1, booleens.get(i));
        }
    }

    private void addEvent() {

    }

    private void addControl() {

        recyclerView = (RecyclerView) findViewById(R.id.rcView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        myAdapter = new MyAdapter(MainActivity.this, listAll);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

//    private String[] mStrings = {
//            "https://pbs.twimg.com/profile_images/3092003750/9b72a46e957a52740c667f4c64fa5d10_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/2508170683/m8jf0po4imu8t5eemjdd_normal.png",
//            "https://pbs.twimg.com/profile_images/1701796334/TA-New-Logo_normal.jpg",
//            "https://pbs.twimg.com/profile_images/913338263/AndroidPolice_logo_normal.png",
//            "https://pbs.twimg.com/profile_images/1417650153/android-hug_normal.png",
//            "https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png",
//            "https://pbs.twimg.com/profile_images/3319660679/70e7025a05b674852b9f3cea0998259c_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/2100693240/58534_150210305010136_148613708503129_315282_6481640_n_normal.jpg",
//            "https://pbs.twimg.com/profile_images/1306095935/androidcoo_normal.png",
//            "https://pbs.twimg.com/profile_images/2938108229/399ba333772228bfbb40134018fbe777_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/487047133392949248/sVTI9rGI_normal.png",
//            "https://pbs.twimg.com/profile_images/3092003750/9b72a46e957a52740c667f4c64fa5d10_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/2508170683/m8jf0po4imu8t5eemjdd_normal.png",
//            "https://pbs.twimg.com/profile_images/1701796334/TA-New-Logo_normal.jpg",
//            "https://pbs.twimg.com/profile_images/913338263/AndroidPolice_logo_normal.png",
//            "https://pbs.twimg.com/profile_images/1417650153/android-hug_normal.png",
//            "https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png",
//            "https://pbs.twimg.com/profile_images/3319660679/70e7025a05b674852b9f3cea0998259c_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/2100693240/58534_150210305010136_148613708503129_315282_6481640_n_normal.jpg",
//            "https://pbs.twimg.com/profile_images/1306095935/androidcoo_normal.png",
//            "https://pbs.twimg.com/profile_images/2938108229/399ba333772228bfbb40134018fbe777_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/487047133392949248/sVTI9rGI_normal.png", "https://pbs.twimg.com/profile_images/3092003750/9b72a46e957a52740c667f4c64fa5d10_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/2508170683/m8jf0po4imu8t5eemjdd_normal.png",
//            "https://pbs.twimg.com/profile_images/1701796334/TA-New-Logo_normal.jpg",
//            "https://pbs.twimg.com/profile_images/913338263/AndroidPolice_logo_normal.png",
//            "https://pbs.twimg.com/profile_images/1417650153/android-hug_normal.png",
//            "https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png",
//            "https://pbs.twimg.com/profile_images/3319660679/70e7025a05b674852b9f3cea0998259c_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/2100693240/58534_150210305010136_148613708503129_315282_6481640_n_normal.jpg",
//            "https://pbs.twimg.com/profile_images/1306095935/androidcoo_normal.png",
//            "https://pbs.twimg.com/profile_images/2938108229/399ba333772228bfbb40134018fbe777_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/487047133392949248/sVTI9rGI_normal.png", "https://pbs.twimg.com/profile_images/3092003750/9b72a46e957a52740c667f4c64fa5d10_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/2508170683/m8jf0po4imu8t5eemjdd_normal.png",
//            "https://pbs.twimg.com/profile_images/1701796334/TA-New-Logo_normal.jpg",
//            "https://pbs.twimg.com/profile_images/913338263/AndroidPolice_logo_normal.png",
//            "https://pbs.twimg.com/profile_images/1417650153/android-hug_normal.png",
//            "https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png",
//            "https://pbs.twimg.com/profile_images/3319660679/70e7025a05b674852b9f3cea0998259c_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/2100693240/58534_150210305010136_148613708503129_315282_6481640_n_normal.jpg",
//            "https://pbs.twimg.com/profile_images/1306095935/androidcoo_normal.png",
//            "https://pbs.twimg.com/profile_images/2938108229/399ba333772228bfbb40134018fbe777_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/487047133392949248/sVTI9rGI_normal.png", "https://pbs.twimg.com/profile_images/3092003750/9b72a46e957a52740c667f4c64fa5d10_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/2508170683/m8jf0po4imu8t5eemjdd_normal.png",
//            "https://pbs.twimg.com/profile_images/1701796334/TA-New-Logo_normal.jpg",
//            "https://pbs.twimg.com/profile_images/913338263/AndroidPolice_logo_normal.png",
//            "https://pbs.twimg.com/profile_images/1417650153/android-hug_normal.png",
//            "https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png",
//            "https://pbs.twimg.com/profile_images/3319660679/70e7025a05b674852b9f3cea0998259c_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/2100693240/58534_150210305010136_148613708503129_315282_6481640_n_normal.jpg",
//            "https://pbs.twimg.com/profile_images/1306095935/androidcoo_normal.png",
//            "https://pbs.twimg.com/profile_images/2938108229/399ba333772228bfbb40134018fbe777_normal.jpeg",
//            "https://pbs.twimg.com/profile_images/487047133392949248/sVTI9rGI_normal.png"
//    };

}
