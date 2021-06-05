package maratonaProgramacao.Grafo;

import java.util.ArrayList;

public class Grafo<T> {
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;

    public Grafo(){
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }

    public void adicionarVertice(T dado){
        Vertice<T> novoVertice = new Vertice<>(dado);
        vertices.add(novoVertice);
    }

    public void adicionarAresta(Double peso, T inicio, T fim){
        Vertice<T> origem = getVertice(inicio);
        Vertice<T> destino = getVertice(fim);
        Aresta<T> aresta = new Aresta<>(peso,origem,destino);
        origem.adicionarArestaSaida(aresta);
        destino.adicionarArestaEntrada(aresta);
        arestas.add(aresta);
    }

    public Vertice<T> getVertice(T dado){
        Vertice<T> vertice = null;
        for(Vertice<T> vert : vertices){
            if(vert.getDado().equals(dado)){
                vert = vertice;
                break;
            }
        }
        return vertice;
    }
}
