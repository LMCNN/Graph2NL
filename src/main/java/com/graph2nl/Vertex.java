package com.graph2nl;

import java.util.*;

/**
 * The vertex class
 *
 * author: Mingchi Li
 * date; 2019.8.8
 */
public class Vertex {
    private Integer id;
    private Integer outDegree;
    private Map<String, List<Edge>> edgeMap;
    private String label;
    private String name;

    /**
     * The constructor for the vertex class
     * @param id the id of the vertex
     * @param label vertex label
     * @param name the name of the vertex
     */
    public Vertex(Integer id, String label, String name) {
        this.id = id;
        this.edgeMap = new HashMap<>();
        this.label = label;
        this.name = name;
        this.outDegree = 0;
    }

    /**
     * Gets the out degree of the vertex
     * @return the out degree of current vertex
     */
    public Integer getOutDegree() {
        return outDegree;
    }

    /**
     * Gets the id of the vertex
     * @return the id of current vertex
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets the label of the current vertex
     * @return the label of this vertex
     */
    public String getLabel() {
        return label;
    }

    /**
     * Gets the name of current vertex
     * @return the name of this vertex
     */
    public String getName() {
        return name;
    }

    /**
     * Add a new edge to this vertex
     * @param e the new edge
     * @return this new edge
     */
    public Edge addEdge(Edge e){
        String eLabel = e.getLabel();
        if (!edgeMap.containsKey(eLabel)){
            List<Edge> putList = new ArrayList<>();
            putList.add(e);
            edgeMap.put(eLabel, putList);
        }
        else{
            edgeMap.get(eLabel).add(e);
        }
        outDegree++;
        return e;
    }

    /**
     * Get all edges of this vertex
     * @return a map of edges
     */
    public Map<String, List<Edge>> getEdgeMap(){
        return edgeMap;
    }
}
