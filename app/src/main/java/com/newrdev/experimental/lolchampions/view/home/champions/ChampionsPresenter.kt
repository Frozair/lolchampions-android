package com.newrdev.experimental.lolchampions.view.home.champions

import android.util.Log.println
import com.newrdev.experimental.lolchampions.data.ChampionRepository
import com.newrdev.experimental.lolchampions.data.entity.Champion

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by rudolph on 5/18/17.
 */

class ChampionsPresenter : ChampionsContract.Presenter {
    private var view: ChampionsContract.View? = null
    private val repository: ChampionRepository

    init {
        repository = ChampionRepository()
    }

    override fun getAllChampions() {
        repository.all
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(Consumer<List<Champion>> { view!!.showChampions(it) }, Consumer<Throwable> { this.error(it) })
    }

    private fun error(error: Throwable) {
        println(1, "Presenter", "Error " + error.localizedMessage)
    }

    override fun bind(view: ChampionsContract.View) {
        this.view = view
    }

    override fun unbind() {
        if (view != null) {
            view = null
        }
    }
}
