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

public class PetListAdapter extends RecyclerView.Adapter {

    private final Bindable.Presenter mPresenter;

    public PetListAdapter(Bindable.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView;
        switch (viewType){
            case DogRecyclerVh.DOG_VH:
                itemView = inflater.inflate(R.layout.vh_dog, parent, false);;
                return new DogRecyclerVh(itemView, mPresenter);
            case DogRecyclerVh.CAT_VH:
                itemView = inflater.inflate(R.layout.vh_cat, parent, false);;
                return new CatRecyclerVh(itemView, mPresenter);
            default:
                throw new ClassCastException("No viewholder supported for viewType of " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Bindable.Viewholder){
            mPresenter.onBind(position, (Bindable.Viewholder) holder);
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
