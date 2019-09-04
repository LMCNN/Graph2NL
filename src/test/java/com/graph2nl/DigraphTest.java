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
        vertexLabels.put("Phone", new VertexLabel("Phone", 0L));
        vertexLabels.put("Web", new VertexLabel("Web"));
        dg.setVertexLabelMap(vertexLabels);

        Map<String, EdgeLabel> edgeLabels = new HashMap<>();
        edgeLabels.put("called", new EdgeLabel("called", 2L));
        edgeLabels.put("message", new EdgeLabel("message", 3L));
        edgeLabels.put("visit", new EdgeLabel("visit", 4L));
        edgeLabels.put("is", new EdgeLabel("is", 0L));
        dg.setEdgeLabelMap(edgeLabels);

        Vertex tempV = new Vertex(0L, dg.getVertexLabelByName("User"), "u0001");
        dg.addVertexToMap(tempV);
        tempV = new Vertex(1L, dg.getVertexLabelByName("User"), "u0002");
        dg.addVertexToMap(tempV);
        tempV = new Vertex(100L, dg.getVertexLabelByName("Phone"), "9808BB994AB33432DE15AD5D560A49AE");
        tempV.putAttribute("opp_head", "137");
        tempV.putAttribute("opp_len", "11");
        dg.addVertexToMap(tempV);
        tempV = new Vertex(101L, dg.getVertexLabelByName("Phone"), "0129FA4AF9C1907F712D0BCD562E864A");
        tempV.putAttribute("opp_head", "51");
        tempV.putAttribute("opp_len", "12");
        dg.addVertexToMap(tempV);
        tempV = new Vertex(5760L, dg.getVertexLabelByName("Web"), "155导航_0");
        tempV.putAttribute("wa_type", "0");
        dg.addVertexToMap(tempV);
        tempV = new Vertex(5761L, dg.getVertexLabelByName("Web"), "360借条_1");
        tempV.putAttribute("wa_type", "1");
        dg.addVertexToMap(tempV);

        Edge tempE = new Edge(0L, dg.getVertexById(0L), dg.getVertexById(100L), dg.getEdgeLabelByName("called"));
        tempE.putAttribute("start_time", "12");
        tempE.putAttribute("in_out", "0");
        tempE.putAttribute("call_type", "1");
        tempE.putAttribute("call_dura", "29");
        dg.addEdge(tempE);
        tempE = new Edge(1L, dg.getVertexById(0L), dg.getVertexById(101L), dg.getEdgeLabelByName("called"));
        tempE.putAttribute("start_time", "14");
        tempE.putAttribute("in_out", "1");
        tempE.putAttribute("call_type", "1");
        tempE.putAttribute("call_dura", "120");
        dg.addEdge(tempE);
        tempE = new Edge(2L, dg.getVertexById(0L), dg.getVertexById(5760L), dg.getEdgeLabelByName("visit"));
        tempE.putAttribute("up_flow", "100");
        tempE.putAttribute("date", "01");
        tempE.putAttribute("down_flow", "500");
        tempE.putAttribute("visit_dura", "300");
        tempE.putAttribute("visit_cnt", "2");
        dg.addEdge(tempE);
        tempE = new Edge(3L, dg.getVertexById(0L), dg.getVertexById(5761L), dg.getEdgeLabelByName("visit"));
        tempE.putAttribute("up_flow", "100");
        tempE.putAttribute("date", "02");
        tempE.putAttribute("down_flow", "400");
        tempE.putAttribute("visit_dura", "400");
        tempE.putAttribute("visit_cnt", "4");
        dg.addEdge(tempE);
        tempE = new Edge(4L, dg.getVertexById(1L), dg.getVertexById(101L), dg.getEdgeLabelByName("called"));
        tempE.putAttribute("start_time", "14");
        tempE.putAttribute("in_out", "1");
        tempE.putAttribute("call_type", "1");
        tempE.putAttribute("call_dura", "63");
        dg.addEdge(tempE);
        tempE = new Edge(5L, dg.getVertexById(1L), dg.getVertexById(101L), dg.getEdgeLabelByName("message"));
        tempE.putAttribute("start_time", "12");
        tempE.putAttribute("in_out", "0");
        dg.addEdge(tempE);
    }

    @Test
    public void testAll(){
//        System.out.println(dg.toString());
//        dg.describe('e');
        System.out.println(dg.getJson());
    }
}