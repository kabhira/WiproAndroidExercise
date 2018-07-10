package com.abhi.androidexercise.model;

import android.util.Log;

import com.abhi.androidexercise.Network.FactsRequest;
import com.abhi.androidexercise.Network.VolleyNetwork;
import com.abhi.androidexercise.events.DataChangedEvent;
import com.abhi.androidexercise.events.EventBusSingleton;
import com.abhi.androidexercise.utilities.CustomApplication;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 *  Author: Abhiraj Khare
 *  Description: Singleton File used for caching the data.
 */
public class DataManager {

    private static DataManager instance = new DataManager();
    private FactsElement factsElement;

    private DataManager(){
        factsElement = new FactsElement();
        Log.e("Singleton Check", "I am called.");
        EventBusSingleton.instance().register(this);
        FactsRequest FactsRequest = new FactsRequest();
        VolleyNetwork.getInstance(CustomApplication.getmContext()).addToRequestQueue(FactsRequest);
    }

    public static DataManager instance()
    {
        return instance;
    }

    public synchronized ArrayList<FactsRowsElement> getMainList(){
        return factsElement.getRows();
    }



    @Subscribe
    public void serverResponse(FactsElement data){

        factsElement.getRows().clear();
        factsElement.getRows().addAll(data.getRows());
        EventBusSingleton.instance().postEvent(new DataChangedEvent());
    }

}
