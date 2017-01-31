package com.example.ton_s.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView myImg;
    Button myBtn;
    List<Integer> myImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImg = (ImageView) findViewById(R.id.myImg);
        myBtn = (Button) findViewById(R.id.myBtn);

        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRandomImage();
            }
        });

        initMyImages();

        myImg.setTag(myImageList.get(0));
        myImg.setImageResource(myImageList.get(0));
    }

    public void initMyImages() {
        myImageList = new ArrayList<>();
        myImageList.add(R.drawable.avatar2);
        myImageList.add(R.drawable.photo);
    }

    public void showRandomImage() {
        Random random = new Random();
        Integer randomImage = myImageList.get(random.nextInt(myImageList.size()));
        while (randomImage.equals(myImg.getTag())) {
            randomImage = myImageList.get(random.nextInt(myImageList.size()));
        }
        myImg.setTag(randomImage);
        myImg.setImageResource(randomImage);
    }
}
