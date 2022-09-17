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

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews(){
        recyclerView = findViewById(R.id.rvStory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        getAdapter(getData());

        recyclerView = findViewById(R.id.rvPost);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        getAdapter1(getData1());
    }

    void getAdapter(ArrayList<Story> stories){
        Storiesadapter storiesadapter = new Storiesadapter(this, stories);
        recyclerView.setAdapter(storiesadapter);
    }

    ArrayList<Story> getData(){
        ArrayList<Story> story  = new ArrayList<>();

        story.add(new Story(R.drawable.birds, "Abbos"));
        story.add(new Story(R.drawable.nissan, "Muslim"));
        story.add(new Story(R.drawable.birds, "Bek"));
        story.add(new Story(R.drawable.nissan, "Ali"));
        story.add(new Story(R.drawable.birds, "Salah"));
        story.add(new Story(R.drawable.nissan, "Messi"));
        story.add(new Story(R.drawable.birds, "Ronaldo"));
        story.add(new Story(R.drawable.nissan, "Neymar"));

        return story;
    }

    void getAdapter1(ArrayList<Post> stories){
        PostsAdapter storiesadapter = new PostsAdapter(this, stories);
        recyclerView.setAdapter(storiesadapter);
    }

    ArrayList<Post> getData1(){
        ArrayList<Post> story  = new ArrayList<>();

        story.add(new Post(R.drawable.nissan, "Abbos"));
        story.add(new Post(R.drawable.birds, "Messi"));
        story.add(new Post(R.drawable.nissan, "Benzama"));
        story.add(new Post(R.drawable.birds, "Assensio"));
        story.add(new Post(R.drawable.nissan, "Abbos"));
        story.add(new Post(R.drawable.birds, "Messi"));
        story.add(new Post(R.drawable.nissan, "Benzama"));
        story.add(new Post(R.drawable.birds, "Assensio"));

        return story;
    }
}