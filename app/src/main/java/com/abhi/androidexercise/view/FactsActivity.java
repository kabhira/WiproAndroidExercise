package com.abhi.androidexercise.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.abhi.androidexercise.R;
import com.abhi.androidexercise.utilities.FragmentTransactionHelper;

public class FactsActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);
        fragmentManager = getSupportFragmentManager();
        FragmentTransactionHelper.switchFragment(this, R.id.content, FactsFragment.newInstance());
    }

    @Override
    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
            return;
        }

        super.onBackPressed();
    }
}
