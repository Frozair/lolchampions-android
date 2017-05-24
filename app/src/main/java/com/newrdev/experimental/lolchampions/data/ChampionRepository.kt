package com.newrdev.experimental.lolchampions.data

import com.newrdev.experimental.lolchampions.data.entity.Champion
import com.newrdev.experimental.lolchampions.data.entity.ChampionsResponse
import com.newrdev.experimental.lolchampions.data.net.Api
import io.reactivex.Single

/**
 * Created by rudolph on 5/18/17.
 */

class ChampionRepository : ChampionSource {

    override fun getAll(): Single<List<Champion>> {

        if (champions == null) {
            champions = Api.Client.getInstance()
                    .champions
                    .flatMapIterable { it.champions }
                    .toList()
        }

        return champions!!
    }

    companion object {
        private var champions: Single<List<Champion>>? = null
    }
}
