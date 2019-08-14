package com.graph2nl;

/**
 * This this the VertexLabel class
 *
 * author: Mingchi Li
 * date: 2019.8.14
 */
public class VertexLabel implements Comparable<VertexLabel>{
    private String name;
    private Integer priority;

    /**
     * The constructor of this class
     * @param name the name of this vertex
     */
    public VertexLabel(String name) {
        this.name = name;
        this.priority = Integer.MAX_VALUE;
    }

    /**
     * Set the priority of this label type of vertex
     * @param priority the priority
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * Get the label name of this vertex
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get the priority of this vertex
     * @return
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * Override the compareTo method
     * @param o the other VertexLabel object
     * @return the result
     */
    @Override
    public int compareTo(VertexLabel o) {
        return this.priority.compareTo(o.getPriority());
    }

    @Override
    public String toString() {
        return " " + name + " ";
    }
}
