package com.christophermasse.mvprecyclerview;

/**
 * Contract representing responsibilities within a Model-View-Presenter pattern
 */
public interface PetListMvp {

    /**
     * Interface representing a View within MVP pattern. In this instance, it represents a list of Pet objects
     */
    interface View{
        boolean isActive();

        void showList();

        void showToastShort(String message);
    }

    /**
     * Interface representing presenter within MVP patter. Will handle events from UI and receive data from repo
     */

    interface Presenter<T extends View>{

        void setView(T view);

        void resume();

        void pause();

        void destroy();
    }
}
