package com.graph2nl;

import org.junit.*;
import java.util.*;

public class DigraphTest {
    private Digraph dg;

    @Before
    public void setUp(){
        dg = new Digraph();
        Map<String, VertexLabel> vertexLabels = new HashMap<>();
        vertexLabels.put("User", new VertexLabel("User", 1L));
        vertexLabels.put("Number", new VertexLabel("Number", 0L));
        vertexLabels.put("Character", new VertexLabel("Character"));
        vertexLabels.put("Website", new VertexLabel("Website"));
        vertexLabels.put("APP", new VertexLabel("APP"));
        dg.setVertexLabelMap(vertexLabels);

        Map<String, EdgeLabel> edgeLabels = new HashMap<>();
        edgeLabels.put("called", new EdgeLabel("called", 2L));
        edgeLabels.put("message", new EdgeLabel("message", 3L));
        edgeLabels.put("visit", new EdgeLabel("visit", 4L));
        edgeLabels.put("is", new EdgeLabel("is", 0L));
        dg.setEdgeLabelMap(edgeLabels);
    }

    @Test
    public void testAll(){
        Assert.assertTrue(dg.getOutVertices().size() == 0);
        dg.addVertexToMap(new Vertex(0L, dg.getVertexLabelByName("Character"), "fake"));
        dg.addVertexToMap(new Vertex(1L, dg.getVertexLabelByName("Character"), "not fake"));
        dg.addVertexToMap(new Vertex(2L, dg.getVertexLabelByName("User"), "Xiaobai Li"));
        dg.addVertexToMap(new Vertex(3L, dg.getVertexLabelByName("User"), "Geek Zhang"));
        dg.addVertexToMap(new Vertex(4L, dg.getVertexLabelByName("Number"), "110"));
        dg.addVertexToMap(new Vertex(5L, dg.getVertexLabelByName("Number"), "119"));
        dg.addVertexToMap(new Vertex(6L, dg.getVertexLabelByName("APP"), "WeChat"));
        dg.addVertexToMap(new Vertex(7L, dg.getVertexLabelByName("Website"), "baidu.com"));
        Assert.assertTrue(dg.getOutVertices().size() == 0);

        dg.addEdge(new Edge(0L, dg.getVertexById(2L), dg.getVertexById(4L), dg.getEdgeLabelByName("called")));
        dg.addEdge(new Edge(1L, dg.getVertexById(2L), dg.getVertexById(4L), dg.getEdgeLabelByName("called")));
        dg.addEdge(new Edge(2L, dg.getVertexById(4L), dg.getVertexById(2L), dg.getEdgeLabelByName("message")));
        dg.addEdge(new Edge(3L, dg.getVertexById(2L), dg.getVertexById(5L), dg.getEdgeLabelByName("called")));
        dg.addEdge(new Edge(4L, dg.getVertexById(3L), dg.getVertexById(5L), dg.getEdgeLabelByName("called")));
        dg.addEdge(new Edge(5L, dg.getVertexById(5L), dg.getVertexById(3L), dg.getEdgeLabelByName("message")));
        dg.addEdge(new Edge(6L, dg.getVertexById(2L), dg.getVertexById(1L), dg.getEdgeLabelByName("is")));
        dg.addEdge(new Edge(7L, dg.getVertexById(3L), dg.getVertexById(0L), dg.getEdgeLabelByName("is")));
        dg.addEdge(new Edge(8L, dg.getVertexById(2L), dg.getVertexById(6L), dg.getEdgeLabelByName("visit")));
        dg.addEdge(new Edge(9L, dg.getVertexById(3L), dg.getVertexById(6L), dg.getEdgeLabelByName("visit")));
        dg.addEdge(new Edge(10L, dg.getVertexById(3L), dg.getVertexById(7L), dg.getEdgeLabelByName("visit")));
        Assert.assertTrue(dg.getOutVertices().size() == 4);

//        System.out.println(dg.toString());
        dg.describe('e');
    }
}