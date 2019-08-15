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
        Assert.assertEquals(edgeLabel.toString(), " called ");
        edgeLabel.setPrefix("a");
        Assert.assertEquals(edgeLabel.toString(), "a called ");
        edgeLabel.setPostfix("b");
        Assert.assertEquals(edgeLabel.toString(), "a called b");
    }

    @Test
    public void testCompareTo(){
        EdgeLabel temp1 = new EdgeLabel("called");
        temp1.setPriority(new Long(0));
        EdgeLabel temp2= new EdgeLabel("visit");
        temp2.setPriority(new Long(0));
        Assert.assertTrue(temp1.compareTo(temp2) == 0);

        temp2.setPriority(new Long(1));
        Assert.assertTrue(temp1.compareTo(temp2) == -1);

        temp1.setPriority(new Long(2));
        Assert.assertTrue(temp1.compareTo(temp2) == 1);
    }
}
