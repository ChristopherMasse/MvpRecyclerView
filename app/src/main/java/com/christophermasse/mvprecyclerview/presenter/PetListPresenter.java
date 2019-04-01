package com.christophermasse.mvprecyclerview.presenter;

import androidx.annotation.NonNull;
import com.christophermasse.mvprecyclerview.PetListMvp;
import com.christophermasse.mvprecyclerview.model.PetRepo;
import com.christophermasse.mvprecyclerview.model.entity.Cat;
import com.christophermasse.mvprecyclerview.model.entity.Dog;
import com.christophermasse.mvprecyclerview.model.entity.Pet;
import com.christophermasse.mvprecyclerview.viewholder.Bindable;
import com.christophermasse.mvprecyclerview.viewholder.CatViewHolder;
import com.christophermasse.mvprecyclerview.viewholder.DogViewHolder;
import com.christophermasse.mvprecyclerview.viewholder.ItemClickListener;

import java.util.List;

/**
 * Presenter within Model-View-Presenter framework
 *
 * By interacting with interfaces for the {@link Bindable.Presenter} methods, it provides a level of abstraction over
 * the Android framework
 *
 */

public class PetListPresenter implements PetListMvp.Presenter, Bindable.Presenter<Bindable.Viewholder>, ItemClickListener,
        DogViewHolder.DogEventListener {

    private PetListMvp.View mView;

    private List<Pet> mPetList;

    /**
     *
     * @param view View within Mvp architecture, in this case a fragment
     */
    @Override
    public void setView(PetListMvp.View view) {
        this.mView = view;
    }

    @Override
    public void resume() {
        mPetList = PetRepo.getInstance().getPetList();
        getView().showList();
    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
    }


    /**
     *
     * @param pos pos of viewHolder within the collection of displayed items
     * @param vh ViewHolder that will receive data for binding/display purposes
     */
    @Override
    public void onBind(int pos, @NonNull Bindable.Viewholder vh) {
        Pet pet = mPetList.get(pos);

        if (vh instanceof DogViewHolder && pet instanceof Dog){
            DogViewHolder dogVh = (DogViewHolder) vh;
            dogVh.bindItem((Dog) pet);
        }

        if (vh instanceof CatViewHolder && pet instanceof Cat){
            CatViewHolder catVh = (CatViewHolder) vh;
            CatViewHolder.Params params = new CatViewHolder.Params(pet.getName(),
                    pet.getBreed(), pet.getAge(), pet.getToyColor());
            catVh.bindItem(params);
        }
    }

    /**
     *
     * @return the number of items within our displayed collection (e.g. RecyclerView) corresponds to getItemCount()
     * within RecyclerView
     */
    @Override
    public int getItemCount() {
        return mPetList.size();
    }

    @Override
    public int getItemViewType(int pos) {
        Pet pet = mPetList.get(pos);
        if (pet instanceof Dog) {
            return DogViewHolder.ITEM_TYPE;
        } else return CatViewHolder.ITEM_TYPE;
    }

    /**
     * Event listener implemented from {@link ItemClickListener} in order to provide Presenter with click events from
     * the viewholders.
     *
     * @param pos within the adapter, corresponds to position within {@link PetListPresenter#mPetList}
     */
    @Override
    public void itemClicked(int pos) {
        Pet pet = mPetList.get(pos);
        String type;
        if (pet instanceof Dog){
            type = "dog";
        } else {
            type = "cat";
        }
        String msg = "Pos: " + String.valueOf(pos) + " Type: " + type + " Name: " + pet.getName() + " Age: " + pet.getAge();
        getView().showToastShort(msg);
    }

    /**
     * Convenience method for interacting with View
     * @return View within Mvp (in this example a fragment)
     */

    private PetListMvp.View getView() {
        return this.mView;
    }


    /**
     * Implementation of {@link DogViewHolder.DogEventListener#clickDogSpeak(int)}
     *
     * @param pos position within adapter
     */
    @Override
    public void clickDogSpeak(int pos) {
        Pet pet = mPetList.get(pos);
        String msg = pet.getName() + " says Woof!";
        getView().showToastShort(msg);
    }
}
