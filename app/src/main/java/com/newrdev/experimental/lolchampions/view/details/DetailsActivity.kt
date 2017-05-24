package com.newrdev.experimental.lolchampions.view.details

import android.app.Activity
import android.os.Bundle
import android.util.Log.println

import com.newrdev.experimental.lolchampions.data.entity.Champion

/**
 * Created by rudolph on 5/23/17.
 */

class DetailsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println(1, "DetailsActivity", "We in the oncreate")

        val b = this.intent.extras
        if (b != null) {
            val champion = b.getParcelable<Champion>("TEST")
            println(1, "DetailsActivity", "Champion in DetailsActivity: " + champion!!.name)
        }
    }
}
