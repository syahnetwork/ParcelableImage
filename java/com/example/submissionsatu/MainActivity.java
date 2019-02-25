package com.example.submissionsatu;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] dataName;
    String[] dataDescription;
    TypedArray dataPhoto;
    MovieAdapter adapter;
    ListView listView;
    String[] dataTanggal;
    ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);

        listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();
//pindah ke detailview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, dataName[i], Toast.LENGTH_SHORT).show();

                Movie movie = new Movie();
//                movie.setPhoto(dataPhoto.getResourceId(i, -1));
                movie.setPhoto(dataPhoto.getResourceId(i,-1));
                movie.setName("Movie Title : \n"+dataName[i]);
                movie.setTanggal("Released : \n"+dataTanggal[i]);
                movie.setDescription("Storyline : \n"+dataDescription[i]);

                Intent move = new Intent(MainActivity.this, DetailActivity.class);
                move.putExtra(DetailActivity.EXTRA_MOVIE, movie);

//                move.putExtra("image_url",R.drawable.angrymen);
//                move.putExtra("imageResourceId", dataPhoto.getResourceId(i,-1));
                startActivity(move);





            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataTanggal = getResources().getStringArray(R.array.tanggal);
    }

    private void addItem() {
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setName(dataName[i]);
            movie.setTanggal("Released : "+dataTanggal[i]);
            movie.setDescription(dataDescription[i]);
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }
}

