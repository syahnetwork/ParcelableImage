package com.example.submissionsatu;


import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import java.io.File;


public class DetailActivity extends AppCompatActivity {


    TextView tvObject;
    ImageView img;

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvObject = findViewById(R.id.tv_object_received);


        Movie movieintent = getIntent().getParcelableExtra(EXTRA_MOVIE);
//        Movie imagee = getIntent().getParcelableExtra(EXTRA_MOVIE);
        String text = movieintent.getName() + "\n" + movieintent.getTanggal() + "\n" + movieintent.getDescription();
        int asd = movieintent.getPhoto();

        Movie testmovie = new Movie();

        tvObject.setText(text);
//        TypedArray imgs = getResources().obtainTypedArray(R.array.data_photo);
//        for (int i = 0; i < imgs.length(); i++) {
//            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
//            //Here you are putting in the generic R.array.image_ids
//            //Instead you should put in the images specific id: imgs.getResourceId(i, -1));
//            imageItems.add(new ImageItem(bitmap, R.array.image_ids));
//        }



//        img.setImageResource(asd);
//        Image imagee =  getIntent().getParcelableExtra("EXTRA_MOVIE");
//        ImageView imgPhoto = view.findViewById(R.id.img_photo);
//        img.setImageResource(asd);

//        img.setImageResource(testmovie.getPhoto());
//        img.setPhoto(asd);
//        imgPhoto.setImageResource(imagee);

//        Bitmap image =  getIntent().getParcelableExtra(EXTRA_MOVIE);
//        img.setImageBitmap(image);


    }


}
