package com.example.a581j.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
            VideoView videoView = ((StoriesViewHolder)holder).p_video;

            MediaController mediaController = new MediaController(context);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(Uri.parse("android.resource://" + context.getPackageName() + "/" +
                    R.raw.video));
            videoView.start();

            ((StoriesViewHolder)holder).p_text.setText(story.p_text);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class StoriesViewHolder extends RecyclerView.ViewHolder{

        VideoView p_video;
        TextView p_text;
        public StoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            p_video = itemView.findViewById(R.id.p_video);
            p_text = itemView.findViewById(R.id.p_text);
        }
    }
}
