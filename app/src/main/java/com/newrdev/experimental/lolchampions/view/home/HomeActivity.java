package com.newrdev.experimental.lolchampions.view.home;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.newrdev.experimental.lolchampions.R;
import com.newrdev.experimental.lolchampions.view.home.champions.ChampionsFragment;
import com.newrdev.experimental.lolchampions.view.home.champions.ChampionsPresenter;

import butterknife.ButterKnife;


public class HomeActivity extends AppCompatActivity {
    public static final String TAG_CHAMPIONS_FRAGMENT = "champions_fragment";
    private ChampionsFragment championsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champions);

        ButterKnife.bind(this);

        if (null == savedInstanceState) {
            championsFragment = ChampionsFragment.newInstance();

            attachFragments();
        } else {
            championsFragment = (ChampionsFragment) getSupportFragmentManager().findFragmentByTag(TAG_CHAMPIONS_FRAGMENT);
        }
    }


    private void attachFragments() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.search_fragment, searchFragment, TAG_SEARCH_FRAGMENT);
        fragmentTransaction.replace(R.id.champions_fragment, championsFragment, TAG_CHAMPIONS_FRAGMENT);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
