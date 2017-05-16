package com.newrdev.experimental.lolchampions.view;

/**
 * Created by rudolph on 5/15/17.
 */

public interface BaseContract {

    interface View<T> {
        void setPresenter(T presenter);
    }

    interface Presenter {

    }
}
