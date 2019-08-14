package com.graph2nl;

import java.util.Objects;

/**
 * This is the edge label class
 *
 * author: Mingchi Li
 * date: 2019.8.14
 */
public class EdgeLabel implements Comparable<EdgeLabel>{
    private Long priority;
    private String name;
    private String prefix;
    private String postfix;

    /**
     * The constructor of this class
     * @param name the label name of this label
     */
    public EdgeLabel(String name) {
        this.name = name;
        this.priority = Long.MAX_VALUE;
        this.prefix = "";
        this.postfix = "";
    }

    /**
     * Get the print priority of this label
     * @param priority
     */
    public void setPriority(Long priority) {
        this.priority = priority;
    }

    /**
     * set it's prefix string for printing
     * @param prefix the string before the label name
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * set it's postfix string for printing
     * @param postfix the string after the label name
     */
    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

    /**
     * get the priority of this edge label
     * @return the priority value of this label
     */
    public Long getPriority() {
        return priority;
    }

    /**
     * Override the origin equals method
     * @param o the other object need to be compared with this one
     * @return is those two object equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EdgeLabel edgeLabel = (EdgeLabel) o;
        return name.equals(edgeLabel.name);
    }

    /**
     * Override the origin hashCode method
     * @return the hash value of this edge
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Override the compareTo method
     * @param o the other edge label
     * @return the result
     */
    @Override
    public int compareTo(EdgeLabel o) {
        return priority.compareTo(o.getPriority());
    }

    /**
     * combine prefix name and post together to a new string
     * @return the new string
     */
    @Override
    public String toString() {
        return prefix + ' ' + name + ' ' + postfix;
    }
}
