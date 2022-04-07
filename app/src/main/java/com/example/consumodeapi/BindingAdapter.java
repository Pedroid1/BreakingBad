package com.example.consumodeapi;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BindingAdapter {

    public static void bindImage(ImageView imgView, String imgUrl) {
        Picasso.get().load(imgUrl).into(imgView);
    }
}
