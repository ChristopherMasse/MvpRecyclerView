package com.christophermasse.mvprecyclerview.viewholder;

import com.christophermasse.mvprecyclerview.model.entity.Dog;


/**
 * Bindable ViewHolder that will bind objects of {@link Dog} to its concrete implementation via the
 * {@link Bindable.Viewholder#bindItem(Object)} method.
 *
 * Instead of passing the model object directly to the ViewHolder, custom classes can be used to pass binding data to
 * the ViewHolder as seen in {@link CatViewHolder.Params}
 *
 */
public interface DogViewHolder extends Bindable.Viewholder<Dog>{

    int ITEM_TYPE = Bindable.Viewholder.DOG_VH;

    /**
     * Listener to be implemented by the presenter in order receive events from the
     */

    interface DogEventListener {

        void clickDogSpeak(int pos);
    }
}
