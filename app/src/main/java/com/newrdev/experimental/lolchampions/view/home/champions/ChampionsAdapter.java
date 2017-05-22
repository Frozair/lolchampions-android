package com.newrdev.experimental.lolchampions.view.home.champions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.newrdev.experimental.lolchampions.R;
import com.newrdev.experimental.lolchampions.data.entity.Champion;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rudolph on 5/22/17.
 */

public class ChampionsAdapter extends RecyclerView.Adapter<ChampionsAdapter.ViewHolder> {
    private List<Champion> championList;

    public ChampionsAdapter(List<Champion> championList) {
        this.championList = championList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.champion, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Champion champion = championList.get(position);

        holder.name.setText(champion.getName());
    }

    @Override
    public int getItemCount() {
        return championList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.name)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
