package com.newrdev.experimental.lolchampions.view.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.newrdev.experimental.lolchampions.R
import com.newrdev.experimental.lolchampions.view.home.champions.ChampionsFragment


class HomeActivity : AppCompatActivity() {
    private var championsFragment: ChampionsFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champions)

        if (null == savedInstanceState) {
            championsFragment = ChampionsFragment.newInstance()

            attachFragments()
        } else {
            championsFragment = supportFragmentManager.findFragmentByTag(TAG_CHAMPIONS_FRAGMENT) as ChampionsFragment
        }
    }


    private fun attachFragments() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        //        fragmentTransaction.replace(R.id.search_fragment, searchFragment, TAG_SEARCH_FRAGMENT);
        fragmentTransaction.replace(R.id.champions_fragment, championsFragment, TAG_CHAMPIONS_FRAGMENT)
        fragmentTransaction.commitAllowingStateLoss()
    }

    companion object {
        val TAG_CHAMPIONS_FRAGMENT = "champions_fragment"
    }
}
