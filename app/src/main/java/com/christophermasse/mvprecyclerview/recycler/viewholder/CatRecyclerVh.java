package com.christophermasse.mvprecyclerview.recycler.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.christophermasse.mvprecyclerview.R;
import com.christophermasse.mvprecyclerview.model.entity.Cat;
import com.christophermasse.mvprecyclerview.recycler.common.BasicViewholder;
import com.christophermasse.mvprecyclerview.recycler.common.Bindable;

public class CatRecyclerVh extends BasicViewholder implements Bindable.Viewholder<Cat> {

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
    public void bindItem(Cat cat) {
        nameTextView.setText(cat.getName());
        String s = String.valueOf(cat.getName().charAt(0));
        initials.setText(s);
        breedTextView.setText(cat.getBreed());
        ageTextView.setText(String.valueOf(cat.getAge()) + " YO");
        initials.setBackgroundResource(cat.getToyColor());
    }

    @Override
    public int getItemType() {
        return CAT_VH;
    }
}