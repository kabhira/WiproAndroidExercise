package com.abhi.androidexercise.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhi.androidexercise.R;
import com.abhi.androidexercise.events.DataChangedEvent;
import com.abhi.androidexercise.events.EventBusSingleton;
import com.abhi.androidexercise.model.DataManager;
import com.abhi.androidexercise.model.FactsRowsElement;
import com.abhi.androidexercise.utilities.FactsAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;


public class FactsFragment extends Fragment {

    private RecyclerView mRecyclerView;

    public FactsFragment() {
        // Required empty public constructor
    }

    public static FactsFragment newInstance() {
        FactsFragment fragment = new FactsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_facts, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list_recycler_view);
        setDataToList(DataManager.instance().getMainList());

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBusSingleton.instance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBusSingleton.instance().unregister(this);
    }

    @Subscribe
    public void dataChangedEvent(DataChangedEvent event){
        //mAdapter.notifyDataSetChanged();
        Log.e(">>>", "DataChangedEvent");
    }

    public RecyclerView setDataToList(ArrayList<FactsRowsElement> mDataset) {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        FactsAdapter mAdapter = new FactsAdapter(mDataset, this.getActivity());
        mRecyclerView.setAdapter(mAdapter);
        return mRecyclerView;
    }
}
