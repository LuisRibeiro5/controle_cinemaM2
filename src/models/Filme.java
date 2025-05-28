package models;

import enums.GeneroFilme;

public class Filme {
    private String titulo;
    private int duracao;
    private GeneroFilme genero;

    public Filme(String titulo, int duracao, GeneroFilme genero){
        setTitulo(titulo);
        setDuracao(duracao);
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (!titulo.isBlank()){
            this.titulo = titulo;
        }
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        if (duracao > 0){
            this.duracao = duracao;
        }
    }

    public GeneroFilme getGenero() {
        return genero;
    }

    public void setGenero(GeneroFilme genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Filme: " + getTitulo() +
                " - Duracao: " + getDuracao() +
                "- Genero: " + getGenero();
    }
}
