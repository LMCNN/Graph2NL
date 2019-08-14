package com.graph2nl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VertexLabelTest {
    private VertexLabel vertexLabel;
    @Before
    public void setUp() throws Exception {
        vertexLabel = new VertexLabel("User");
    }

    @Test
    public void testAll(){
        Assert.assertTrue(vertexLabel.getPriority() == Integer.MAX_VALUE);
        Assert.assertEquals(vertexLabel.getName(), "User");

        vertexLabel.setPriority(0);
        Assert.assertTrue(vertexLabel.getPriority() == 0);

        Assert.assertEquals(vertexLabel.toString(), " User ");
    }

    @Test
    public void testCompareTo(){
        VertexLabel temp1 = new VertexLabel("User");
        temp1.setPriority(0);
        VertexLabel temp2 = new VertexLabel("Number");
        temp2.setPriority(0);
        Assert.assertTrue(temp1.compareTo(temp2) == 0);

        temp2.setPriority(1);
        Assert.assertTrue(temp1.compareTo(temp2) == -1);

        temp1.setPriority(2);
        Assert.assertTrue(temp1.compareTo(temp2) == 1);
    }
}
