package models.ingresso;

public abstract class IngressoDecorator implements InterfaceIngresso{
    protected InterfaceIngresso ingressoDecorado;

    public IngressoDecorator(InterfaceIngresso ingresso){
        ingressoDecorado = ingresso;
    }

    @Override
    public abstract String getDescricao();

    @Override
    public abstract double getPreco();
}
