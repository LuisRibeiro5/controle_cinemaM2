package models;

import java.util.ArrayList;

public class Sessao {
    private boolean estadoDaSessao;
    private int horario;
    private Filme filme;
    private ArrayList<Ingresso> ingressos;
    private Sala sala;

    Sessao(boolean estadoDaSessao, int horario, Sala sala){
        this.estadoDaSessao = estadoDaSessao;
        this.horario = horario;
        this.sala = sala;
    }

    public void registrarFilme(Filme filme){
        this.filme = filme;
    }

    public void cadeirasDisponiveis(){
        System.out.println("numero de cadeiras diponiveis - " + (sala.getnAssentos() - ingressos.size()));
    }

    @override
    public String toString(){
        return this.filme.getTitulo() + " - horario: " + this.horario + " - Sala: " + this.sala.getLocalizacao();
    }
}
