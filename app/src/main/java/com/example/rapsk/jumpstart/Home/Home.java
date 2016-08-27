package com.example.rapsk.jumpstart.Home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.example.rapsk.jumpstart.Home.fragments.RecyclerViewGridFragment;
import com.example.rapsk.jumpstart.R;


public class Home extends AppCompatActivity {


    private RecyclerViewGridFragment mRecyclerViewGridFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create new instances of the fragment

        mRecyclerViewGridFragment = RecyclerViewGridFragment.newInstance();

        // Set the main content view to the listview fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, mRecyclerViewGridFragment)
                .commit();
    }
    }



