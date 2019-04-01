package com.christophermasse.mvprecyclerview.view.recycler.vh_impl;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.christophermasse.mvprecyclerview.R;
import com.christophermasse.mvprecyclerview.model.entity.Dog;
import com.christophermasse.mvprecyclerview.view.recycler.BasicRecyclerVh;
import com.christophermasse.mvprecyclerview.viewholder.Bindable;
import com.christophermasse.mvprecyclerview.viewholder.DogViewHolder;


/**
 * Concrete implementation of the {@link DogViewHolder}
 *
 * Displays basic information about the dog and a Paw icon image that can be clicked
 *
 */

public class DogRecyclerVh extends BasicRecyclerVh implements DogViewHolder {

    private TextView nameTextView;

    private TextView breedTextView;

    private TextView ageTextView;

    private TextView initials;

    private ImageView pawIcon;

    public DogRecyclerVh(@NonNull View itemView, final Bindable.Presenter presenter) {
        super(itemView, presenter);
        nameTextView = itemView.findViewById(R.id.name);
        breedTextView = itemView.findViewById(R.id.breed);
        ageTextView = itemView.findViewById(R.id.age);
        initials = itemView.findViewById(R.id.initials);
        pawIcon = itemView.findViewById(R.id.paw_icon);
        pawIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (presenter instanceof DogEventListener){
                    ((DogEventListener) presenter).clickDogSpeak(getAdapterPosition());
                }
            }
        });
    }

    /**
     * Apply object data to the ViewHolder
     *
     * @param dog POJO containing data to be used within ViewHolder
     */

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
}
