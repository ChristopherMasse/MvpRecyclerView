package com.christophermasse.mvprecyclerview.view.recycler.vh_impl;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.christophermasse.mvprecyclerview.R;
import com.christophermasse.mvprecyclerview.model.entity.Dog;
import com.christophermasse.mvprecyclerview.view.recycler.BasicRecyclerVh;
import com.christophermasse.mvprecyclerview.viewholder.Bindable;

public class DogRecyclerVh extends BasicRecyclerVh implements Bindable.Viewholder<Dog> {

    private TextView nameTextView;

    private TextView breedTextView;

    private TextView ageTextView;

    private TextView initials;

    public DogRecyclerVh(@NonNull View itemView, Bindable.Presenter presenter) {
        super(itemView, presenter);
        nameTextView = itemView.findViewById(R.id.name);
        breedTextView = itemView.findViewById(R.id.breed);
        ageTextView = itemView.findViewById(R.id.age);
        initials = itemView.findViewById(R.id.initials);
    }

    @Override
    public void bindItem(Dog dog) {
        nameTextView.setText(dog.getName());
        String s = String.valueOf(dog.getName().charAt(0));
        initials.setText(s);
        breedTextView.setText(dog.getBreed());
        String ageText = String.valueOf(dog.getAge()) + " YO";
        ageTextView.setText(ageText);
        initials.setBackgroundResource(dog.getToyColor());
    }

    @Override
    public int getItemType() {
        return Bindable.Viewholder.DOG_VH;
    }
}
