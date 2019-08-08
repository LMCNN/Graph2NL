package com.graph2nl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VertexTest {
    private Vertex v1;

    @Before
    public void setUp(){
        v1 = new Vertex(1, "Number", "110");
    }

    @Test
    public void testGetters() {
        Assert.assertTrue(v1.getId() == 1);
        Assert.assertEquals(v1.getLabel(), "Number");
        Assert.assertEquals(v1.getName(), "110");
    }

}
