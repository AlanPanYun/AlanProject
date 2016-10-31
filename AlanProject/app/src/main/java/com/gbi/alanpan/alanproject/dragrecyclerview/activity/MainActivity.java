package com.gbi.alanpan.alanproject.dragrecyclerview.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gbi.alanpan.alanproject.R;
import com.gbi.alanpan.alanproject.dragrecyclerview.fragment.MainFragment;
import com.gbi.alanpan.alanproject.dragrecyclerview.fragment.MyGridFragment;
import com.gbi.alanpan.alanproject.dragrecyclerview.fragment.MyListFragment;


public class MainActivity
        extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment, mainFragment)
                    .commit();
        }
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.list:
                fragment = new MyListFragment();
                break;
            case R.id.grid:
                fragment = new MyGridFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}
