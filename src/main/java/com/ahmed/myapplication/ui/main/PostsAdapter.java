package com.ahmed.myapplication.ui.main;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmed.myapplication.R;
import com.ahmed.myapplication.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
    private List<PostModel> postsList = new ArrayList<>();

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new PostsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public void setList(List<PostModel> moviesList) {
        this.postsList = moviesList;
        notifyDataSetChanged();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {


        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
