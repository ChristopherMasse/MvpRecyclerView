package com.christophermasse.mvprecyclerview.viewholder;

import com.christophermasse.mvprecyclerview.model.entity.Cat;

/**
 * Bindable ViewHolder that will bind objects of {@link Cat} to its concrete implementation.
 *
 * In order to separate the ViewHolder from the {@link Cat} model, a custom {@link Params} class is used to pass the
 * relevant data to the ViewHolder via the {@link Bindable.Viewholder#bindItem(Object)} method
 *
 */
public interface CatViewHolder extends Bindable.Viewholder<CatViewHolder.Params>{

    int ITEM_TYPE = Bindable.Viewholder.CAT_VH;

    /**
     * Data provided to the ViewHolder via {@link Bindable.Viewholder#bindItem(Object)}
     */
    class Params{

        String name;

        String breed;

        int age;

        int color;

        public Params(String name, String breed, int age, int color) {
            this.name = name;
            this.breed = breed;
            this.age = age;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public String getBreed() {
            return breed;
        }

        public int getAge() {
            return age;
        }

        public int getColor() {
            return color;
        }
    }
}
