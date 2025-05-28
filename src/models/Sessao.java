package models;

import java.time.LocalTime;
import java.util.ArrayList;


public class Sessao {
    private boolean estadoDaSessao;
    private int horario;
    private ArrayList<Ingresso> ingressosVendidos;
    private ArrayList<Sala> salas;
    private Filme filme;

    public Sessao(int horario, ArrayList<Integer> nAssentos,
           ArrayList<String> tipoTela,
           ArrayList<String> localizacao){

        this.estadoDaSessao = true;
        setHorario(horario);
        ingressosVendidos = new ArrayList<Ingresso>();
        setSalas(nAssentos, tipoTela, localizacao);
    }

    public Sessao(int horario, Sala salaUnica) {
        if (salaUnica != null){
            salas.add(salaUnica);
        }
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

    public void addSala(int nAssentos, String tipoTela,
                        String localizacao){

        this.salas.add(new Sala(nAssentos, tipoTela, localizacao));
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

    public int getCadeirasDisponiveis(){
        int cadeiras = 0;
        for (Sala s : salas){
            cadeiras += s.getnAssentos();
        }

        return cadeiras - ingressosVendidos.size();
    }

    public void addIngressoVendido(Ingresso ingresso){
        this.ingressosVendidos.add(ingresso);
    }

    @Override
    public String toString() {
        String infoSalas = "";

        for (Sala s : this.salas){
            infoSalas += s.getLocalizacao() + " - ";

        }

        String estadoSessao = "INICIO " + getHorario() + ".";
        if (!isSessaoAvailable()) estadoSessao = "EM ANDAMENTO.";

        return String.format(
                "%s\n" +
                "Sessao de \"%s\"\n" +
                "Salas: %s\n" +
                "Horario: %d:00\n" +
                "Cadeiras diponiveis: %d\n",
                estadoSessao,
                filme.getTitulo(),
                infoSalas,
                getHorario(),
                getCadeirasDisponiveis()
                );
    }
}
