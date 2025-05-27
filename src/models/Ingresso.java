package models;

import enums.TipoIngresso;
import enums.CategoriaIngresso;

public class Ingresso {
    private TipoIngresso tipo;
    private CategoriaIngresso categoria;

    Ingresso(TipoIngresso tipo, CategoriaIngresso categoria){
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public CategoriaIngresso getCategoria() {
        return categoria;
    }
}
