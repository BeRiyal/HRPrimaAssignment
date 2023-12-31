package com.example.hrprima;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hrprima.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding mainBinding;
    int[] layouts;
    SliderAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        mainBinding=ActivityMainBinding.inflate((getLayoutInflater()));
        View view = mainBinding.getRoot();
        setContentView(view);
        init();


    }

    private  void  init(){
        layouts = new int[]{
                R.layout.slide_screen_1,
                R.layout.slide_screen_2,
                R.layout.slide_screen_3
        };

        mainBinding.btnNext.setOnClickListener(this);
        mainBinding.btnSkip.setOnClickListener(this);

        mAdapter = new SliderAdapter(layouts);
        mainBinding.viewPager.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == mainBinding.btnNext.getId())
        {
            int current = getItem(+1);
            if (current<layouts.length){
                mainBinding.viewPager.setCurrentItem(current);
                if (current == layouts.length-1){
                    mainBinding.btnNext.setText(R.string.cont);
                }
            } else {
                launchLoginScreen();
            }
        } else if (v.getId() == mainBinding.btnSkip.getId()) {
            launchLoginScreen();
        }

    }

    private int getItem(int i) {
        return  mainBinding.viewPager.getCurrentItem() +1;
    }

    private void launchLoginScreen() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}