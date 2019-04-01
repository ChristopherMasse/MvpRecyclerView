package com.christophermasse.mvprecyclerview.presenter;

import androidx.annotation.NonNull;
import com.christophermasse.mvprecyclerview.PetListMvp;
import com.christophermasse.mvprecyclerview.model.PetRepo;
import com.christophermasse.mvprecyclerview.model.entity.Dog;
import com.christophermasse.mvprecyclerview.model.entity.Pet;
import com.christophermasse.mvprecyclerview.viewholder.ItemClickListener;
import com.christophermasse.mvprecyclerview.viewholder.Bindable;

import java.util.List;

import static com.christophermasse.mvprecyclerview.viewholder.Bindable.Viewholder.CAT_VH;
import static com.christophermasse.mvprecyclerview.viewholder.Bindable.Viewholder.DOG_VH;

public class PetListPresenter implements PetListMvp.Presenter, Bindable.Presenter, ItemClickListener {

    private PetListMvp.View mView;

    private List<Pet> mPetList;

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

    @Override
    public void onBind(int pos, @NonNull Bindable.Viewholder viewholder) {

        Pet pet = mPetList.get(pos);
        switch (viewholder.getItemType()){
            default:
                viewholder.bindItem(mPetList.get(pos));
        }
    }


    /**
     *
     * @return the number of items to show within our RecyclerView
     */
    @Override
    public int getItemCount() {
        return mPetList.size();
    }

    @Override
    public int getItemViewType(int pos) {
        Pet pet = mPetList.get(pos);
        if (pet instanceof Dog) {
            return DOG_VH;
        } else return CAT_VH;
    }

    /**
     * Event listener implemented from {@link ItemClickListener} in order to provide Presenter with click events from
     * the viewholders.
     *
     * @param pos within the adapter, corresponds to position within {@link PetListPresenter#mPetList}
     */
    @Override
    public void itemClicked(int pos) {
        getView().showToastShort("You clicked on number " + pos);
    }


    private PetListMvp.View getView() {
        return this.mView;
    }
}
