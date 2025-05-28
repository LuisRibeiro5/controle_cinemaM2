package models;

public class Sala {
    private int nAssentos;
    private String tipoTela;
    private String localizacao;

    Sala(int nAssentos, String tipoTela, String localizacao){
        setnAssentos(nAssentos);
        setTipoTela(tipoTela);
        setLocalizacao(localizacao);
    }

    public int getnAssentos() {
        return nAssentos;
    }

    public void setnAssentos(int nAssentos) {
        if (nAssentos > 0){
            this.nAssentos = nAssentos;
        }
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        if (!tipoTela.isBlank()){
            this.tipoTela = tipoTela;
        }
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        if (!localizacao.isBlank()){
            this.localizacao = localizacao;
        }
    }

    @Override
    public String toString() {
        return "Sala: " + getLocalizacao() +
                " - nAssentos: " + getnAssentos() +
                " - tipoTela: " + getTipoTela();
    }
}
