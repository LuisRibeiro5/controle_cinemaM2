package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int lerOpcao(){
        System.out.print("Escolha uma opção: ");
        String opcao = scanner.nextLine();
        return Integer.parseInt(opcao);

    }

    public static String lerTituloFilme() {
        System.out.print("Digite o título do filme: ");
        return scanner.nextLine();
    }

    public static int lerNumeroSala() {
        System.out.print("Digite o número da sala: ");
        String sala = scanner.nextLine();
        return Integer.parseInt(sala);
    }

    public static int lerHorarioSessao(){
        System.out.print("Digite o horário da sessão desejada: ");
        String horas = scanner.nextLine();
        return Integer.parseInt(horas);
    }

    public static int lerCategoriaIngresso(){
        System.out.print("Categoria do ingresso (1 - Físico, 2 - Online): ");
        String categoria = scanner.nextLine();
        return Integer.parseInt(categoria);
    }

    public static int lerTipoIngresso(){
        System.out.println("Escolha um adicional:");
        System.out.println("1 - Meia Entrada");
        System.out.println("2 - VIP");
        System.out.println("3 - Pipoca");
        System.out.println("0 - Finalizar compra");

        String adicional = scanner.nextLine();
        return Integer.parseInt(adicional);
    }
}
