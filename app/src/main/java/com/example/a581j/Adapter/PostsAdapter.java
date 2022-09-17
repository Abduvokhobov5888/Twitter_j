package com.example.a581j.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a581j.Models.Post;
import com.example.a581j.Models.Story;
import com.example.a581j.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<Post> items;

    public PostsAdapter(Context context, ArrayList<Post> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts, parent, false);

        return new StoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post story = items.get(position);

        if (holder instanceof StoriesViewHolder){
            VideoView p_image = ((StoriesViewHolder) holder).p_image;
            MediaController mediaController = new MediaController(this);
            mediaController.setMediaPlayer(p_image);
            p_image.setMediaController(mediaController);

            ((StoriesViewHolder) holder).p_text.setText(story.p_text);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class StoriesViewHolder extends RecyclerView.ViewHolder{

        VideoView p_image;
        TextView p_text;
        public StoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            p_image = itemView.findViewById(R.id.p_image);
            p_text = itemView.findViewById(R.id.p_text);
        }
    }
}
