package controller;

import model.Grafo;
import model.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DijkstraImpl {

    public Grafo calcularMenorCaminho(Grafo grafo, Node origem) {
        origem.setDistancia(0);

        Set<Node> nodesSetados = new HashSet<>();
        Set<Node> nodesNaoSetados = new HashSet<>();

        nodesNaoSetados.add(origem);

        while (nodesNaoSetados.size() != 0) {
            Node nodeAtual = getNodeMenorDistancia(nodesNaoSetados);
            nodesNaoSetados.remove(nodeAtual);
            for (Map.Entry<Node, Integer> parAdjacente : nodeAtual.getNodesAdjacentes().entrySet()) {
                Node nodeAdjacente = parAdjacente.getKey();
                Integer largura = parAdjacente.getValue();
                if (!nodesSetados.contains(nodeAdjacente)) {
                    calcularDistanciaMinima(nodeAdjacente, largura, nodeAtual);
                    nodesNaoSetados.add(nodeAdjacente);
                }
            }
            nodesSetados.add(nodeAtual);
        }
        return grafo;
    }

    private Node getNodeMenorDistancia(Set<Node> nodesNaoSetados) {
        Node nodeMenorDistancia = null;
        int menorDistancia = Integer.MAX_VALUE;
        for (Node node : nodesNaoSetados) {
            int nodeDistancia = node.getDistancia();
            if (nodeDistancia < menorDistancia) {
                menorDistancia = nodeDistancia;
                nodeMenorDistancia = node;
            }
        }
        return nodeMenorDistancia;
    }

    private void calcularDistanciaMinima(Node nodeAtual, Integer largura, Node nodeOrigem) {
        Integer distanciaOrigem = nodeOrigem.getDistancia();
        if (distanciaOrigem + largura < nodeAtual.getDistancia()) {
            nodeAtual.setDistancia(distanciaOrigem + largura);
            LinkedList<Node> menorCaminho = new LinkedList<>(nodeOrigem.getMenorCaminho());
            menorCaminho.add(nodeOrigem);
            nodeAtual.setMenorCaminho(menorCaminho);
        }
    }
}
