package models.ingresso;

public class IngressoMeia extends IngressoDecorator{
    public IngressoMeia(InterfaceIngresso ingresso){
        super(ingresso);
    }

    @Override
    public String getDescricao(){
        return ingressoDecorado.getDescricao() + " (Meia)";
    }

    @Override
    public double getPreco(){
        return ingressoDecorado.getPreco() / 2.0;
    }
}
