package com.appspot.mccfall2017g12.photoorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GalleryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumAdapter adapter;
    private LocalDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        final int columnCount = getResources().getInteger(R.integer.album_column_count);

        this.database = LocalDatabase.getInstance(this);

        this.recyclerView = findViewById(R.id.albums_recycler_view);
        this.recyclerView.setHasFixedSize(true);

        this.adapter = new AlbumAdapter(this, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = GalleryActivity.this.recyclerView.getChildAdapterPosition(view);
                String albumKey = GalleryActivity.this.adapter.getItem(position).album.albumId;

                Intent intent = new Intent(GalleryActivity.this, AlbumActivity.class);
                intent.putExtra(AlbumActivity.EXTRA_ALBUM, albumKey);
                startActivity(intent);
            }
        });
        this.recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this, columnCount);
        this.recyclerView.setLayoutManager(layoutManager);

        this.adapter.setLiveData(database.galleryDao().loadAllAlbums());
    }
}
