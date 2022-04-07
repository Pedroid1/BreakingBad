package com.example.consumodeapi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.consumodeapi.R;
import com.example.consumodeapi.model.Character;
import com.example.consumodeapi.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String DEBUG_TAG = "MainActivity";

    private HomeViewModel viewModel;
    private RecyclerView recyclerView;

    private List<Character> characterList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        recyclerView = findViewById(R.id.character_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false));
        viewModel.getAllCharacters(recyclerView);
    }

}