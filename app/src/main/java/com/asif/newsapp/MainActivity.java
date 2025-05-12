package com.asif.newsapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    HashMap<String, String> hashMap = new HashMap<>();
    ArrayList< HashMap<String, String>> arrayList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        createTable();

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);




    } // on create bundle end..

    // ListView niye kaj korte chaile adapter dhortei hobe , on create bundle er por

    private class MyAdapter extends BaseAdapter{

        private android.view.ViewGroup ViewGroup;

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // ekhane xml ta banate hobe.. layout theke new xml baniye nibo..


            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = inflater.inflate(R.layout.item, ViewGroup, false);


            return myView;
        }
    }

    // =========================================================================================
    // =========================================================================================
    // =========================================================================================
    // =========================================================================================



    private void createTable(){

        hashMap = new HashMap<>();
        hashMap.put("cat","TECH"); // cat --> category
        hashMap.put("image_url","https://outspoken.newagebd.com/files/img/default.png");
        hashMap.put("title","Samsung Galaxy A06 receives huge response");
        hashMap.put("des","Galaxy A06 features a 6.7-inch HD+ display with a 20:9 aspect ratio, MediaTek Helio G85 processor, 5,000mAh battery with 25W fast charging. The device also comes with 4 years of security updates and 2 generations of OS upgrades.\n" +
                "\n" +
                "To ensure a smooth photography experience, the Galaxy A06 offers a 50 MP primary camera, an 8 MP front camera, and a 2MP depth sensor.\n" +
                "\n" +
                "For content creators and video enthusiasts, the device can be the perfect starting point with its true dual camera and 60fps 1080p video recording features.\n" +
                "\n" +
                "Following the amazing response from customers, Samsung has announced to refill the stock of Galaxy A06 with new variants (4GB + 128GB and 6GB + 128GB) by mid-May.   ");  // des = --> description
        arrayList.add(hashMap);

    }

}