package com.example.consumodeapi.model;

import com.google.gson.annotations.SerializedName;

public class Character {

    @SerializedName("char_id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("img")
    private String imgUrl;

    @SerializedName("status")
    private String status;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("portrayed")
    private String portrayed;

    public Character(String name) {
        this.name = name;
    }

    public Character(Integer id, String name, String birthday, String imgUrl, String status, String nickname, String portrayed) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.imgUrl = imgUrl;
        this.status = status;
        this.nickname = nickname;
        this.portrayed = portrayed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPortrayed() {
        return portrayed;
    }

    public void setPortrayed(String portrayed) {
        this.portrayed = portrayed;
    }
}
