package com.example.consumodeapi.viewmodel;

import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.consumodeapi.BindingAdapter;
import com.example.consumodeapi.adapter.CharacterAdapter;
import com.example.consumodeapi.model.Character;
import com.example.consumodeapi.network.RetrofitAPI;
import com.example.consumodeapi.network.RetrofitMethods;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {
    private final String DEBUG_TAG = "HomeViewModel";

    private List<Character> characterList = new ArrayList<>();

    private MutableLiveData<Character> _clickedCharacter = new MutableLiveData<>();
    public LiveData<Character> clickedCharacter = _clickedCharacter;

    public void getAllCharacters(RecyclerView recyclerView) {
        RetrofitMethods methods = RetrofitAPI.getRetrofitInstance().create(RetrofitMethods.class);
        Call<List<Character>> data = methods.getCharacters();

        data.enqueue(new Callback<List<Character>>() {
            @Override
            public void onResponse(Call<List<Character>> call, Response<List<Character>> response) {
                if (response.isSuccessful()) {
                    characterList = response.body();
                    CharacterAdapter adapter = new CharacterAdapter(recyclerView.getContext(), characterList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Character>> call, Throwable t) {
                Log.d(DEBUG_TAG, t.getCause().toString());
            }
        });
    }

    public void getCharacterById(Integer id) {
        RetrofitMethods methods = RetrofitAPI.getRetrofitInstance().create(RetrofitMethods.class);
        Call<Character[]> data = methods.getCharacterById(id);

        data.enqueue(new Callback<Character[]>() {
            @Override
            public void onResponse(Call<Character[]> call, Response<Character[]> response) {
                if(response.isSuccessful()) {
                    Character[] character = response.body();
                    if (character != null) {
                        _clickedCharacter.setValue(character[0]);
                    }
                }
            }

            @Override
            public void onFailure(Call<Character[]> call, Throwable t) {
                Log.d(DEBUG_TAG, t.getCause().toString());
            }
        });
    }
}
