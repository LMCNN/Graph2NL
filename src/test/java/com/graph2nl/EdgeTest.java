package com.graph2nl;

import org.junit.*;

import static org.junit.Assert.*;

public class EdgeTest {
    private Edge e1;

    @Before
    public void setup(){
        e1 = new Edge(0,1, 2, "called");
    }

    @Test
    public void testGetId(){
        Assert.assertTrue(e1.getId() == 0);
    }

    @Test
    public void testGetFrom() {
        Assert.assertTrue(e1.getFrom() == 1);
    }

    @Test
    public void testGetTo() {
        Assert.assertTrue(e1.getTo() == 2);
    }

    @Test
    public void testGetLabel() {
        Assert.assertEquals(e1.getLabel(), "called");
    }

    @Test
    public void testEquals() {
        Edge tmpE = new Edge(1,1, 2, "call");
        Edge tmpE2 = new Edge(2,2, 1, "called");
        Edge tmpE3 = new Edge(0,2, 1, "called");
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