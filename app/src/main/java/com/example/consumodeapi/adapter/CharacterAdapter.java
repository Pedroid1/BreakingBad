package com.example.consumodeapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.consumodeapi.BindingAdapter;
import com.example.consumodeapi.R;
import com.example.consumodeapi.model.Character;
import com.example.consumodeapi.ui.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.MyViewHolder> {

    private Context context;
    private List<Character> dataset;

    public CharacterAdapter(Context context, List<Character> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.character_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameTxt.setText(dataset.get(position).getName());
        holder.nicknameTxt.setText(dataset.get(position).getNickname());
        BindingAdapter.bindImage(holder.img, dataset.get(position).getImgUrl());

        holder.layout.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.ID_TAG, dataset.get(position).getId());
            intent.putExtra(DetailActivity.IMG_URL_TAG, dataset.get(position).getImgUrl());
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView nameTxt, nicknameTxt;
        ConstraintLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            nameTxt = itemView.findViewById(R.id.name_txt);
            nicknameTxt = itemView.findViewById(R.id.nickname_txt);
            layout = itemView.findViewById(R.id.main_layout);
        }
    }

}
