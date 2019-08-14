package com.graph2nl;

import java.util.*;

/**
 *  This is the Direct Graph class
 *
 *  author: Mingchi Li
 *  date 2019.8.8
 */
public class Digraph {
    private Map<Long, Vertex> vertexMap;
    private List<Vertex> outVertices;
    private Map<String, EdgeLabel> edgeLabelMap;
    private Map<String, VertexLabel> vertexLabelMap;

    /**
     * The constructor of this class
     */
    public Digraph() {
        this.vertexMap = new HashMap<Long, Vertex>();
        this.outVertices = new ArrayList<Vertex>();
    }

    /**
     * Load edgeLabelMap from configuration file
     * @param edgeLabelMap map create by config file
     */
    public void setEdgeLabelMap(Map<String, EdgeLabel> edgeLabelMap) {
        this.edgeLabelMap = edgeLabelMap;
    }

    /**
     * Load vertexLabelMap from configuration file
     * @param vertexLabelMap map create by config file
     */
    public void setVertexLabelMap(Map<String, VertexLabel> vertexLabelMap) {
        this.vertexLabelMap = vertexLabelMap;
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
    public List<Vertex> getOutVertices() {
        updateOut();
        return outVertices;
    }

    /**
     * Get a vertex from map by its id
     * @param id the id of this vertex
     * @return the vertex needed
     */
    public Vertex getVertexById(Long id){
        return this.vertexMap.get(id);
    }

    /**
     * Get the vertex label object by its name
     * @param name the name of vertex label
     * @return the vertex label
     */
    public VertexLabel getVertexLabelByName(String name){
        return vertexLabelMap.get(name);
    }

    /**
     * Get the edge label object by it name
     * @param name the name of edge label
     * @return the edge label
     */
    public EdgeLabel getEdgeLabelByName(String name){
        return edgeLabelMap.get(name);
    }

    /**
     * Update the out vertex list
     */
    private void updateOut(){
        Collection<Vertex> vertices = vertexMap.values();
        for (Vertex curr : vertices) {
            if (curr.getOutDegree() > 0 && !outVertices.contains(curr))
                outVertices.add(curr);
        }
        Collections.sort(outVertices);
    }

    /**
     * Add a edge to the graph
     * @param e the edge need to be added
     * @return this edge
     */
    public Edge addEdge(Edge e){
        Vertex fromId = e.getFrom();
        Vertex currV = getVertexById(fromId.getId());
        currV.addEdge(e);
        return e;
    }

    /**
     * The toString method
     * @return the String contain all information of this digraph
     */
    @Override
    public String toString() {
        return "Digraph{" +
                "\nvertexMap=" + vertexMap + ",\n " +
                printOutVertices() +
                ",\n edgeLabelMap=" + edgeLabelMap +
                ",\n vertexLabelMap=" + vertexLabelMap +
                "\n}";
    }

    /**
     * helper method for print the out vertices
     * @return A out vertices string
     */
    private String printOutVertices(){
        StringBuilder builder = new StringBuilder("outVertices = {");
        for (Vertex curr : outVertices){
            builder.append(curr.getId());
            builder.append(", ");
        }
        builder.append("}");
        return builder.toString();
    }

    /**
     * Describe this graph using english
     */
    public void toEnglish(){
        updateOut();
        Integer numOut = outVertices.size();
        System.out.print("\nWe are going to describe " + numOut);
        if (numOut <= 1){
            System.out.println(" vertex:");
        }
        else {
            System.out.println(" vertices:");
        }
        for (Vertex currV : outVertices){
            System.out.println("-----------------------------------");
             if (currV.getEdgeMap().containsKey("is")){
                 List<Edge> listV = currV.getEdgeMap().get("is");
                 for (Edge e : listV) {
                     System.out.println(currV.getLabel() + ": " + currV.getName() + " is " + vertexMap.get(e.getTo()).getName() + ".");
                 }
             }
             for (EdgeLabel label : currV.getEdgeMap().keySet()){
                 if (!label.equals("is")){
                     List<Edge> edgeList = currV.getEdgeMap().get(label);
                     int size = edgeList.size();
                     System.out.print(currV.getLabel() + ": " + currV.getName() + " " + label + " ");
                     System.out.print("[");
                     for (Edge e : edgeList){
                         Vertex distV = vertexMap.get(e.getTo());
                         System.out.print(distV.getLabel() + ": " + distV.getName() + "; ");
                     }
                     System.out.println("]");
                 }
             }
        }
    }

    /**
     * Describe this graph using Chinese
     */
    public void toChinese(){
        updateOut();
        Integer numOut = outVertices.size();

        System.out.println("\n我们要描述以下" + numOut + "个节点：");

        for (Vertex currV : outVertices){
            System.out.println("-----------------------------------");
            if (currV.getEdgeMap().containsKey("是")){
                List<Edge> listV = currV.getEdgeMap().get("是");
                for (Edge e : listV) {
                    System.out.println(currV.getLabel() + ": " + currV.getName() + " 是 "
                            + vertexMap.get(e.getTo()).getName() + ".");
                }
            }
            for (EdgeLabel label : currV.getEdgeMap().keySet()){
                if (!label.equals("是")){
                    List<Edge> edgeList = currV.getEdgeMap().get(label);
                    int size = edgeList.size();
                    System.out.print(currV.getLabel() + ": " + currV.getName() + " " + label);
                    System.out.print(" [");
                    for (Edge e : edgeList){
                        Vertex distV = vertexMap.get(e.getTo());
                        System.out.print(distV.getLabel() + ": " + distV.getName() + "; ");
                    }
                    System.out.println("]");
                }
            }
        }
    }
}
