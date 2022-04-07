package com.example.consumodeapi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.consumodeapi.BindingAdapter;
import com.example.consumodeapi.R;
import com.example.consumodeapi.databinding.ActivityDetailBinding;
import com.example.consumodeapi.model.Character;
import com.example.consumodeapi.viewmodel.HomeViewModel;

public class DetailActivity extends AppCompatActivity {

    public static final String ID_TAG = "ID";
    public static final String IMG_URL_TAG = "IMG_URL";

    private HomeViewModel viewModel;
    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        Intent intent = getIntent();
        Integer id = intent.getIntExtra(ID_TAG, -1);
        String imgUrl = intent.getStringExtra(IMG_URL_TAG);

        if(id != -1) {
            viewModel.getCharacterById(id);
            BindingAdapter.bindImage(binding.img, imgUrl);
        } else {
            Toast.makeText(this, "Erro inesperado", Toast.LENGTH_SHORT).show();
        }

        viewModel.clickedCharacter.observe(this, character -> {
            binding.authorTxt.setText(character.getPortrayed());
            binding.birthdayTxt.setText(character.getBirthday());
            binding.nameTxt.setText(character.getName());
            binding.nicknameTxt.setText(character.getNickname());
            binding.statusTxt.setText(character.getStatus());
        });
    }
}