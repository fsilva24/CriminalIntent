package com.example.felig.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by felig on 2/15/2018.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
