package models.ingresso;

import enums.CategoriaIngresso;
import enums.TipoIngresso;
import models.Sessao;

public class Ingresso implements InterfaceIngresso {
    private Sessao sessao;
    private CategoriaIngresso categoria;

    public Ingresso(CategoriaIngresso categoria, Sessao sessao){
        this.categoria = categoria;
        this.sessao = sessao;
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
    public double getPreco(){
        return sessao.getPrecoBase();
    }

    @Override
    public String getDescricao() {
        return "Ingresso: " + getCategoria() + " Inteiro";
    }
}
