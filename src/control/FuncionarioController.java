package control;

import enums.CategoriaIngresso;
import models.Filme;
import models.ingresso.*;
import models.Sala;
import models.Sessao;
import view.InputView;
import view.MensagemView;

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

    public static Sessao buscarSessao(String nomeFilme, int horario){
        for (Sessao s : sessoes){
            if (s.getFilme().getTitulo().equalsIgnoreCase(nomeFilme) && s.getHorario() == horario){
                return s;
            }
        }
        return null;
    }

    public static InterfaceIngresso venderIngresso(Sessao sessao,
                                          CategoriaIngresso categoria){
        if (sessao.isSessaoAvailable()){
            InterfaceIngresso ingresso = new Ingresso(categoria, sessao);

            boolean escolhendo = true;
            while (escolhendo) {
                int adicional = InputView.lerTipoIngresso();

                switch (adicional) {
                    case 1:
                        ingresso = new IngressoMeia(ingresso);
                        break;
                    case 2:
                        ingresso = new IngressoVip(ingresso);
                        break;
                    case 3:
                        ingresso = new IngressoComPipoca(ingresso);
                        break;
                    case 0:
                        escolhendo = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                MensagemView.exibirInfo(adicional);
            }


            sessao.addIngressoVendido(ingresso);

            MensagemView.exibirSucesso("Seu ingresso foi adicionado com sucesso. \n" + ingresso.getDescricao() + " -" +
                    " " + ingresso.getPreco());
            return ingresso;
        }

        return null;
    }

    public static ArrayList<Sessao> getSessoes(){
        return sessoes;
    }
}
