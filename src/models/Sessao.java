package models;

import java.time.LocalTime;
import java.util.ArrayList;


public class Sessao {
    private boolean estadoDaSessao;
    private int horario;
    private ArrayList<Ingresso> ingressos;
    private ArrayList<Sala> salas;
    private Filme filme;

    Sessao(int horario, ArrayList<Integer> nAssentos,
           ArrayList<String> tipoTela,
           ArrayList<String> localizacao){

        this.estadoDaSessao = true;
        setHorario(horario);
        ingressos = new ArrayList<Ingresso>();
        setSalas(nAssentos, tipoTela, localizacao);
    }

    public boolean isSessaoAvailable() {
        calculaEstadoDaSessao(this.estadoDaSessao);
        return estadoDaSessao;
    }

    private void calculaEstadoDaSessao(boolean estadoDaSessao) {
        LocalTime agora = LocalTime.now();
        LocalTime inicioSessao = LocalTime.of(this.horario, 0);

        if (inicioSessao.isBefore(agora)){
            this.estadoDaSessao = false; //sessao ja passou.
        }
    }

    public void setSalas(ArrayList<Integer> nAssentos,
                        ArrayList<String> tipoTela,
                        ArrayList<String> localizacao) {

        if (nAssentos.size() == tipoTela.size() &&
        localizacao.size() == nAssentos.size()){

            for (int i = 0; i < nAssentos.size(); i++){

                this.salas.add( new Sala(nAssentos.get(i),
                        tipoTela.get(i), localizacao.get(i)) );
            }
        }
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        if (horario >= 0 && horario <= 23){
            this.horario = horario;
        }
    }

}
