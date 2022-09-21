package com.example.a581j.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a581j.Models.Post;
import com.example.a581j.R;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.StoriesViewHolder> {
    Context context;
    List<Post> items;

    public PostsAdapter(Context context, List<Post> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public StoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts, parent, false);
        return new StoriesViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull StoriesViewHolder holder, int position) {
        Post story = items.get(position);
        holder.p_text.setText(story.text);
        holder.p_video.setVideoURI(Uri.parse("android.resource://" + context.getPackageName() + "/" + story.image));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class StoriesViewHolder extends RecyclerView.ViewHolder {
        VideoView p_video;
        TextView p_text;

        public StoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            p_video = itemView.findViewById(R.id.p_video);
            p_text = itemView.findViewById(R.id.p_text);

            itemView.setOnClickListener(v -> {
                if (p_video.isPlaying()) p_video.pause();
                else p_video.start();
            });
        }
    }
}
