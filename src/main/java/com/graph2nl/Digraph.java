package com.graph2nl;

import java.util.*;

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
        updateOut();
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
    private void updateOut(){
        for (Integer key : vertexMap.keySet()) {
            Vertex tmp = vertexMap.get(key);
            if (tmp.getOutDegree() > 0 && !outVertices.contains(key))
                outVertices.add(key);
        }
    }

    /**
     * Add a edge to the graph
     * @param e the edge need to be added
     * @return this edge
     */
    public Edge addEdge(Edge e){
        Integer fromId = e.getFrom();
        Vertex currV = getVertexById(fromId);
        currV.addEdge(e);
        return e;
    }

    /**
     * The toString method
     * @return the String contain all information of this digraph
     */
    @Override
    public String toString() {
        updateOut();
        return "Digraph\n{\n" +
                "\t\nvertexMap=" + vertexMap.toString() +
                ", \noutVertices=" + outVertices +
                "\n}";
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
        for (int i = 0; i < numOut; i++){
            System.out.println("-----------------------------------");
            Vertex currV = getVertexById(outVertices.get(i));
             if (currV.getEdgeMap().containsKey("is")){
                 List<Edge> listV = currV.getEdgeMap().get("is");
                 for (Edge e : listV) {
                     System.out.println(currV.getLabel() + " " + currV.getName() + " is " + vertexMap.get(e.getTo()).getName() + ".");
                 }
             }
             for (String label : currV.getEdgeMap().keySet()){
                 if (!label.equals("is")){
                     List<Edge> edgeList = currV.getEdgeMap().get(label);
                     int size = edgeList.size();
                     System.out.print(currV.getLabel() + " " + currV.getName() + " " + label + " to ");
                     System.out.print("[");
                     for (Edge e : edgeList){
                         Vertex distV = vertexMap.get(e.getTo());
                         System.out.print(distV.getLabel() + " " + distV.getName() + "; ");
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

        for (int i = 0; i < numOut; i++){
            System.out.println("-----------------------------------");
            Vertex currV = getVertexById(outVertices.get(i));
            if (currV.getEdgeMap().containsKey("是")){
                List<Edge> listV = currV.getEdgeMap().get("是");
                for (Edge e : listV) {
                    System.out.println(currV.getLabel() + ": " + currV.getName() + " 是 "
                            + vertexMap.get(e.getTo()).getName() + ".");
                }
            }
            for (String label : currV.getEdgeMap().keySet()){
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
