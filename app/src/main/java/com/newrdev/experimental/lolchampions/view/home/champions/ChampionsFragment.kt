package com.newrdev.experimental.lolchampions.view.home.champions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager

import android.support.v7.widget.RecyclerView
import android.util.Log.println
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.newrdev.experimental.lolchampions.R
import com.newrdev.experimental.lolchampions.data.entity.Champion
import com.newrdev.experimental.lolchampions.view.details.DetailsActivity

/**
 * Created by rudolph on 5/18/17.
 */

class ChampionsFragment : Fragment(), ChampionsContract.View {
    private var presenter: ChampionsContract.Presenter? = null
    var recyclerView: RecyclerView? = null
    private var adapter: ChampionsAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_champions, container, false)

        recyclerView = view.findViewById(R.id.champions_list) as RecyclerView
        recyclerView?.setHasFixedSize(true)

        recyclerView?.layoutManager = GridLayoutManager(activity.baseContext, 2)

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        presenter!!.bind(this)
    }

    override fun onResume() {
        super.onResume()

        presenter!!.getAllChampions()
    }


    override fun showChampions(champions: List<Champion>) {
        if (adapter == null) {
            adapter = ChampionsAdapter(champions, this)
        } else {
            adapter!!.setChampions(champions)
            adapter!!.notifyDataSetChanged()
        }

        recyclerView?.adapter = adapter
    }

    override fun showChampionDetails(champion: Champion) {
        println(1, "ChampionsFragment", "Champion clicked: " + champion.name)

        val intent = Intent()
        intent.putExtra("TEST", champion)
        intent.setClass(activity, DetailsActivity::class.java)

        activity.startActivity(intent)
    }

    companion object {

        fun newInstance(): ChampionsFragment {

            val args = Bundle()

            val fragment = ChampionsFragment()
            fragment.presenter = ChampionsPresenter()

            fragment.arguments = args
            return fragment
        }
    }
}
