package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import enums.*;
import control.FuncionarioController;
import models.*;
import models.ingresso.Ingresso;
import models.ingresso.InterfaceIngresso;
import view.InputView;
import view.MensagemView;
import view.MenuView;
import view.SessaoView;

public class TestCinema {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //filmes
        Filme filme1 = new Filme("Matrix", 136, GeneroFilme.ACAO);
        Filme filme2 = new Filme("O Senhor dos Anéis", 178, GeneroFilme.AVENTURA);

        ArrayList<Integer> nAssentos = new ArrayList<>(List.of(3, 2, 4));
        ArrayList<String> tipoTela = new ArrayList<>(List.of("2D", "3D", "2D"));
        ArrayList<String> localizacao = new ArrayList<>(List.of("1","2","3"));

        FuncionarioController.criarSessao(21, nAssentos, tipoTela, localizacao, filme1);
        FuncionarioController.criarSessao(22, new Sala(1, "3D", "4"), filme2);

        ArrayList<InterfaceIngresso> ingressosComprados = new ArrayList<>();

        boolean executando = true;

        while (executando) {
            MenuView.exibirMenu();
            int opcao = InputView.lerOpcao();

            switch (opcao) {
                //visualizar sessoes do dia
                case 1 -> SessaoView.exibirListaSessoes(FuncionarioController.getSessoes());

                case 2 -> {
                //vender ingresso
                    SessaoView.exibirListaSessoes(FuncionarioController.getSessoes());
                    int horario = InputView.lerHorarioSessao();
                    String nomeFilme = InputView.lerTituloFilme();

                    Sessao sessaoSelecionada = FuncionarioController.buscarSessao(nomeFilme, horario);

                    if (sessaoSelecionada == null) {
                        MensagemView.exibirErro("Sessão não encontrada ou indisponível.");
                        break;
                    }

                    int categoria = InputView.lerCategoriaIngresso();
                    CategoriaIngresso categoriaIngresso = (categoria == 2) ?
                            CategoriaIngresso.ONLINE : CategoriaIngresso.FISICO;

                    InterfaceIngresso ingresso = FuncionarioController.venderIngresso(sessaoSelecionada, categoriaIngresso);

                    if (ingresso != null){
                        ingressosComprados.add(ingresso);
                    }
                }

                case 3 -> {
                    MensagemView.exibirInfo("Encerrando o sistema...");
                    executando = false;
                }

                default -> MensagemView.exibirErro("Opção inválida. Tente novamente.");
            }
        }

    }
}
