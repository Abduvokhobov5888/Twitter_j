package com.example.a581j;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a581j.Adapter.PostsAdapter;
import com.example.a581j.Adapter.Storiesadapter;
import com.example.a581j.Models.Post;
import com.example.a581j.Models.Story;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<Story> storys = Arrays.asList(
            new Story(R.drawable.birds, "Abbos"),
            new Story(R.drawable.nissan, "Muslim"),
            new Story(R.drawable.birds, "Bek"),
            new Story(R.drawable.nissan, "Ali"),
            new Story(R.drawable.birds, "Salah"),
            new Story(R.drawable.nissan, "Messi"),
            new Story(R.drawable.birds, "Ronaldo"),
            new Story(R.drawable.nissan, "Neymar")
    );

    List<Post> posts = Arrays.asList(
            new Post(R.raw.videoo, "Abbosbek"),
            new Post(R.raw.video, "Abbosbek"),
            new Post(R.raw.videoo, "Abbosbek"),
            new Post(R.raw.video, "Abbosbek")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    void initViews() {
        recyclerView = findViewById(R.id.rvStory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        setStory(storys);

        recyclerView = findViewById(R.id.rvPost);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setPost(posts);
    }

    void setStory(List<Story> stories) {
        Storiesadapter storiesadapter = new Storiesadapter(this, stories);
        recyclerView.setAdapter(storiesadapter);
    }


    void setPost(List<Post> post) {
        PostsAdapter storiesadapter = new PostsAdapter(this, post);
        recyclerView.setAdapter(storiesadapter);
    }


}