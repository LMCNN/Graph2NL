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
    private Map<String, Edge> edgeMap;
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
}
