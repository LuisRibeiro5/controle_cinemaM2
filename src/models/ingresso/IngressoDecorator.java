package models.ingresso;

public abstract class IngressoDecorator implements InterfaceIngresso{
    protected Ingresso ingressoDecorado;

    public IngressoDecorator(Ingresso ingresso){
        ingressoDecorado = ingresso;
    }

    @Override
    public abstract String getDescricao();

    @Override
    public abstract double getPreco();
}
