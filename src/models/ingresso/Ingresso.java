package models.ingresso;

import enums.TipoIngresso;
import models.Sessao;

public class Ingresso implements InterfaceIngresso {
    private Sessao sessao;
    private TipoIngresso tipo;

    public Ingresso(TipoIngresso tipo, Sessao sessao){
        this.tipo = tipo;
        this.sessao = sessao;
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public void setTipo(TipoIngresso tipo) {
        this.tipo = tipo;
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
        return "Ingresso: " + getTipo() + " Inteiro";
    }
}
