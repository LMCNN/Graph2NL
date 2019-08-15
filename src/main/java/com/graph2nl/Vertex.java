package com.graph2nl;

import java.util.*;

/**
 * The vertex class
 *
 * author: Mingchi Li
 * date; 2019.8.8
 */
public class Vertex implements Comparable<Vertex>{
    private Long id;
    private Integer outDegree;
    private Map<EdgeLabel, List<Edge>> edgeMap;
    private VertexLabel label;
    private String name;

    /**
     * The constructor for the vertex class
     * @param id the id of the vertex
     * @param label vertex label
     * @param name the name of the vertex
     */
    public Vertex(Long id, VertexLabel label, String name) {
        this.id = id;
        this.edgeMap = new TreeMap<>();
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
    public Long getId() {
        return id;
    }

    /**
     * Gets the label of the current vertex
     * @return the label of this vertex
     */
    public VertexLabel getLabel() {
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
        EdgeLabel eLabel = e.getLabel();
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
    public Map<EdgeLabel, List<Edge>> getEdgeMap(){
        return edgeMap;
    }

    /**
     * Determine whether two vertices are equal
     * If they have same id they are equal
     * @param o the other vertex
     * @return the result
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return id.equals(vertex.id);
    }

    /**
     * Hash method
     * @return hash value of the id
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * The toString method
     * @return A String contains all information of this vertex
     */
    @Override
    public String toString() {
        return "Vertex\n{" +
                "\n\tid=" + id +
                ", \n\toutDegree=" + outDegree +
                ", \n\tedgeMap=" + edgeMap +
                ", \n\tlabel='" + label.getName() + '\'' +
                ", \n\tname='" + name + '\'' +
                "\n}";
    }

    /**
     * Helper method to print the edge map
     * @return String of the edge map
     */
    private String printMap(){
        return null;
    }

    /**
     * compare two vertices by their label priority
     * @param o the other vertex
     * @return the result
     */
    @Override
    public int compareTo(Vertex o) {
        return label.compareTo(o.getLabel());
    }
}
