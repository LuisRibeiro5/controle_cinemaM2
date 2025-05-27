package models;

import enums.GeneroFilme;

public class Filme {
    private String titulo;
    private int duracao;
    private GeneroFilme genero;

    Filme(String titulo, int duracao, GeneroFilme genero){
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public GeneroFilme getGenero() {
        return genero;
    }
}
