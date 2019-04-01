package com.christophermasse.mvprecyclerview.viewholder;

/**
 * Simple listener interface used to provide Presenter with click events from RecyclerView rows
 */
public interface ItemClickListener {

    void itemClicked(int pos);
}
