package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    private Map<Node, Integer> nodesAdjacentes = new HashMap<>();
    private String nome;
    private List<Node> menorCaminho = new LinkedList<>();
    private Integer distancia = Integer.MAX_VALUE;


    public Node(String nome) {
        this.nome = nome;
    }

    public Node addDestino(Node destino, int distancia) {
        nodesAdjacentes.put(destino, distancia);
        return this;
    }

    public Map<Node, Integer> getNodesAdjacentes() {
        return nodesAdjacentes;
    }

    public void setNodesAdjacentes(Map<Node, Integer> nodesAdjacentes) {
        this.nodesAdjacentes = nodesAdjacentes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Node> getMenorCaminho() {
        return menorCaminho;
    }

    public void setMenorCaminho(List<Node> menorCaminho) {
        this.menorCaminho = menorCaminho;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return nome;
    }
}
