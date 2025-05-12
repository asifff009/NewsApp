package com.asif.newsapp;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewsDetails extends AppCompatActivity {

    ImageView coverImage;
    TextView tvTitle, tvDes;
    FloatingActionButton fabButton;

    public static String TITLE = "";
    public static String DESCRIPTION = "";
    public static Bitmap MY_BITMAP = null; // Bitmap diye chobi adan prodan kora jayy..

    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_details);

        coverImage = findViewById(R.id.coverImage);
        tvTitle = findViewById(R.id.tvTitle);
        tvDes = findViewById(R.id.tvDes);
        fabButton = findViewById(R.id.fabButton);

        tvTitle.setText(TITLE);
        tvDes.setText(DESCRIPTION);

        if(MY_BITMAP!=null) coverImage.setImageBitmap(MY_BITMAP);

        textToSpeech = new TextToSpeech(NewsDetails.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });


        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = tvDes.getText().toString();
                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });










    }
}