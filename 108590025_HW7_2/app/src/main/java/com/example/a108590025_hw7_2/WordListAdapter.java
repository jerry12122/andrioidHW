package com.example.a108590025_hw7_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final LinkedList<String> foods;
    private final LinkedList<String> desc;
    private LayoutInflater mInflater;
    public static final String EXTRA_MESSAGE = "extra.MESSAGE";
    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.wordlist_item,parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String mCurrentName = foods.get(position);
        String mCurrentDesc = desc.get(position);
        holder.wordItemView.setText(mCurrentName);
        holder.wordItemView2.setText(mCurrentDesc);
    }

    public WordListAdapter(Context context, LinkedList<String> foods, LinkedList<String> desc) {
        mInflater = LayoutInflater.from(context);
        this.foods = foods;
        this.desc = desc;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        public final TextView wordItemView2;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.title);
            wordItemView2 = itemView.findViewById(R.id.describe);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            Intent intent = new Intent(v.getContext(), recipe.class);
            intent.putExtra(EXTRA_MESSAGE,mPosition);
            v.getContext().startActivity(intent);
        }
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }
}
