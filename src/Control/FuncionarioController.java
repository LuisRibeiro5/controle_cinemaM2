package Control;

import models.Sessao;
import models.Ingresso;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

    public void exibirSessoesDisponiveis(List<Sessao> sessoes) {
        System.out.println("Sessões disponíveis para hoje:");
        for (Sessao s : sessoes) {
            if (s.isSessionAvaible()) {
                System.out.println("Horário: " + s.getHorario() + "h - Filme: " + (s.getFilme() != null ? s.getFilme().getTitulo() : "Sem filme") + " - Assentos disponíveis: " + s.cadeirasDisponiveis());
            }
        }
    }

    public boolean venderIngresso(Sessao sessao, Ingresso ingresso){
        if (sessao == null || ingresso == null) return false;

        if (sessao.isSessionAvaible() && sessao.cadeirasDisponiveis() > 0) {
            sessao.adicionarIngresso(ingresso);
            return true;
        }
        return false;
    }
}
