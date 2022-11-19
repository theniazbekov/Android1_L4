package com.example.android1_l4.model;

import java.io.Serializable;

public class CharacterModel implements Serializable {
    private String imageUrl;
    private String name;
    private int age;


    public CharacterModel(String imageUrl, String name, int age) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
