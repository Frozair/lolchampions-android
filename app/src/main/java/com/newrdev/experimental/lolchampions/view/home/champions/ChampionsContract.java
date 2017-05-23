package com.newrdev.experimental.lolchampions.view.home.champions;

import com.newrdev.experimental.lolchampions.data.entity.Champion;
import com.newrdev.experimental.lolchampions.view.BaseContract;

import java.util.List;

/**
 * Created by rudolph on 5/18/17.
 */

public interface ChampionsContract {

    interface Presenter extends BaseContract.Presenter<View> {

        void getAllChampions();
    }

    interface View extends BaseContract.View {

        void showChampions(List<Champion> champions);

        void showChampionDetails(Champion champion);
    }
}
