package model;

import java.util.HashSet;
import java.util.Set;

public class Grafo {


    private Set<Node> nodes = new HashSet<>();

    public Grafo addNode(Node node){
        nodes.add(node);
        return this;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}
