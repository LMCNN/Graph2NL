package com.graph2nl;

import org.junit.*;
import static org.junit.Assert.*;

public class EdgeTest {
    private VertexLabel vertexLabel;
    private EdgeLabel edgeLabel;
    private Vertex v1;
    private Vertex v2;
    private Edge e1;

    @Before
    public void setup(){
        vertexLabel = new VertexLabel("User");
        edgeLabel = new EdgeLabel("called");
        v1 = new Vertex(1L, vertexLabel, "u1");
        v2 = new Vertex(2L, vertexLabel, "u2");
        e1 = new Edge(0L, v1, v2, edgeLabel);
    }

    @Test
    public void testGetId(){
        Assert.assertTrue(e1.getId() == 0);
    }

    @Test
    public void testGetFrom() {
        Assert.assertTrue(e1.getFrom().getId() == 1);
    }

    @Test
    public void testGetTo() {
        Assert.assertTrue(e1.getTo().getId() == 2);
    }

    @Test
    public void testGetLabel() {
        Assert.assertEquals(e1.getLabel().getName(), "called");
    }

    @Test
    public void testEquals() {
        Edge tmpE = new Edge(1L, v1, v2, new EdgeLabel("call"));
        Edge tmpE2 = new Edge(2L,v2, v1, edgeLabel);
        Edge tmpE3 = new Edge(0L, v2, v1, edgeLabel);
        Assert.assertTrue(e1.equals(e1));
        Assert.assertFalse(e1.equals(new Object()));
        Assert.assertFalse(e1.equals(tmpE));
        Assert.assertFalse(e1.equals(tmpE2));
        Assert.assertTrue(e1.equals(tmpE3));
    }

    @Test
    public void testToString(){
        assertEquals(e1.toString(), "1-called->2");
    }
}