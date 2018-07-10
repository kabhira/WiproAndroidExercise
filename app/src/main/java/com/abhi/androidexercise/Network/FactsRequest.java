package com.abhi.androidexercise.Network;


import com.abhi.androidexercise.model.FactsElement;

/**
 *  Author: Abhiraj Khare
 *  Description: Network request to be executed by Volley to fetch json.
 */

public class FactsRequest extends VolleyRequest<FactsElement> {

    private static String url = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json";
    public FactsRequest(){
        super(Method.GET, url, FactsElement.class, null, null, null);
    }
}