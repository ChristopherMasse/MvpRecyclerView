package com.christophermasse.mvprecyclerview.view;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.christophermasse.mvprecyclerview.R;

/**
 * Single fragment activity hosting {@link PetListFrag}
 */
public class PetListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_frag);
        initFrag();
    }

    void initFrag(){
        Fragment frag = PetListFrag.newInstance();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frame, frag).commit();
    }
}
