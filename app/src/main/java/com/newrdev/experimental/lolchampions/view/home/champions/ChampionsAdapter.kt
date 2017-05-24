package com.newrdev.experimental.lolchampions.view.home.champions

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.bindView

import com.newrdev.experimental.lolchampions.R
import com.newrdev.experimental.lolchampions.data.entity.Champion
import com.newrdev.experimental.lolchampions.util.Constants
import com.squareup.picasso.Picasso


/**
 * Created by rudolph on 5/22/17.
 */

class ChampionsAdapter(private var championList: List<Champion>?, private val championsView: ChampionsContract.View) : RecyclerView.Adapter<ChampionsAdapter.ViewHolder>() {

    fun setChampions(championList: List<Champion>) {
        this.championList = championList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.champion, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val champion = championList!![position]

        holder.name.text = champion.name

        Picasso.with(holder.image.context)
                .load(Constants.CHAMPION_IMAGE_URL + champion.image.full)
                .into(holder.image)

        holder.setChampion(champion)
    }

    override fun getItemCount(): Int {
        return championList!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal val image: ImageView by bindView(R.id.image)
        internal val name: TextView by bindView(R.id.name)

        private var champion: Champion? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun setChampion(champion: Champion) {
            this.champion = champion
        }

        override fun onClick(v: View) {
            this@ChampionsAdapter.championsView.showChampionDetails(champion!!)
        }
    }
}
