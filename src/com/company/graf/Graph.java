package com.company.graf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    private HashMap<String, Node> graph = new HashMap<String, Node>();
    private List<Node> exitList = new ArrayList<>();

    public void add(String value) {
        graph.put(value, new Node(value));
    }

    public void setConnect(String first, String second, int weight) {
        graph.get(first).incident.add(graph.get(second));
        graph.get(second).incident.add(graph.get(first));
        graph.get(first).weight.add(weight);
        graph.get(second).weight.add(weight);
    }

    // выводит минимальное оставное дерево (алгоритм дейкстры прима)
    public void AlgorithmDijkstra(String firstVertex) {
        exitList = new ArrayList<>();
        exitList.add(graph.get(firstVertex));
        int endSize = graph.keySet().size();
        while(exitList.size()!=endSize) {
            Integer min = 100000;
            Node minNode = null;
            Node parentNode = null;
            for(Node item:exitList){
                for(int i=0;i<item.incident.size();i++) {
                    if(item.weight.get(i)<min && !isItVertexInExitList(item.incident.get(i))){
                        min = item.weight.get(i);
                        minNode = item.incident.get(i);
                        parentNode = item;
                    }
                }
            }
            System.out.println(parentNode.name + " --> "+ minNode.name);
            exitList.add(minNode);
        }
    }

    private boolean isItVertexInExitList(Node node) {
        for(Node item:exitList){
            if(item == node){
                return true;
            }
        }
        return false;
    }
}
