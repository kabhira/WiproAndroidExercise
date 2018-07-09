package com.abhi.androidexercise.Network;

import com.abhi.androidexercise.events.ConnectionSuccessfulEvent;
import com.abhi.androidexercise.events.DataVolleyError;
import com.abhi.androidexercise.events.EventBusSingleton;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 *  Author: Abhiraj Khare
 *  Description: Base class for all network operation requests which is executed by volley and response is parsed by GSON library.
 */

public class VolleyRequest<T> extends Request<T>
{
    private final Gson gson = new Gson();
    private final Class<T> clazz;
    private final Map<String, String> headers;
    private final Map<String, String> params;
    private final String mRequestBody;
    protected static final String PROTOCOL_CHARSET = "utf-8";

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param url URL of the request to make
     * @param clazz Relevant class object, for Gson's reflection
     * @param headers Map of request headers
     */
    public VolleyRequest(int requestType, String url, Class<T> clazz, Map<String, String> headers, Map<String, String> params, String jsonRequest)
    {
        super(requestType, url, new DataVolleyError());
        this.clazz = clazz;
        this.headers = headers;
        this.params = params;
        this.mRequestBody = jsonRequest;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params != null ? params : super.getParams();
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError
    {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    public byte[] getBody() {
        try {
            return mRequestBody == null ? null : mRequestBody.getBytes(PROTOCOL_CHARSET);
        }
        catch (UnsupportedEncodingException uee) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s",
                    mRequestBody, PROTOCOL_CHARSET);
            return null;
        }
    }

    @Override
    protected void deliverResponse(T response){

        EventBusSingleton.instance().postEvent(new ConnectionSuccessfulEvent());
        EventBusSingleton.instance().postEvent(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response)
    {
        try
        {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(gson.fromJson(json, clazz), HttpHeaderParser.parseCacheHeaders(response));
        }
        catch (UnsupportedEncodingException e)
        {
            return Response.error(new ParseError(e));
        }
        catch (JsonSyntaxException e)
        {
            return Response.error(new ParseError(e));
        }

    }
}