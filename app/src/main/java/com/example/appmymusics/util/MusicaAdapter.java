package com.example.appmymusics.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmymusics.db.bean.Musica;

import java.util.List;

public class MusicaAdapter extends RecyclerView.Adapter<MusicaAdapter.MusicaViewHolder> {
    private final List<Musica> musicaList;

    public MusicaAdapter(List<Musica> musicaList) {
        this.musicaList = musicaList;
    }

    @NonNull
    @Override
    public MusicaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new MusicaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicaViewHolder holder, int position) {
        Musica musica = musicaList.get(position);
        holder.textView.setText(musica.toString());
    }

    @Override
    public int getItemCount() {
        return musicaList.size();
    }

    public void removeItem(int position) {
        musicaList.remove(position);
        notifyItemRemoved(position);
    }

    static class MusicaViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MusicaViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}