package com.graph2nl;

import org.junit.*;

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
        Assert.assertTrue(v1.getOutDegree() == 0);
    }

    @Test
    public void testEdgeMethods(){
        Vertex testV = new Vertex(2, "User", "Mingchi");
        Edge e1 = new Edge(1, 2, 3, "called");
        Edge e2 = new Edge(2, 2, 3, "message");
        Edge e3 = new Edge(3, 2, 4, "visit");
        Edge e4 = new Edge(4, 2, 5, "visit");
        testV.addEdge(e1);
        testV.addEdge(e2);
        testV.addEdge(e3);
        testV.addEdge(e4);
        Assert.assertTrue(testV.getOutDegree() == 4);
        System.out.println(testV.getEdgeMap().get("visit").get(1).toString());
    }
}
