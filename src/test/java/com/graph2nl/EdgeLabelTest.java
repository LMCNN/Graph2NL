package com.graph2nl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EdgeLabelTest {
    private EdgeLabel edgeLabel;

    @Before
    public void setUp(){
        edgeLabel = new EdgeLabel("called");
    }

    @Test
    public void testAll(){
        Assert.assertEquals(edgeLabel.toString(), "called");
        edgeLabel.setPrefix("a");
        Assert.assertEquals(edgeLabel.toString(), "called");
        edgeLabel.setPostfix("b");
        Assert.assertEquals(edgeLabel.toString(), "called");
    }
}
