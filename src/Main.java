
import Control.FuncionarioController;
import enums.*;
import models.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FuncionarioController controller = new FuncionarioController();

        // Filmes e Salas fixos
        Filme filme1 = new Filme("Matrix", 136, GeneroFilme.ACAO);
        Filme filme2 = new Filme("O Senhor dos Anéis", 178, GeneroFilme.AVENTURA);

        Sala sala1 = new Sala(5, "2D", "1");
        Sala sala2 = new Sala(8, "3D", "2");

        // Sessões do dia
        List<Sessao> sessoes = new ArrayList<>();
        sessoes.add(new Sessao(14, List.of(sala1), filme1));
        sessoes.add(new Sessao(23, List.of(sala2), filme2));
        sessoes.add(new Sessao(20, List.of(sala2), filme2));

        boolean executando = true;

        while (executando) {
            System.out.println("\n--- Sistema de Administração do Cinema ---");
            System.out.println("1. Exibir Sessões Disponíveis");
            System.out.println("2. Vender Ingresso");
            System.out.println("3. Consultar Sessões Cadastradas");
            System.out.println("4. Encerrar Programa");
            System.out.print("Escolha uma opção: ");

            int opcao = lerInt(scanner);
            switch (opcao) {
                case 1 -> controller.exibirSessoesDisponiveis(sessoes);

                case 2 -> {
                    controller.exibirSessoesDisponiveis(sessoes);
                    System.out.print("Digite o horário da sessão desejada: ");
                    int horario = lerInt(scanner);
                    Sessao sessaoSelecionada = null;
                    for (Sessao s : sessoes) {
                        if (s.getHorario() == horario && s.isSessionAvaible()) {
                            sessaoSelecionada = s;
                            break;
                        }
                    }

                    if (sessaoSelecionada == null) {
                        System.out.println("Sessão não encontrada ou indisponível.");
                        break;
                    }

                    System.out.print("Tipo de ingresso (1 - Inteiro, 2 - Meia): ");
                    int tipo = lerInt(scanner);
                    TipoIngresso tipoIngresso = (tipo == 2) ? TipoIngresso.MEIA : TipoIngresso.INTEIRO;

                    System.out.print("Categoria do ingresso (1 - Físico, 2 - Online): ");
                    int categoria = lerInt(scanner);
                    CategoriaIngresso categoriaIngresso = (categoria == 2) ? CategoriaIngresso.INGRESSO_ONLINE : CategoriaIngresso.INGRESSO_FISICO;

                    Ingresso ingresso = new Ingresso(tipoIngresso, categoriaIngresso);
                    if (controller.venderIngresso(sessaoSelecionada, ingresso)) {
                        System.out.println("Ingresso vendido com sucesso!");
                    } else {
                        System.out.println("Falha na venda do ingresso.");
                    }
                }

                case 3 -> {
                    System.out.println("\nSessões cadastradas:");
                    for (Sessao s : sessoes) {
                        System.out.printf("Horário: %02dh | Filme: %s | Salas: %s | Cadeiras Ocupadas: %d/%d\n",
                                s.getHorario(),
                                s.getFilme().getTitulo(),
                                String.join(", ", s.getSala().stream().map(Sala::getLocalizacao).toList()),
                                s.totalIngressosVendidos(),
                                s.getSala().stream().mapToInt(Sala::getnAssentos).sum());
                    }
                }

                case 4 -> {
                    System.out.println("Encerrando o sistema...");
                    executando = false;
                }

                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    // Método para ler int com validação
    private static int lerInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Digite novamente: ");
            }
        }
    }
}