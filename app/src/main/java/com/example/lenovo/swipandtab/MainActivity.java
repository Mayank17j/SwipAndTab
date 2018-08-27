package com.example.lenovo.swipandtab;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TabLayout myTabL;
    ViewPager myViewP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTabL = (TabLayout) findViewById(R.id.tabLayout);
        myViewP = (ViewPager) findViewById(R.id.viewPager);

        myViewP.setAdapter(new myOwnPagerAdapter(getSupportFragmentManager()));
        //Sync pager to the tab
        myTabL.setupWithViewPager(myViewP);
        //Listerner for the tab
        myTabL.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Transfer pager onTabSelected
                myViewP.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

         class myOwnPagerAdapter extends FragmentPagerAdapter {
             String data[]={"Java","Android","IOS"};
             public myOwnPagerAdapter(FragmentManager fm) {
                 super(fm);
             }

             //Fragment items
             @Override
             public Fragment getItem(int position) {
                 if(position==0)
                     return new Java(); //fragment
                 if (position==1)
                     return new Android();
                 if(position==2)
                     return new IOS();
                 return null;
             }

             //For lenth of the fragment
             @Override
             public int getCount() {
                 return data.length;
             }

             //Get title of the fragment and display
             @Override
             public CharSequence getPageTitle(int position) {
                 return data[position];
             }
         }


}
