public class ConversorDeMoeda {
    public Cambio converteMoeda(Cambio cambio) {
        Double taxaDeCambio = ExchangeRateAPI.converteMoeda(cambio.getCodigoOrigem(), cambio.getCodigoDestino());
        cambio.setCotacao(taxaDeCambio);

        return cambio;
    }
}
