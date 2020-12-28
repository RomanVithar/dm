package com.company;

import com.company.graf.Graph;
import com.company.tree.Tree;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        //testTree();
        testGraph();
    }

    public static void testTree() {
        Tree tree = new Tree();
        tree.insert(6);
        tree.insert(4);
        tree.insert(8);
        tree.insert(1);
        tree.insert(5);
        tree.insert(7);
        tree.insert(10);
        System.out.println("Обход в глубину: ");
        tree.depthFirstWalk();
        System.out.println("Обход в ширину: ");
        tree.breadthFirstWalk();
    }

    public static void testGraph() {
        Graph graph = new Graph();
        graph.add("1");
        graph.add("2");
        graph.add("3");
        graph.add("4");
        graph.add("5");
        graph.add("6");
        graph.setConnect("1", "2", 7);
        graph.setConnect("1", "3", 9);
        graph.setConnect("1", "6", 14);
        graph.setConnect("2", "3", 10);
        graph.setConnect("2", "4", 15);
        graph.setConnect("3", "4", 11);
        graph.setConnect("3", "6", 2);
        graph.setConnect("6", "5", 9);
        graph.setConnect("4", "5", 6);

        // граф по ссылке
        // https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%94%D0%B5%D0%B9%D0%BA%D1%81%D1%82%D1%80%D1%8B

        HashMap<String, Integer> stringIntegerHashMap = graph.AlgorithmDijkstra("1");
        for(String key: stringIntegerHashMap.keySet()) {
            System.out.println(key + " -- " + stringIntegerHashMap.get(key));
        }
    }
}
