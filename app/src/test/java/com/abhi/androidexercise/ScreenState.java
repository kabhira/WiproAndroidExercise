package com.abhi.androidexercise;

import com.abhi.androidexercise.model.FactsElement;
import com.abhi.androidexercise.view.FactsFragment;
import com.google.gson.Gson;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by abhi on 7/13/18.
 */

public class ScreenState {

    @Test
    public void listHasDataTest() throws Exception {

        FactsFragment factsFragment = new FactsFragment();


        String json = "{\"title\":\"About Canada\",\"rows\":[{\"title\":\"Beavers\",\"description\":\"Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony\",\"imageHref\":\"http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg\"}]}";
        Gson gson = new Gson();
        FactsElement factsEle = gson.fromJson(json, FactsElement.class);

        assertTrue(factsFragment.setDataToList(factsEle.getRows()).getAdapter().getItemCount()>0);
        //assertThat(8, is( equalTo(4 +4) ) );
    }
}
