package com.abhi.androidexercise.utilities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 *  Author: Abhiraj Khare
 *  Description: Class responsible to handle fragment transition and animations
 */

public class FragmentTransactionHelper {

    public static void switchFragment(FragmentActivity fragmentActivity, int resID, Fragment fragment) {

        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(resID, fragment).commit();

    }

    public static void addFragment(FragmentActivity fragmentActivity, int resID, Fragment fragment) {
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(resID, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
