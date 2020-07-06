package com.navjot.android2020_38;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.navjot.android2020_38.fragments.Fragment1;
import com.navjot.android2020_38.fragments.Fragment2;
import com.navjot.android2020_38.fragments.Fragment3;

public class MainActivity extends AppCompatActivity {

    private final static int id_home = 1;
    private final static int id_login = 2;
    private final static int id_notification = 3;
    MeowBottomNavigation meowBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        meowBottomNavigation = findViewById(R.id.navigationBar);

        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_login));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_notification));

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment1()).commit();


        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //    Toast.makeText(MainActivity.this, "clicked item"+item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment select_fragment = null;

                switch (item.getId()) {
                    case id_home:
                        select_fragment = new Fragment1();
                        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                        transaction1.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                        transaction1.addToBackStack(null);
                        transaction1.commit();
                        break;

                    case id_login:
                        select_fragment = new Fragment2();
                        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                        transaction2.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                        transaction2.addToBackStack(null);
                        transaction2.commit();
                        break;

                    case id_notification:
                        select_fragment = new Fragment3();
                        FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                        transaction3.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                        transaction3.addToBackStack(null);
                        transaction3.commit();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, select_fragment).commit();
            }
        });

    }
}