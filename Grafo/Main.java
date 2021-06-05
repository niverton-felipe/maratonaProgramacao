package maratonaProgramacao.Grafo;

public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();
        grafo.adicionarVertice("João");
        grafo.adicionarVertice("Lorenzo");
        grafo.adicionarVertice("Claudio");
        grafo.adicionarVertice("Creuza");
        grafo.adicionarVertice("Cleber");

        grafo.adicionarAresta(2.0, "João", "Lorenzo");
        grafo.adicionarAresta(3.0, "Lorenzo", "Cleber");
        grafo.adicionarAresta(1.0, "Cleber", "Creuza");
        grafo.adicionarAresta(1.0, "João", "Creuza");
        grafo.adicionarAresta(3.0, "João", "Claudio");
        grafo.adicionarAresta(3.0, "Claudio", "Lorenzo");

        grafo.buscaEmLargura();
    }
}
