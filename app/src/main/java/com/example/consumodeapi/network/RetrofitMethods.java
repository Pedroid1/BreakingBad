package com.example.consumodeapi.network;

import com.example.consumodeapi.model.Character;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitMethods {

    @GET("characters")
    Call<List<Character>> getCharacters();

    @GET("characters/{id}")
    Call<Character[]> getCharacterById(@Path("id") Integer id);


}
