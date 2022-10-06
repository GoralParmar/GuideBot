package com.example.guidebot.Helper;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.guidebot.BuildConfig;
import com.example.guidebot.Fragment.side_menu;
import com.example.guidebot.Interface.NavigationManager;
import com.example.guidebot.MainActivity;
import com.example.guidebot.R;

public class FragmentNavigation implements NavigationManager {
    private  static FragmentNavigation mInstance;
    private FragmentManager mFragmentManager;
    private MainActivity mainActivity;

    public static  FragmentNavigation getInstance(MainActivity mainActivity)
    {
        if (mInstance == null)
            mInstance = new FragmentNavigation();
        mInstance.configure(mainActivity);
        return mInstance;
    }

    private void configure(MainActivity mainActivity) {
        mainActivity = mainActivity;
        mFragmentManager = mainActivity.getSupportFragmentManager();


    }
    @Override
    public void  showFragment(String name){
        showFragment(side_menu.newInstance(name),false);



    }
    public void showFragment(Fragment fragment,boolean b){

        FragmentManager fm = mFragmentManager;
        FragmentTransaction ft = fm.beginTransaction().replace(R.id.controller,fragment);
        ft.addToBackStack(null);
        if(b|| !BuildConfig.DEBUG) ft.commit();
        else
            ft.commit(); fm.executePendingTransactions();

    }


}
