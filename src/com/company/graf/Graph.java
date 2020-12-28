package com.company.graf;

import java.util.HashMap;

public class Graph {
    private HashMap<String, Node> graph = new HashMap<String, Node>();

    public void add(String value) {
        graph.put(value, new Node(value));
    }

    public void setConnect(String first, String second, int weight) {
        graph.get(first).incident.add(graph.get(second));
        graph.get(second).incident.add(graph.get(first));
        graph.get(first).weight.add(weight);
        graph.get(second).weight.add(weight);
    }

    public HashMap<String, Integer> AlgorithmDijkstra(String vertex) {
        HashMap<String, Integer> mapDijkstra = new HashMap<>();
        prepare(vertex);
        alg(graph.get(vertex));
        for (String key : graph.keySet()) {
            mapDijkstra.put(key, graph.get(key).label);
        }
        return mapDijkstra;
    }

    private void prepare(String vertex) {
        for (String key : graph.keySet()) {
            graph.get(key).isEnable = true;
            if (graph.get(key).name.equals(vertex)) {
                graph.get(key).label = 0;
            } else {
                graph.get(key).label = -1;
            }
        }
    }

    private void alg(Node current) {
        for(int i = 0;i<current.incident.size();i++) {
            if(current.incident.get(i).label == -1) {
                current.incident.get(i).label = current.weight.get(i) + current.label;
            }else{
                if( current.incident.get(i).label >current.weight.get(i)+current.label){
                    current.incident.get(i).label = current.weight.get(i) + current.label;
                }
            }
        }
        current.isEnable = false;
        for(int i = 0;i<current.incident.size();i++) {
            if(current.incident.get(i).isEnable) {
                alg(current.incident.get(i));
            }
        }
    }
}
