package models;

public class Sala {
    private int nAssentos;
    private String tipoTela;
    private String localizacao;

    Sala(int nAssentos, String tipoTela, String localizacao){
        this.nAssentos = nAssentos;
        this.tipoTela = tipoTela;
        this.localizacao = localizacao;
    }

    public int getnAssentos() {
        return nAssentos;
    }

    public void setnAssentos(int nAssentos) {
        this.nAssentos = nAssentos;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        this.tipoTela = tipoTela;
    }
}
