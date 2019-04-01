package com.christophermasse.mvprecyclerview.viewholder;

import androidx.annotation.NonNull;

public interface Bindable {

    /**
     * Interface to be implemented by the ViewHolder
     *
     * @param <T> model/data to be bound to the ViewHolder
     */
    interface Viewholder<T>{

        int DOG_VH = 1;

        int CAT_VH = 2;

        void bindItem(T item);

        int getItemType();
    }


    /**
     * To be implemented by the Presenter within the MVP
     */

    interface Presenter{

        /**
         *
         * @param pos pos of viewHolder within the collection of displayed items
         * @param viewholder
         */
        void onBind(int pos, @NonNull Viewholder viewholder);

        /**
         *
         * @return number of items
         */

        int getItemCount();

        int getItemViewType(int pos);
    }
}
