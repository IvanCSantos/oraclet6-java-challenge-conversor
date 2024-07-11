import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public abstract class ExchangeRateAPI {

    public static Double converteMoeda (String codigoOrigem, String codigoDestino){
        // Your API Key: d075cf90baf07691d7ac753f
        String uri = String.format("https://v6.exchangerate-api.com/v6/d075cf90baf07691d7ac753f/latest/%s", codigoOrigem);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonObject = new JSONObject(response.body().toString());
            JSONObject jsonObjectConversionRate = (JSONObject) jsonObject.get("conversion_rates");
            return jsonObjectConversionRate.getDouble(codigoDestino);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
