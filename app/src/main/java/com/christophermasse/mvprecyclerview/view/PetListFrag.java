package com.christophermasse.mvprecyclerview.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.christophermasse.mvprecyclerview.PetListMvp;
import com.christophermasse.mvprecyclerview.R;
import com.christophermasse.mvprecyclerview.presenter.PetListPresenter;
import com.christophermasse.mvprecyclerview.view.recycler.PetListAdapter;

public class PetListFrag extends Fragment implements PetListMvp.View {

    private RecyclerView mRecyclerView;

    private PetListPresenter mPresenter;

    public static PetListFrag newInstance() {
        Bundle args = new Bundle();
        PetListFrag fragment = new PetListFrag();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_recycler_view, container, false);
        mRecyclerView = root.findViewById(R.id.recycler_view);

        //Initialize the mPresenter
        mPresenter = new PetListPresenter();
        mPresenter.setView(this);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    public boolean isActive() {
        return isAdded() && isVisible();
    }

    @Override
    public void showList() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new PetListAdapter(mPresenter));
    }

    @Override
    public void showToastShort(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
