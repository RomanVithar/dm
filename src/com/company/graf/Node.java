package com.company.graf;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Node> incident = new ArrayList<Node>();
    List<Integer> weight = new ArrayList<Integer>();
    String name;
    boolean isEnable;
    int label;

    public Node(String name) {
        this.name = name;
    }
}
