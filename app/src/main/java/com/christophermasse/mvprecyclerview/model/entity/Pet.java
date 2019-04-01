package com.christophermasse.mvprecyclerview.model.entity;

import java.io.Serializable;

/**
 * Simple pojo to be used to form a list of objects that will be stored in the {@link com.christophermasse.mvprecyclerview.model.PetRepo}
 * repo and displayed within the RecyclerView
 */
public abstract class Pet implements Serializable {

    protected String name;

    private int age;

    private String breed;

    private int toyColor;

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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getToyColor() {
        return toyColor;
    }

    public void setToyColor(int toyColor) {
        this.toyColor = toyColor;
    }
}
