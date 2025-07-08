package models.ingresso;

public class IngressoVip extends IngressoDecorator{
    public IngressoVip(Ingresso ingresso){
        super(ingresso);
    }

    @Override
    public String getDescricao(){
        return ingressoDecorado.getDescricao() + " (VIP)";
    }

    @Override
    public double getPreco(){
        return ingressoDecorado.getPreco() + 17;
    }
}
