package com.example.rapsk.jumpstart.Adapter;

import android.support.v7.widget.CardView;

/**
 * Created by cicct on 9/13/2016.
 */
public interface CardAdapter {

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}