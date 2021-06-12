package maratonaProgramacao.Grafo;

public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();

        /*
        grafo.adicionarVertice("João");
        grafo.adicionarVertice("Lorenzo");
        grafo.adicionarVertice("Claudio");
        grafo.adicionarVertice("Creuza");
        grafo.adicionarVertice("Cleber");

        grafo.adicionarAresta(2.0, "João", "Lorenzo");
        grafo.adicionarAresta(3.0, "Lorenzo", "Cleber");
        grafo.adicionarAresta(3.0, "Lorenzo", "Creuza");
        grafo.adicionarAresta(1.0, "Cleber", "Creuza");
        grafo.adicionarAresta(1.0, "João", "Creuza");
        grafo.adicionarAresta(3.0, "João", "Claudio");
        grafo.adicionarAresta(3.0, "Claudio", "Lorenzo");
        grafo.adicionarAresta(-3.0, "Creuza", "Cleber");
        */
        grafo.adicionarVertice("A");
        grafo.adicionarVertice("B");
        grafo.adicionarVertice("C");
        grafo.adicionarVertice("D");
        grafo.adicionarAresta(1.0, "A", "B");
        grafo.adicionarAresta(0.0, "A", "C");
        grafo.adicionarAresta(10.0, "A", "D");
        grafo.adicionarAresta(-300.0, "D", "B");
        grafo.adicionarAresta(1.0, "B", "C");
        grafo.dijkstra();
    }
}
