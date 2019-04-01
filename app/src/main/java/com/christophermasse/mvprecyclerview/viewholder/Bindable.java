package com.christophermasse.mvprecyclerview.viewholder;

import androidx.annotation.NonNull;

/**
 * Interface providing abstraction layer over Android framework components like Recycler.ViewHolder
 */

public interface Bindable {

    /**
     * Interface to be implemented by the ViewHolder. This provides a layer of abstraction over Android framework as
     * the Presenter does not have to receive a RecyclerView.Viewholder object
     *
     */
    interface Viewholder<T>{

        int DOG_VH = 1; // Item type for Dog ViewHolder

        int CAT_VH = 2; // Item type for Cat ViewHolder

        /**
         *
         * @param item data/parameters to be passed to the ViewHolder
         */
        void bindItem(T item);
    }


    /**
     * To be implemented by the Presenter within the MVP in order to manage data binding and viewType
     */

    interface Presenter<V extends Viewholder>{

        /**
         * Method called by adapter to apply data to ViewHolder
         *
         * @param pos pos of viewholder within the collection of displayed items
         * @param viewholder viewholder object to be bound by the presenter
         */
        void onBind(int pos, @NonNull V viewholder);

        /**
         *
         * @return number of items within the collection; corresponds to RecyclerView getItemCount()
         */

        int getItemCount();

        /**
         *
         * @param pos position of viewholder/item within the collection
         * @return unique integer representing type of ViewHolder (e.g. {@link Viewholder#DOG_VH})
         */
        int getItemViewType(int pos);
    }
}
