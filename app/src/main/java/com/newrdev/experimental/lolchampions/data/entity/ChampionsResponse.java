package com.newrdev.experimental.lolchampions.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.Map;

/**
 * Created by rudolph on 5/17/17.
 */

public class ChampionsResponse {
    @SerializedName("data")
    private Map<String, Champion> champions;

    public Collection<Champion> getChampions() {
        return champions.values();
    }

    public void setChampions(Map<String, Champion> data) {
        champions = data;
    }
}