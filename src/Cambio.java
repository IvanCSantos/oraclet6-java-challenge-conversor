public class Cambio {
    private String codigoOrigem;
    private Double valorOrigem;
    private String codigoDestino;
    private Double cotacao;

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

    public void setValorOrigem(Double valorOrigem) {
        this.valorOrigem = valorOrigem;
    }

    public void setCodigoDestino(String codigoDestino) {
        this.codigoDestino = codigoDestino;
    }

    public void setCotacao(Double cotacao) {
        this.cotacao = cotacao;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public Double getValorOrigem() {
        return valorOrigem;
    }

    public String getCodigoDestino() {
        return codigoDestino;
    }

    public Double getCotacao() {
        return cotacao;
    }

    public Double getValorDestino() {
        return this.valorOrigem * this.cotacao;
    }
}
