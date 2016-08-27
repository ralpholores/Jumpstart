package com.example.rapsk.jumpstart.Home.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.rapsk.jumpstart.Home.SMEDetailsActivity;
import com.example.rapsk.jumpstart.Home.adapters.RecyclerViewAdapter;
import com.example.rapsk.jumpstart.Home.contants.Constants;
import com.example.rapsk.jumpstart.Home.entities.Project;
import com.example.rapsk.jumpstart.Models.SME;
import com.example.rapsk.jumpstart.R;
import java.util.List;

/**
 * Created by gvg on 8/8/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.SMEViewHolder> {

    private Context mContext;
    private int         mLayoutId;
    private List<SME> mSMEs;

    public RecyclerViewAdapter(Context context, int layoutId, List<SME> smes) {
        mContext = context;
        mLayoutId = layoutId;
        mSMEs = smes;
 }
    @Override
    public SMEViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);
        return new SMEViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SMEViewHolder holder, int position) {
        SME SME = mSMEs.get(position);

        if (SME != null) {
//            if (holder.imgSME != null) {
//                holder.imgSME.setImageResource(Project.getSme_id());
//            }
            if (holder.tvName != null) {
                holder.tvName.setText(SME.getCompany_name());
            }
            if (holder.tvGenre != null) {
                holder.tvGenre.setText(SME.getId());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mSMEs.size();
    }

    static class SMEViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cardView;
        public ImageView imgSME;
        public TextView tvName;
        public TextView tvGenre;

        public SMEViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.cardView);
            imgSME = (ImageView) view.findViewById(R.id.imgMovie);
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvGenre = (TextView) view.findViewById(R.id.tvGenre);

            // once an item view (list item or grid item) is clicked
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, SMEDetailsActivity.class);

            intent.putExtra(Constants.EXTRA_POSITION, getAdapterPosition());
            context.startActivity(intent);
        }
    }
}