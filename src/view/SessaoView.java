package view;

import models.Sessao;

import java.util.ArrayList;

public class SessaoView {
    public static void exibirListaSessoes(ArrayList<Sessao> sessoes){
        for (Sessao s : sessoes){
            System.out.println(s);
        }
    }

    public static void exibirSessao(Sessao sessao){
        System.out.println(sessao);
    }

}
