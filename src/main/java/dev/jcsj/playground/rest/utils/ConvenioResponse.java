package dev.jcsj.playground.rest.utils;

import java.util.ArrayList;

public class ConvenioResponse {

    private ArrayList<ListaConvenios> listaConvenios;

    private int quantidadeRegistros;

    public ArrayList<ListaConvenios> getListaConvenios() {
        return listaConvenios;
    }

    public void setListaConvenios(ArrayList<ListaConvenios> listaConvenios) {
        this.listaConvenios = listaConvenios;
    }

    public int getQuantidadeRegistros() {
        return quantidadeRegistros;
    }

    public void setQuantidadeRegistros(int quantidadeRegistros) {
        this.quantidadeRegistros = quantidadeRegistros;
    }

}
