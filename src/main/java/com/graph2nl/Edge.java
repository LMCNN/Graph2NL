package com.graph2nl;

import java.util.Objects;

/**
 * This is the edge class for our graph
 *
 * Date: 2019.8.7
 * author: Mingchi Li
 */
public class Edge {
    private Integer id;
    private Integer from;
    private Integer to;
    private String label;

    /**
     * Constructor of the Edge class
     * @param from The starting point of the edge
     * @param to Edge termination point
     * @param label Edge label
     */
    public Edge(Integer id, Integer from, Integer to, String label) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.label = label;
    }

    /**
     * Get the vertex Id of this edge
     * @return current edge id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Get the vertex Id of current vertex
     * @return current vertex id
     */
    public Integer getFrom() {
        return from;
    }

    /**
     * Get the vertex Id of this edge points to
     * @return dist vertex id
     */
    public Integer getTo() {
        return to;
    }

    /**
     * Get the label of this edge
     * @return the label name
     */
    public String getLabel() {
        return label;
    }

    /**
     * If two edges have the same id, then these two edge are the same
     * @param o the other edge
     * @return Whether these two edges are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(id, edge.id) ;
    }

    /**
     * The to string method
     * @return A string of current edge
     */
    @Override
    public String toString() {
        return from + "-" + label + "->" + to;
    }

    /**
     * the hashCode method
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(from, to, label);
    }
}
