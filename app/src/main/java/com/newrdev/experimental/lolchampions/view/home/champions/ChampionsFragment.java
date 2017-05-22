package com.newrdev.experimental.lolchampions.view.home.champions;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newrdev.experimental.lolchampions.R;
import com.newrdev.experimental.lolchampions.data.entity.Champion;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rudolph on 5/18/17.
 */

public class ChampionsFragment extends Fragment implements ChampionsContract.View {
    private ChampionsContract.Presenter presenter;
    @BindView(R.id.champions_list)
    RecyclerView recyclerView;
    private ChampionsAdapter adapter;

    public static ChampionsFragment newInstance() {

        Bundle args = new Bundle();

        ChampionsFragment fragment = new ChampionsFragment();
        fragment.presenter = new ChampionsPresenter();

        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_champions, container, false);

        ButterKnife.bind(this, view);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        presenter.bind(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.getAllChampions();
    }


    @Override
    public void showChampions(List<Champion> champions) {
        if (adapter == null) {
            adapter = new ChampionsAdapter(champions);
        }

        recyclerView.setAdapter(adapter);
        System.out.println("Showing champs?");
    }
}
