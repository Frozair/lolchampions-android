package com.newrdev.experimental.lolchampions.data;

import com.newrdev.experimental.lolchampions.data.entity.Champion;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by rudolph on 5/15/17.
 */

public interface ChampionSource {
    Single<List<Champion>> getAll();
}
