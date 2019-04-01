package com.christophermasse.mvprecyclerview.view.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.christophermasse.mvprecyclerview.R;
import com.christophermasse.mvprecyclerview.view.recycler.vh_impl.CatRecyclerVh;
import com.christophermasse.mvprecyclerview.view.recycler.vh_impl.DogRecyclerVh;
import com.christophermasse.mvprecyclerview.viewholder.Bindable;
import com.christophermasse.mvprecyclerview.viewholder.CatViewHolder;
import com.christophermasse.mvprecyclerview.viewholder.DogViewHolder;

/**
 * RecyclerView adapter that will create ViewHolders and delegate binding, viewType retrieval and getItemCount to
 * the presenter
 */

public class PetListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Bindable.Presenter mPresenter;

    public PetListAdapter(@NonNull Bindable.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView;
        switch (viewType){
            case DogViewHolder.ITEM_TYPE:
                itemView = inflater.inflate(R.layout.vh_dog, parent, false);
                return new DogRecyclerVh(itemView, mPresenter);
            case CatViewHolder.ITEM_TYPE:
                itemView = inflater.inflate(R.layout.vh_cat, parent, false);
                return new CatRecyclerVh(itemView, mPresenter);
            default:
                throw new ClassCastException("No viewholder supported for viewType of " + viewType);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Bindable.Viewholder){
            mPresenter.onBind(position, (Bindable.Viewholder) holder);
        } else {
            throw new ClassCastException("Cannot bind a viewholder that does not implement "
                    + Bindable.Viewholder.class.getSimpleName());
        }
    }

    @Override
    public int getItemCount() {
        return mPresenter.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        return mPresenter.getItemViewType(position);
    }
}
