package com.graph2nl;

import org.junit.*;

public class VertexTest {
    private Vertex v1;

    @Before
    public void setUp(){
        v1 = new Vertex(1L, new VertexLabel("Number"), "110");
    }

    @Test
    public void testGetters() {
        Assert.assertTrue(v1.getId() == 1);
        Assert.assertEquals(v1.getLabel().getName(), "Number");
        Assert.assertEquals(v1.getName(), "110");
        Assert.assertTrue(v1.getOutDegree() == 0);
    }

    @Test
    public void testEdgeMethods(){
        VertexLabel vertexLabel1 = new VertexLabel("User");
        VertexLabel vertexLabel2 = new VertexLabel("Number");
        VertexLabel vertexLabel3 = new VertexLabel("Website");
        VertexLabel vertexLabel4 = new VertexLabel("APP");
        EdgeLabel edgeLabel1 = new EdgeLabel("called");
        EdgeLabel edgeLabel2 = new EdgeLabel("message");
        EdgeLabel edgeLabel3 = new EdgeLabel("visit");
        Vertex testV = new Vertex(1L, vertexLabel1, "Mingchi");
        Vertex v1 = new Vertex(2L, vertexLabel2, "110");
        Vertex v2 = new Vertex(3L, vertexLabel2, "120");
        Vertex v3 = new Vertex(4L, vertexLabel3, "baidu.com");
        Vertex v4 = new Vertex(5L, vertexLabel4, "WeChat");
        Edge e1 = new Edge(1L, testV, v1, edgeLabel1);
        Edge e2 = new Edge(2L, testV, v2, edgeLabel2);
        Edge e3 = new Edge(3L, testV, v3, edgeLabel3);
        Edge e4 = new Edge(4L, testV, v4, edgeLabel3);
        testV.addEdge(e1);
        testV.addEdge(e2);
        testV.addEdge(e3);
        testV.addEdge(e4);
        Assert.assertTrue(testV.getOutDegree() == 4);
        testV.putAttribute("gender", "male");
        testV.putAttribute("age", "19");
//        String result = "Vertex{\n" +
//                "\tid=1,\n" +
//                "\toutDegree=4, \n" +
//                "\tedgeMap=3, \n" +
//                "\tlabel=User, \n" +
//                "\tname='Mingchi', \n" +
//                "\tattributes={gender=male, age=19}\n" +
//                "}";
        String result = "User:Mingchi";
        Assert.assertEquals(testV.toString(), result);
        Assert.assertEquals(testV.print(false), "Mingchi");
    }
}
