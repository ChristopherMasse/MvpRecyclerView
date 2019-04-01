package com.christophermasse.mvprecyclerview.view.recycler;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.christophermasse.mvprecyclerview.viewholder.ItemClickListener;
import com.christophermasse.mvprecyclerview.viewholder.Bindable;

/**
 * Optional decorated ViewHolder class to ensure that the Bindable. Presenter is included during construction
 *
 */
public abstract class BasicRecyclerVh extends RecyclerView.ViewHolder {

    private final Bindable.Presenter mPresenter;

    private static final boolean FORCE_ITEM_CLICK_LISTENER = true;

    /**
     *
     * @param itemView Android View object inflated by adapter
     * @param mPresenter Presenter in MVP architecture that will handle view binding
     */
    public BasicRecyclerVh(@NonNull View itemView, @NonNull final Bindable.Presenter mPresenter) {
        super(itemView);
        if (mPresenter == null) {
            throw new NullPointerException("Null instance of " + Bindable.Presenter.class.getSimpleName() +
                    " passed to ViewHolder constructor");
        }

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
        this.mPresenter = mPresenter;
    }
}

