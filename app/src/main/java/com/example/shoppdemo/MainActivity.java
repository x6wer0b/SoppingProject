package com.example.shoppdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.shoppdemo.fragment.ClassifyFragment;
import com.example.shoppdemo.fragment.HomeFragment;
import com.example.shoppdemo.fragment.MyFragment;
import com.example.shoppdemo.fragment.ShoppingFragment;
import com.example.shoppdemo.fragment.SpecialFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private SpecialFragment specialFragment;
    private ClassifyFragment classifyFragment;
    private ShoppingFragment shoppingFragment;
    private MyFragment myFragment;
    private Fragment[] fragments;
    private int lastFragment; //用于记录上个选择的fragment
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        specialFragment = new SpecialFragment();
        classifyFragment = new ClassifyFragment();
        shoppingFragment = new ShoppingFragment();
        myFragment = new MyFragment();

        fragments = new Fragment[]{homeFragment, specialFragment, classifyFragment, shoppingFragment, myFragment};
        lastFragment = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.linear,homeFragment).show(homeFragment).commit();
        bottomNavigationView = findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(changFragment);
    }

    //判断选的的菜单
    private BottomNavigationView.OnNavigationItemSelectedListener changFragment =new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.menu1:{
                    if (lastFragment != 0){
                        switchFragment(lastFragment,0);
                        lastFragment = 0;
                    }
                    return true;
                }
                case R.id.menu2:{
                    if (lastFragment != 1){
                        switchFragment(lastFragment,1);
                        lastFragment = 1;
                    }
                    return true;

                }
                case R.id.menu3:{
                    if (lastFragment != 2){
                        switchFragment(lastFragment,2);
                        lastFragment = 2;
                    }
                    return true;
                }
                case R.id.menu4:{
                    if (lastFragment != 3){
                        switchFragment(lastFragment,3);
                        lastFragment = 3;
                    }
                    return true;
                }
                case R.id.menu5:{
                    if (lastFragment != 4){
                        switchFragment(lastFragment,4);
                        lastFragment = 4;
                    }
                    return true;
                }
            }
            return false;
        }
    };


    //切换fragment
    private void switchFragment(int lastFragment,int index){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(fragments[lastFragment]);
        if (fragments[index].isAdded() == false){
            fragmentTransaction.add(R.id.linear,fragments[index]);
        }
        fragmentTransaction.show(fragments[index]).commitAllowingStateLoss();
    }
}
