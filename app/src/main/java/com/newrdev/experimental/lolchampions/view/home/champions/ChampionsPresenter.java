package com.newrdev.experimental.lolchampions.view.home.champions;

import com.newrdev.experimental.lolchampions.data.ChampionRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rudolph on 5/18/17.
 */

public class ChampionsPresenter implements ChampionsContract.Presenter {
    private ChampionsContract.View view;
    private ChampionRepository repository;

    public ChampionsPresenter() {
        repository = new ChampionRepository();
    }

    @Override
    public void getAllChampions() {
        repository.getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(view::showChampions, this::error);
    }

    private void error(Throwable error) {
        System.out.println("Error "+error.getLocalizedMessage());
    }

    @Override
    public void bind(ChampionsContract.View view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        if (view != null) {
            view = null;
        }
    }
}
