import controller.DijkstraImpl;
import model.Grafo;
import model.Node;

public class App {

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestino(nodeB, 10);
        nodeA.addDestino(nodeC, 15);

        nodeB.addDestino(nodeD, 12);
        nodeB.addDestino(nodeF, 15);

        nodeC.addDestino(nodeE, 10);

        nodeD.addDestino(nodeE, 2);
        nodeD.addDestino(nodeF, 1);

        nodeF.addDestino(nodeE, 5);

        Grafo grafo = new Grafo();

        grafo.addNode(nodeA);
        grafo.addNode(nodeB);
        grafo.addNode(nodeC);
        grafo.addNode(nodeD);
        grafo.addNode(nodeE);
        grafo.addNode(nodeF);


        DijkstraImpl dijkstra = new DijkstraImpl();
        dijkstra.calcularMenorCaminho(grafo, nodeA);

        grafo.getNodes().forEach((node -> System.out.println("Nó: " + node.getNome() + " - Menor Caminho: " + node.getMenorCaminho() + " - Distância: " + node.getDistancia())));
    }
}
