package com.christophermasse.mvprecyclerview.recycler.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.christophermasse.mvprecyclerview.R;
import com.christophermasse.mvprecyclerview.model.entity.Dog;
import com.christophermasse.mvprecyclerview.recycler.common.BasicViewholder;
import com.christophermasse.mvprecyclerview.recycler.common.Bindable;

public class DogRecyclerVh extends BasicViewholder implements Bindable.Viewholder<Dog> {

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
        ageTextView.setText(String.valueOf(dog.getAge()) + " YO");
        initials.setBackgroundResource(dog.getToyColor());
    }

    @Override
    public int getItemType() {
        return Bindable.Viewholder.DOG_VH;
    }
}
