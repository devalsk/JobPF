package com.example.devsk.jobpf;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter{

     private final List<Fragment> fragmentsList = new ArrayList<>();
     private final List<String>   ListStr =  new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return  fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return ListStr.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ListStr.get(position);
    }


    public  void addFragment(Fragment fragment,String title){

        fragmentsList.add(fragment);
        ListStr.add(title);

    }
}
