package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import enums.*;
import control.FuncionarioController;
import models.*;
import models.ingresso.Ingresso;
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

        ArrayList<Ingresso> ingressosComprados = new ArrayList<>();

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

                    System.out.print("Tipo de ingresso (1 - Inteiro, 2 - Meia): ");
                    int tipo = scanner.nextInt();
                    TipoIngresso tipoIngresso = (tipo == 2) ? TipoIngresso.MEIA : TipoIngresso.INTEIRO;

                    System.out.print("Categoria do ingresso (1 - Físico, 2 - Online): ");
                    int categoria = scanner.nextInt();
                    CategoriaIngresso categoriaIngresso = (categoria == 2) ?
                            CategoriaIngresso.ONLINE : CategoriaIngresso.FISICO;

                    Ingresso ingresso = FuncionarioController.venderIngresso(sessaoSelecionada,
                            tipoIngresso, categoriaIngresso);

                    if (ingresso != null){
                        ingressosComprados.add(ingresso);
                    }
                }

                case 3 -> {
                    System.out.println("Encerrando o sistema...");
                    executando = false;
                }

                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }
}
