package com.christophermasse.mvprecyclerview.view.recycler;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.christophermasse.mvprecyclerview.viewholder.ItemClickListener;
import com.christophermasse.mvprecyclerview.viewholder.Bindable;
import com.christophermasse.mvprecyclerview.view.recycler.vh_impl.CatRecyclerVh;
import com.christophermasse.mvprecyclerview.view.recycler.vh_impl.DogRecyclerVh;

/**
 * Optional decorated ViewHolder class to ensure that the {@link Bindable.Presenter} is included during construction
 * of ViewHolders and itemClick events are passed to the {@link Bindable.Presenter}.
 *
 * If viewholders {@link CatRecyclerVh} and {@link DogRecyclerVh} both include {@link Bindable.Presenter} in constructor
 * and implement {@link ItemClickListener} individually, they can be extended from {@link RecyclerView.ViewHolder}
 * directly instead
 *
 */

public abstract class BasicRecyclerVh extends RecyclerView.ViewHolder {

    private final Bindable.Presenter mPresenter;

    private static final boolean FORCE_ITEM_CLICK_LISTENER = true;

    /**
     *
     * @param itemView Android View object inflated by adapter
     * @param presenter Presenter in MVP architecture that will handle view binding
     */

    @SuppressWarnings("ConstantConditions")
    public BasicRecyclerVh(@NonNull View itemView, @NonNull final Bindable.Presenter presenter) {
        super(itemView);
        if (presenter == null) {
            throw new NullPointerException("Null instance of " + Bindable.Presenter.class.getSimpleName() +
                    " passed to ViewHolder constructor");
        }
        this.mPresenter = presenter;

        if (mPresenter instanceof ItemClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((ItemClickListener) mPresenter).itemClicked(getAdapterPosition());
                }
            });
        } else {
            if (FORCE_ITEM_CLICK_LISTENER) {
                throw new ClassCastException(Bindable.Presenter.class.getSimpleName()
                        + " passed to the Viewholder must implement " +
                        ItemClickListener.class.getSimpleName() + " in order to receive OnClick events");
            }
        }
    }
}

