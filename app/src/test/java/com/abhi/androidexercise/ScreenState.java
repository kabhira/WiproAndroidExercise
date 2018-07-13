package com.abhi.androidexercise;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by abhi on 7/13/18.
 */

public class ScreenState {


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void assertThatTestTrue() throws Exception {

        assertThat(8, is( equalTo(4 +4) ) );
    }
}
