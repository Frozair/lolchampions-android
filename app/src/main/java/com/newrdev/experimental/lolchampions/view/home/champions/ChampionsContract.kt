package com.newrdev.experimental.lolchampions.view.home.champions

import com.newrdev.experimental.lolchampions.data.entity.Champion
import com.newrdev.experimental.lolchampions.view.BaseContract

/**
 * Created by rudolph on 5/18/17.
 */

interface ChampionsContract {

    interface Presenter : BaseContract.Presenter<View> {

        fun getAllChampions()
    }

    interface View : BaseContract.View {

        fun showChampions(champions: List<Champion>)

        fun showChampionDetails(champion: Champion)
    }
}
