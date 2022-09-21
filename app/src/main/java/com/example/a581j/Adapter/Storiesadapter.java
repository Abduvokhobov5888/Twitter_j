package com.example.a581j.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a581j.Models.Story;
import com.example.a581j.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class Storiesadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Story> items;

    public Storiesadapter(Context context, List<Story> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stories, parent, false);

        return new StoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Story story = items.get(position);

        if (holder instanceof StoriesViewHolder){
            Glide.with(context).load(story.image).into(((StoriesViewHolder) holder).s_image);
            ((StoriesViewHolder) holder).s_text.setText(story.text);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class StoriesViewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView s_image;
        TextView s_text;
        public StoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            s_image = itemView.findViewById(R.id.s_image);
            s_text = itemView.findViewById(R.id.s_text);
        }
    }
}
