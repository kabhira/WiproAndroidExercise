package com.abhi.androidexercise.utilities;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abhi.androidexercise.Network.VolleyNetwork;
import com.abhi.androidexercise.R;
import com.abhi.androidexercise.model.FactsRowsElement;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 *  Author: Abhiraj Khare
 *  Description: Adapter to display lists.
 */

public class FactsAdapter extends RecyclerView.Adapter<FactsAdapter.ViewHolder> {
    private ArrayList<FactsRowsElement> mDataset;
    private FragmentActivity mActivity;

    public FactsAdapter(ArrayList<FactsRowsElement> myDataset, FragmentActivity mActivity) {
        mDataset = myDataset;
        this.mActivity = mActivity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title, description;
        public NetworkImageView mImageView;
        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.title);
            description = (TextView) v.findViewById(R.id.description);
            mImageView = (NetworkImageView) v.findViewById(R.id.cell_imageView);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public FactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_cell, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        FactsRowsElement element = mDataset.get(position);
        holder.title.setText(element.getTitle());
        holder.description.setText(element.getDescription());


        ImageLoader imageLoader = VolleyNetwork.getInstance(mActivity).getImageLoader();
        holder.mImageView.setDefaultImageResId(R.drawable.def_images);
        holder.mImageView.setImageUrl(element.getImageHref(), imageLoader);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

