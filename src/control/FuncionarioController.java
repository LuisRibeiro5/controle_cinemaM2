package control;

import models.Ingresso;
import models.Sessao;

import javax.swing.event.InternalFrameEvent;
import java.util.ArrayList;

public class FuncionarioController {


    public static Sessao criarSessao(boolean estadoDaSessao, int horario, Sala sala){
        return new Sessao(estadoDaSessao, horario, sala );
    }

    public static void vizualizarSessoesDoDia(ArrayList<Sessao> sessoes){
        for (int i = 0; i < sessoes.size(); i++){
            System.out.println(i + " - " + sessoes.get(i));
        }
    }

    public static Ingresso venderIngresso(ArrayList<Sessao> sessoes){

    }
}
