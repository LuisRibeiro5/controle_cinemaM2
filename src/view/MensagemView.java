package view;

import enums.CategoriaIngresso;

public class MensagemView {
    public static void exibirErro(String mensagem){
        System.out.println("[ERRO] " + mensagem);
    }

    public static void exibirSucesso(String mensagem){
        System.out.println("[OK] " + mensagem);
    }

    public static void exibirInfo(String mensagem){
        System.out.println("[INFO] " + mensagem);
    }

    public static void exibirInfo(int msg){
        switch (msg){
            case 1:
                System.out.println("[INFO] Meia Entrada adicionada.");
                break;
            case 2:
                System.out.println("[INFO] VIP adicionado.");
                break;
            case 3:
                System.out.println("[INFO] Pipoca adicionada.");
                break;
        }
    }
}
