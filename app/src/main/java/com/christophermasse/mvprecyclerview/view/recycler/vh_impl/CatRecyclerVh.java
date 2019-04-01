package com.christophermasse.mvprecyclerview.view.recycler.vh_impl;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.christophermasse.mvprecyclerview.R;
import com.christophermasse.mvprecyclerview.viewholder.Bindable;
import com.christophermasse.mvprecyclerview.viewholder.CatViewHolder;

public class CatRecyclerVh extends BasicRecyclerVh implements CatViewHolder{

    private TextView nameTextView;

    private TextView breedTextView;

    private TextView ageTextView;

    private TextView initials;


    public CatRecyclerVh(@NonNull View itemView, @NonNull Bindable.Presenter mPresenter) {
        super(itemView, mPresenter);
        nameTextView = itemView.findViewById(R.id.name);
        breedTextView = itemView.findViewById(R.id.breed);
        ageTextView = itemView.findViewById(R.id.age);
        initials = itemView.findViewById(R.id.initials);
    }

    @Override
    public void bindItem(Params item) {
        nameTextView.setText(item.getName());
        String s = String.valueOf(item.getName().charAt(0));
        initials.setText(s);
        breedTextView.setText(item.getBreed());
        String ageText = String.valueOf(item.getAge()) + " YO";
        ageTextView.setText(ageText);
        initials.setBackgroundResource(item.getColor());
    }

}
