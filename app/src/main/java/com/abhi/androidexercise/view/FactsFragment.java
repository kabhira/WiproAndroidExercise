package com.abhi.androidexercise.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhi.androidexercise.R;
import com.abhi.androidexercise.events.DataChangedEvent;
import com.abhi.androidexercise.events.EventBusSingleton;
import com.squareup.otto.Subscribe;


public class FactsFragment extends Fragment {
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
//        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list_recycler_view);
//        mRecyclerView.setHasFixedSize(true);
//        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//        mRecyclerView.setLayoutManager(mLayoutManager);
//
//        mDataset = DataManager.instance().getMainList();
//        mAdapter = new Adapter(mDataset, this.getActivity());
//        mRecyclerView.setAdapter(mAdapter);
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
}
