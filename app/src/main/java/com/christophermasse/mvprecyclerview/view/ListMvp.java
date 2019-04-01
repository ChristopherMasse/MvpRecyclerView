package com.christophermasse.mvprecyclerview.view;

public interface ListMvp {

    interface View{
        boolean isActive();
    }


    interface Presenter<T extends View>{

        void setView(T view);

        void resume();

        void pause();

        void destroy();
    }



}
