package models;

public class Sala {
    private int nAssentos;
    private String tipoTela;
    private String localizacao;

    public Sala(int nAssentos, String tipoTela, String localizacao){
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
        } else {
            throw new IllegalArgumentException("Número de assentos deve ser maior que zero.");
        }
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        if (tipoTela != null && !tipoTela.isBlank()){
            this.tipoTela = tipoTela;
        } else {
            throw new IllegalArgumentException("Tipo de tela não pode ser vazio.");
        }
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        if (localizacao != null && !localizacao.isBlank()){
            this.localizacao = localizacao;
        } else {
            throw new IllegalArgumentException("Localização não pode ser vazia.");
        }
    }

    @Override
    public String toString() {
        return "Sala: " +
                "-Número de assentos: " + nAssentos +
                "-tipo de tela: " + tipoTela + '\'' +
                "-localizacao='" + localizacao + '\'';
    }
}
