package com.christophermasse.mvprecyclerview.model.entity;

public abstract class Pet {

    protected String name;

    protected int age;

    protected String breed;

    protected int toyColor;

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
