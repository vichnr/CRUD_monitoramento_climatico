package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;
public class APIClimatica{

    private static final String API_KEY= "SUA_CHAVE_AQUI";
    private static final String BASE_URL= "http://api.openweathermap.org/data/2.5/weather";

    public JSONObject buscarDadosClimaticos(String cidade){
        try {
            String cidadeCodificada =URLEncoder.encode(cidade, "UTF-8");
            String urlString= BASE_URL + "?q=" + cidadeCodificada + "&appid=" + API_KEY + "&units=metric&lang=pt";
            URL url =new URL(urlString);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response= new StringBuilder();
            String line;

            while ((line= reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return new JSONObject(response.toString());

        } catch (Exception e) {
            System.out.println("Erro ao buscar dados da API: " + e.getMessage());
            return null;
        }
    }
}