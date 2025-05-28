package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import enums.*;
import control.FuncionarioController;
import models.*;

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
            System.out.println("\n--- Sistema de Administração do Cinema ---");
            System.out.println("1. Exibir Sessões Do Dia");
            System.out.println("2. Vender Ingresso");
            System.out.println("3. Encerrar Programa");
            System.out.print("Escolha uma opção: ");

            int opcao = lerInt(scanner);
            switch (opcao) {
                case 1 -> FuncionarioController.vizualizarSessoesDoDia();

                case 2 -> {
                   FuncionarioController.vizualizarSessoesDoDia();
                    System.out.print("Digite o horário da sessão desejada: ");
                    int horario = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o nome do filme: ");
                    String nomeFilme = scanner.nextLine();

                    Sessao sessaoSelecionada = null;
                    sessaoSelecionada = FuncionarioController.buscarSessao(nomeFilme, horario);

                    if (sessaoSelecionada == null) {
                        System.out.println("Sessão não encontrada ou indisponível.");
                        break;
                    }

                    System.out.print("Tipo de ingresso (1 - Inteiro, 2 - Meia): ");
                    int tipo = scanner.nextInt();
                    TipoIngresso tipoIngresso = (tipo == 2) ? TipoIngresso.MEIA : TipoIngresso.INTEIRO;

                    System.out.print("Categoria do ingresso (1 - Físico, 2 - Online): ");
                    int categoria = scanner.nextInt();
                    CategoriaIngresso categoriaIngresso = (categoria == 2) ?
                            CategoriaIngresso.INGRESSO_ONLINE : CategoriaIngresso.INGRESSO_FISICO;

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
