package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int lerOpcao(){
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public static String lerTituloFilme() {
        System.out.print("Digite o título do filme: ");
        return scanner.nextLine();
    }

    public static int lerNumeroSala() {
        System.out.print("Digite o número da sala: ");
        return scanner.nextInt();
    }

    public static int lerHorarioSessao(){
        System.out.print("Digite o horário da sessão desejada: ");
        return scanner.nextInt();
    }

    public static String lerTipoIngresso() {
        System.out.print("Tipo do ingresso (meia, inteiro, vip): ");
        return scanner.next();
    }
}
