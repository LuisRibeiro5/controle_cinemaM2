package control;

import models.Ingresso;
import models.Sessao;

import javax.swing.event.InternalFrameEvent;
import java.util.ArrayList;

public class FuncionarioController {

    public static void vizualizarSessoesDoDia(ArrayList<Sessao> sessoes){
        for (Sessao s : sessoes){
            System.out.println(s);
        }
    }

    public static Ingresso venderIngresso(ArrayList<Sessao> sessoes){

    }
}
