package com.example.insight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Book_Activity extends AppCompatActivity {

    private TextView bktitle,bkdescription,bkcategory;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        bktitle = (TextView) findViewById(R.id.bookTitleid);
       /* bkdescription = (TextView) findViewById(R.id.);
        bkcategory = (TextView) findViewById(R.id.);*/
        img = (ImageView) findViewById(R.id.bookImageid);


        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail") ;

        // Setting values

        bktitle.setText(Title);
        //bkdescription.setText(Description);
        img.setImageResource(image);

    }
}
