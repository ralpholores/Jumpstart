package com.example.rapsk.jumpstart.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rapsk.jumpstart.Models.SME;
import com.example.rapsk.jumpstart.R;

import java.util.List;

/**
 * Created by RAPSK on 8/25/2016.
 */
public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    String[] smeNames;
    int[] smeNeedFunds;
    int[] smeFundsReceived;
    List<SME> smeLists;
    LayoutInflater inflater;


    public ViewPagerAdapter(Context context, String[] smeName,int[] smeFundReceived,int[] smeNeedFund) {
        this.context = context;
        this.smeNames = smeName;
        this.smeFundsReceived = smeFundReceived;
        this.smeNeedFunds = smeNeedFund;
    }

    @Override
    public int getCount() {
        return smeNames.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TextView txtNeededFund;
        TextView txtReceivedFund;
        TextView txtSMEName;
        ImageView imgLogo;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.youtubeapi_activity,container,false);
        txtNeededFund = (TextView) itemView.findViewById(R.id.neededFund);
        txtReceivedFund = (TextView) itemView.findViewById(R.id.receivedFund);
        txtSMEName = (TextView) itemView.findViewById(R.id.smeName);
//

        txtNeededFund.setText(""+smeNeedFunds[position]);
        txtReceivedFund.setText(""+smeFundsReceived[position]);
        txtSMEName.setText(smeNames[position]);
//
//        imgLogo = (ImageView) itemView.findViewById(R.id.logo);
//        imgLogo.setImageResource(R.mipmap.ic_launcher);
        ((ViewPager) container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
