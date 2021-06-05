package maratonaProgramacao.Grafo;

import java.util.ArrayList;

public class Vertice<T> {
    private T dado;
    private ArrayList<Aresta<T>> arestasEntrada;
    private ArrayList<Aresta<T>> arestasSaida;

    public Vertice(T dado){
        this.dado = dado;
        this.arestasEntrada = new ArrayList<>();
        this.arestasSaida = new ArrayList<>();
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
}
