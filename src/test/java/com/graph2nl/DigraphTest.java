package com.graph2nl;

import org.junit.Assert;
import org.junit.Test;

public class DigraphTest {
    @Test
    public void testAll(){
        Digraph dg = new Digraph();

        Assert.assertTrue(dg.getOutVertices().size() == 0);
        dg.addVertexToMap(new Vertex(1, "User", "Mingchi Li"));
        dg.addVertexToMap(new Vertex(2, "Number", "110"));
        dg.addVertexToMap(new Vertex(3, "Website", "baidu.com"));
        dg.addVertexToMap(new Vertex(4, "APP", "YouTube"));
        Assert.assertTrue(dg.getOutVertices().size() == 0);

        dg.addEdge(new Edge(1, 1, 2, "called"));
        dg.addEdge(new Edge(2, 1, 2, "message"));
        dg.addEdge(new Edge(3, 1, 3, "visit"));
        dg.addEdge(new Edge(4, 1, 4, "visit"));
        Assert.assertTrue(dg.getOutVertices().size() == 1);
        System.out.println(dg.toString());
    }
}
