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
        Assert.assertTrue(vertexLabel.getPriority() == Long.MAX_VALUE);
        Assert.assertEquals(vertexLabel.getName(), "User");

        vertexLabel.setPriority(0L);
        Assert.assertTrue(vertexLabel.getPriority() == 0);

        Assert.assertEquals(vertexLabel.toString(), "{name:User, priority:0}");
    }

    @Test
    public void testCompareTo(){
        VertexLabel temp1 = new VertexLabel("{name:User, priority:0}");
        temp1.setPriority(0L);
        VertexLabel temp2 = new VertexLabel("Number");

        temp2.setPriority(1L);
        Assert.assertTrue(temp1.compareTo(temp2) < 0);

        temp1.setPriority(2L);
        Assert.assertTrue(temp1.compareTo(temp2) > 0);
    }
}
