package maratonaProgramacao.Grafo;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

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
        ArrayList<Vertice<T>> visitados = new ArrayList<>();
        ArrayList<Vertice<T>> fila = new ArrayList<>();
        Vertice<T> atual = vertices.get(0);
        atual.setDistanciaMinima(0);
        visitados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        while(!fila.isEmpty()){
            Vertice<T> visitado = fila.get(0);
            for(int i = 0; i < visitado.getArestasSaida().size(); i++){
                Vertice<T> proximo = visitado.getArestasSaida().get(i).getDestino();
                if(!visitados.contains(proximo)){
                    visitados.add(proximo);
                    fila.add(proximo);
                    System.out.println(proximo.getDado());
                }
            }
            fila.remove(0);
        }

    }

    public void dijkstra(){
        ArrayList<Vertice<T>> visitados = new ArrayList<>();
        Queue<Vertice<T>> fila = new PriorityQueue<>();
        Vertice<T> atual = vertices.get(0);
        atual.setDistanciaMinima(0);
        visitados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        while(!fila.isEmpty()){
            Vertice<T> visitado = fila.peek();
            for(int i = 0; i < visitado.getArestasSaida().size(); i++){
                Vertice<T> proximo = visitado.getArestasSaida().get(i).getDestino();
                /*O processo de relaxamento consiste em
                comparar a distância mínima do vizinho com distância Mínima do vertice expandido + peso do vizinho
                se a primeira for maior, então está é atualizada com a soma do segundo */
                double distanciaParOrigem = visitado.getDistanciaMinima() + visitado.getArestasSaida().get(i).getPeso();
                if(proximo.getDistanciaMinima() > distanciaParOrigem){
                    proximo.setDistanciaMinima(distanciaParOrigem);
                    System.out.println(proximo);
                }

                /* se visitado ainda não foi visitado, então deve-se fazer o processo de expansão*/
                if(!visitados.contains(proximo)){
                    visitados.add(proximo);
                    fila.add(proximo);
                }
            }
            fila.poll();
        }

    }
}
