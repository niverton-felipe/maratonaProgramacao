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
                vertice = vert;
                break;
            }
        }
        return vertice;
    }

    public void buscaEmLargura(){
        ArrayList<Vertice<T>> marcados = new ArrayList<>();
        ArrayList<Vertice<T>> fila = new ArrayList<>();
        Vertice<T> atual = vertices.get(0);
        marcados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        while(fila.size() > 0){
            Vertice<T> visitado = fila.get(0);
            for(int i = 0; i < visitado.getArestasSaida().size(); i++){
                Vertice<T> proximo = visitado.getArestasSaida().get(i).getDestino();
                if(!marcados.contains(proximo)){
                    marcados.add(proximo);
                    fila.add(proximo);
                    System.out.println(proximo.getDado());
                }
            }
            fila.remove(0);
        }

    }
}
