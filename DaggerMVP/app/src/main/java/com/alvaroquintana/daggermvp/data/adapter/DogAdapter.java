package com.alvaroquintana.daggermvp.data.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alvaroquintana.daggermvp.R;
import com.alvaroquintana.daggermvp.data.Net.Services;
import com.alvaroquintana.daggermvp.data.model.Dog;
import com.squareup.picasso.Picasso;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Quintana on 30/3/18.
 */

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder> {

    private List<Dog> mDataset;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        ImageView dogPhoto;
        TextView dogName;

        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            dogPhoto = (ImageView)itemView.findViewById(R.id.image_dog);
            dogName = (TextView) itemView.findViewById(R.id.text_name);
        }
    }

    public DogAdapter(Context context, List<Dog> myDataset) {
        this.context = context;
        mDataset = myDataset;
    }

    @Override
    public DogAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dog, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.get().load(mDataset.get(position).getIcon()).into(holder.dogPhoto);

        try {
            holder.dogName.setText(URLEncoder.encode(mDataset.get(position).getName(), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            holder.dogName.setText(mDataset.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}