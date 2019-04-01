package com.christophermasse.mvprecyclerview;

public interface PetListMvp {

    interface View{
        boolean isActive();

        void showList();

        void showToastShort(String message);
    }

    interface Presenter<T extends View>{

        void setView(T view);

        void resume();

        void pause();

        void destroy();
    }
}
