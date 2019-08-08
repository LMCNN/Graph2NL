package com.graph2nl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  This is the Direct Graph class
 *
 *  author: Mingchi Li
 *  date 2019.8.8
 */
public class Digraph {
    private Map<Integer, Vertex> vertexMap;
    private List<Integer> outVertices;

    /**
     * The constructor of this class
     */
    public Digraph() {
        this.vertexMap = new HashMap<>();
        this.outVertices = new ArrayList<>();
    }

    /**
     * Put a vertex into the map
     * @param v the vertex need to be put
     * @return this vertex
     */
    public Vertex addVertexToMap(Vertex v){
        vertexMap.put(v.getId(), v);
        return v;
    }

    /**
     * Get all vertices with our degree greater than 0
     * @return a list of vertex
     */
    public List<Integer> getOutVertices() {
        return outVertices;
    }

    /**
     * Get a vertex from map by its id
     * @param id the id of this vertex
     * @return the vertex needed
     */
    public Vertex getVertexById(Integer id){
        return this.vertexMap.get(id);
    }

    /**
     * Update the out vertex list
     */
    public void updateOut(){
        for (Integer key : vertexMap.keySet()) {
            Vertex tmp = vertexMap.get(key);
            if (tmp.getOutDegree() > 0)
                outVertices.add(key);
        }
    }

    /**
     * Add a edge to the graph
     * @param e the edge need to be added
     * @return this edge
     */
    public Edge addEdge(Edge e){
        Integer eId = e.getFrom();
        Vertex currV = getVertexById(eId);
        currV.addEdge(e);
        return e;
    }

    @Override
    public String toString() {
        return "Digraph\n{\n" +
                "\t\nvertexMap=" + vertexMap.toString() +
                ", \noutVertices=" + outVertices +
                "\n}";
    }
}
