package models.ingresso;

public class IngressoComPipoca extends IngressoDecorator{
    public IngressoComPipoca(InterfaceIngresso ingresso){
        super(ingresso);
    }

    @Override
    public String getDescricao(){
        return ingressoDecorado.getDescricao() + " (Com Pipoca).";
    }

    @Override
    public double getPreco(){
        return ingressoDecorado.getPreco() + 23;
    }
}
