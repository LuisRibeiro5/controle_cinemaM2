package models;

import enums.TipoIngresso;
import enums.CategoriaIngresso;

public class Ingresso {
    private Sessao sessao;
    private TipoIngresso tipo;
    private CategoriaIngresso categoria;

    public Ingresso(TipoIngresso tipo, CategoriaIngresso categoria, Sessao sessao){
        this.tipo = tipo;
        this.categoria = categoria;
        this.sessao = sessao;
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public void setTipo(TipoIngresso tipo) {
        this.tipo = tipo;
    }

    public CategoriaIngresso getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaIngresso categoria) {
        this.categoria = categoria;
    }

    public Sessao getSessao() {
        return sessao;
    }

    @Override
    public String toString() {
        return "Ingresso: " + getTipo() +
                " - Categoria: " + getCategoria();
    }
}
