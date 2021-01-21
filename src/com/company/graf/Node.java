package com.company.graf;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Node> incident = new ArrayList<Node>();
    List<Integer> weight = new ArrayList<Integer>();
    String name;

    public Node(String name) {
        this.name = name;
    }
}
