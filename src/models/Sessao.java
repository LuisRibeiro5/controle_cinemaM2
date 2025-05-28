package models;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sessao {
    private boolean estadoDaSessao;
    private int horario;
    private ArrayList<Sala> salas;
    private ArrayList<Ingresso> ingressos;
    private Filme filme;

    public Sessao(int horario, List<Sala> salas, Filme filme){
        setHorario(horario);
        setSala(salas);
        registrarFilme(filme);
        this.ingressos = new ArrayList<>();
        this.estadoDaSessao = true;
    }

    public boolean isSessionAvaible(){
        calculaEstadoDaSessao();
        return estadoDaSessao;
    }

    public void calculaEstadoDaSessao(){
        LocalTime agora = LocalTime.now();
        LocalTime InicioSessao = LocalTime.of(this.horario,0);
        if (InicioSessao.isBefore(agora)){
            estadoDaSessao = false;
        } else
            estadoDaSessao = true;
    }

    public List<Sala> getSala() {
        return new ArrayList<>(salas);
    }

    public void setSala(List<Sala> salas) {
        if (salas == null || salas.isEmpty()) {
            throw new IllegalArgumentException("Sessão deve ter ao menos uma sala.");
        }
        this.salas = new ArrayList<>(salas);
    }

    public void addSala(Sala sala) {
        if (sala != null) {
            this.salas.add(sala);
        } else {
            throw new IllegalArgumentException("Sala não pode ser nula.");
        }
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        if (horario < 0 || horario > 23) {
            throw new IllegalArgumentException("Horário deve estar entre 0 e 23.");
        }
        this.horario = horario;
    }

    public List<Ingresso> getIngressos() {
        return new ArrayList<>(ingressos);
    }

    public void adicionarIngresso(Ingresso ingresso) {
        if (ingresso != null && cadeirasDisponiveis() > 0) {
            ingressos.add(ingresso);
        }
    }

    public int cadeirasDisponiveis(){
        int totalAssentos = 0;
        for (Sala s : salas){
            totalAssentos += s.getnAssentos();
        }
        return totalAssentos - ingressos.size();
    }

    public void registrarFilme(Filme filme) {
        if (filme != null) {
            this.filme = filme;
        }
    }

    public Filme getFilme() {
        return filme;
    }

    public int totalIngressosVendidos(){
        return ingressos.size();
    }
}


