package control;

import enums.CategoriaIngresso;
import enums.TipoIngresso;
import models.Filme;
import models.Ingresso;
import models.Sala;
import models.Sessao;

import javax.swing.event.InternalFrameEvent;
import java.util.ArrayList;

public class FuncionarioController {
    private static ArrayList<Sessao> sessoes = new ArrayList<>();

    public static void criarSessao(int horario,
                                   ArrayList<Integer> nAssentos,
                                   ArrayList<String> tipoTela,
                                   ArrayList<String> localizacao, Filme filme) {

        sessoes.add(new Sessao(horario, nAssentos, tipoTela, localizacao));
        registrarFilme(filme, horario);
    }

    public static void criarSessao(int horario, Sala salaUnica, Filme filme){
        sessoes.add(new Sessao(horario, salaUnica));
        registrarFilme(filme, horario);
    }

    public static void registrarFilme(Filme filme, int horario){// considerar que haverá somente uma sessao por horario
        for (Sessao s : sessoes){
            if (s.getHorario() == horario) {
                s.setFilme(filme);
            }
        }
    }

    public static void vizualizarSessoesDoDia(){
        for (Sessao s : sessoes){
            System.out.println(s);
        }
    }

    public static Sessao buscarSessao(String nomeFilme, int horario){
        for (Sessao s : sessoes){
            if (s.getFilme().getTitulo().equalsIgnoreCase(nomeFilme) && s.getHorario() == horario){
                return s;
            }
        }
        return null;
    }

    public static Ingresso venderIngresso(Sessao sessao, TipoIngresso tipo,
                                          CategoriaIngresso categoria){
        if (sessao.isSessaoAvailable()){
            Ingresso ingresso = new Ingresso(tipo, categoria, sessao);
            sessao.addIngressoVendido(ingresso);
            return ingresso;
        }

        System.out.printf("Sessao Indisponivel.");
        return null;

    }
}
