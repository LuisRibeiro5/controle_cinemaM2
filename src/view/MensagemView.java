package view;

public class MensagemView {
    public static void exibirErro(String mensagem){
        System.out.println("[ERRO] " + mensagem);
    }

    public static void exibirSucesso(String mensagem){
        System.out.println("[OK] " + mensagem);
    }
}
