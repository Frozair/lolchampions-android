package com.newrdev.experimental.lolchampions.view;

/**
 * Created by rudolph on 5/15/17.
 */

public interface BaseContract {

    interface View {
    }

    interface Presenter<T> {
        void bind(T view);
        void unbind();
    }
}
