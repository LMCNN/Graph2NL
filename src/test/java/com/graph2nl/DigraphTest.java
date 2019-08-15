package com.graph2nl;

import org.junit.Assert;
import org.junit.Test;

public class DigraphTest {
    @Test
    public void testAll(){
        Digraph dg = new Digraph();

        Assert.assertTrue(dg.getOutVertices().size() == 0);
        dg.addVertexToMap(new Vertex(new Long(1), "User", "Mingchi Li"));
        dg.addVertexToMap(new Vertex(new Long(2), "Number", "110"));
        dg.addVertexToMap(new Vertex(new Long(3), "Website", "baidu.com"));
        dg.addVertexToMap(new Vertex(new Long(4), "APP", "YouTube"));
        Assert.assertTrue(dg.getOutVertices().size() == 0);

        dg.addEdge(new Edge(new Long(1), new Long(1), new Long(2), "called"));
        dg.addEdge(new Edge(new Long(2), new Long(1), new Long(2), "message"));
        dg.addEdge(new Edge(new Long(3), new Long(1), new Long(3), "visit"));
        dg.addEdge(new Edge(new Long(4), new Long(1), new Long(4), "visit"));
        Assert.assertTrue(dg.getOutVertices().size() == 1);
        System.out.println(dg.toString());
    }
}
//Gephi