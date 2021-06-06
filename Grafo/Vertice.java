package maratonaProgramacao.Grafo;

import java.util.ArrayList;

public class Vertice<T> implements Comparable<Vertice<T>>{
    private T dado;
    private Double distanciaMinima = Double.MAX_VALUE;
    private ArrayList<Aresta<T>> arestasEntrada;
    private ArrayList<Aresta<T>> arestasSaida;

    @Override
    public String toString(){
        StringBuilder st = new StringBuilder();
        st.append("Dado: " + this.getDado() + " ");
        st.append("Distância mínima: " + this.getDistanciaMinima() + " ");
        return st.toString();
    }

    public Vertice(T dado){
        this.dado = dado;
        this.arestasEntrada = new ArrayList<>();
        this.arestasSaida = new ArrayList<>();
    }

    public double getDistanciaMinima() {
        return distanciaMinima;
    }

    public void setDistanciaMinima(double distanciaMinima) {
        this.distanciaMinima = distanciaMinima;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public ArrayList<Aresta<T>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<T>> getArestasSaida() {
        return arestasSaida;
    }

    public void adicionarArestaEntrada(Aresta<T> aresta){
        arestasEntrada.add(aresta);
    }

    public void adicionarArestaSaida(Aresta<T> aresta){
        arestasSaida.add(aresta);
    }

    @Override
    public int compareTo(Vertice<T> o) {
        return this.distanciaMinima.compareTo(o.getDistanciaMinima());
    }
}
