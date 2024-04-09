package org.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Graph {
    private Map<Integer, List<Integer>> adjacency = new HashMap<>();
    private int nodes;

    public Graph() {

    }

    public Graph(int nodes) {
        this.nodes = nodes;
    }

    /**
     * erifică dacă o pereche de noduri există deja în graf
     */
    public boolean pairExists(int left, int right) {
        return this.adjacency.get(left).stream().filter(i -> i == right).collect(Collectors.toList()).size() == 1;
    }

    public void reinitializeGraph() {
        this.adjacency.clear();
    }

    public void createNode(int node) {
        this.adjacency.put(node, new LinkedList<>());
    }

    public void createPair(int left, int right) {
        this.adjacency.get(left).add(right);
        this.adjacency.get(right).add(left);
    }

    public Map<Integer, List<Integer>> getAdjacency() {
        return adjacency;
    }

    public void setAdjacency(Map<Integer, List<Integer>> adjacency) {
        this.adjacency = adjacency;
    }

    public int getNodes() {
        return nodes;
    }

    public void setNodes(int nodes) {
        this.nodes = nodes;
    }
}
