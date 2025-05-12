package com.asif.newsapp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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

            ImageView itemCover = myView.findViewById(R.id.itemCover);
            TextView itemCat = myView.findViewById(R.id.itemCat);
            TextView itemTitle = myView.findViewById(R.id.itemTitle);
            TextView itemDes = myView.findViewById(R.id.itemDes);
            LinearLayout layItem = myView.findViewById(R.id.layItem);


            HashMap<String, String> hashMap = arrayList.get(position);

            String cat = hashMap.get("cat");
            String image_url = hashMap.get("image_url");
            String title = hashMap.get("title");
            String des = hashMap.get("des");

            Picasso.get().load(image_url)
                    .placeholder(R.drawable.icon_image)
                    .into(itemCover);

            itemCat.setText(cat);
            itemTitle.setText(title);
            itemDes.setText(des);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            itemCat.setBackgroundColor(color);

            layItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    NewsDetails.TITLE = title;
                    NewsDetails.DESCRIPTION = des;
                    Bitmap bitmap = ((BitmapDrawable) itemCover.getDrawable()).getBitmap();

                    NewsDetails.MY_BITMAP = bitmap;


                    startActivity(new Intent(MainActivity.this, NewsDetails.class));
                }
            });




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

        hashMap = new HashMap<>();
        hashMap.put("cat","NEWS"); // cat --> category
        hashMap.put("image_url","https://outspoken.newagebd.com/files/img/202505/d03ec4b85c0ed4d988facbebc198a251.jpg");
        hashMap.put("title","Indian PM Modi set to address nation");
        hashMap.put("des","GUS President Donald Trump announced the truce late Saturday after four days of missile, drone and artillery attacks which killed at least 60 people and sent thousands fleeing on both sides.\n" +
                "\n" +
                "The heads of military operations of India and Pakistan were also set to review the truce later Monday.\n" +
                "\n" +
                "It comes after the Indian army reported the ‘first calm night in recent days’ in Kashmir and along its western border with Pakistan.\n" +
                "\n" +
                "Initially the conversation had been due to take place at 12:00pm (0630 GMT) but Indian officials said it had been delayed to the evening.\n" +
                "\n" +
                "Abdul Basit at the S Rajaratnam School of International Studies in Singapore said it would be about modalities of the ceasefire and not policy decisions.\n" +
                "\n" +
                "The aim is to ‘avoid any miscalculations, because right now one spark could quickly move towards a nuclear catastrophe,’ Basit told AFP.\n" +
                "\n" +
                "The flare-up in violence was the worst since the rivals’ last open conflict in 1999 and sparked global shudders that it could spiral into full-blown war.");  // des = --> description
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","UN"); // cat --> category
        hashMap.put("image_url","https://outspoken.newagebd.com/files/img/202505/7a55969540132a5572599310d6fbb571.jpg");
        hashMap.put("title","WWII’s lessons must never be forgotten: Russian envoy");
        hashMap.put("des","The embassy of Russia in Bangladesh hosted a reception at a city hotel on the occasion of the Victory Day Sunday evening.\n" +
                "\n" +
                "This year celebrations carry special significance since they mark the 80th anniversary of the Victory of the USSR in the Great Patriotic War on May 9, 1945.\n" +
                "\n" +
                "Sattar Mia, head of the National Group company and president of the Russian Friendship Society with Bangladesh, delivered welcome remarks.\n" +
                "\n" +
                "The ambassador highlighted the decisive role of the USSR in defeating Nazi Germany and liberating Eastern and Central Europe.\n" +
                "\n" +
                "‘Any attempts to distort the historical truth, to whitewash Nazi criminals and their accomplices, to diminish the role of the Soviet people in the victorious end of the war are blasphemous and must be stopped’, he stressed.\n" +
                "\n" +
                "The envoy said that the war had remained forever in the people’s memory. ‘These are bitter and at the same time heroic pages of our history, written in blood into the destinies of our nations.’\n" +
                "\n" +
                "The Russian ambassador also said that they would pass on the historical truth about the war and the memory of it, inherited from their ancestors, to their descendants.\n" +
                "\n");  // des = --> description
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","SPORTS"); // cat --> category
        hashMap.put("image_url","https://e0.365dm.com/25/04/768x432/skysports-carlo-ancelotti-real-madrid_6873540.jpg?20250402072433");
        hashMap.put("title","Ancelotti to leave Real Madrid to coach Brazil");
        hashMap.put("des","A statement from the Brazilian Football Confederation (CBF) said Ancelotti was a \"legend of the game\" and acknowledged the significance of a foreign coach taking charge of the team.\n" +
                "\n" +
                "\"This landmark moment sees the coming together of two icons — the only five-time Fifa World Cup champions, and a coach with an unmatched record across Europe's elite competitions,\" the CBF said.\n" +
                "\n" +
                "\"The CBF warmly welcomes Mr Ancelotti and looks forward to a new era of success under his leadership.\"\n" +
                "\n" +
                "In their statement, the CBF also thanked Real president Florentino Perez for \"facilitating the coach's release during his contract term\".\n" +
                "\n" +
                "Ancelotti's current deal with Real was set to expire in June 2026.\n" +
                "\n" +
                "The Italian takes over the Brazil job from Dorival Junior, who was sacked in March after they lost 4-1 to arch-rivals Argentina in World Cup qualifying.\n" +
                "\n" +
                "Brazil sit fourth in the South American group, having lost five of 14 games, although are still well placed to qualify for the 2026 finals.\n" +
                "\n" +
                "Ancelotti's first games in charge of Brazil will be the Selecao's World Cup qualifiers against Paraguay and Ecuador next month.\n" +
                "\n");  // des = --> description
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","CRICKET"); // cat --> category
        hashMap.put("image_url","https://media.crictracker.com/media/attachments/Shaun-Tait-Australia-1.jpg");
        hashMap.put("title","SBangladesh appoint Shaun Tait as pace bowling coach");
        hashMap.put("des","BCB has appointed Shaun Tait as Bangladesh's fast-bowling coach. His contract runs up to November 2027, with the expectation that Tait's experience of working as a bowling coach in the subcontinent will be useful for the team.\n" +
                "\n" +
                "He replaces Andre Adams, whose contract ended via mutual agreement with the BCB. Adams had joined in March 2024, overseeing the development of the fast-bowling group from the T20 World Cup last year, and into the Champions Trophy this year.\n" +
                "\n" +
                "\n" +
                "Tait takes over at a busy juncture for the side, as they look ahead to a long summer of T20Is interjected with ODIs and Tests. Bangladesh are building up to the T20 World Cup next year before they prepare for the 50-over World Cup in 2027.");  // des = --> description
        arrayList.add(hashMap);

    }

}