package repository;

import java.util.ArrayList;
import java.util.List;

import model.LeituraClimatica;
import org.json.JSONObject;
import service.APIClimatica;

public class GerenciadorLeituras{
    private List<LeituraClimatica> leituras;
    private APIClimatica apiClimatica;
    private int nextId;

    public GerenciadorLeituras(){
        this.leituras =new ArrayList<>();
        this.apiClimatica =new APIClimatica();
        this.nextId=1;
    }

    public boolean criarLeitura(String cidade) {
        JSONObject dadosApi = apiClimatica.buscarDadosClimaticos(cidade);

        if (dadosApi != null) {
            try {
                double temperatura = dadosApi.getJSONObject("main").getDouble("temp");
                double umidade = dadosApi.getJSONObject("main").getDouble("humidity");
                String condicao = dadosApi.getJSONArray("weather").getJSONObject(0).getString("description");
                double vento = dadosApi.getJSONObject("wind").getDouble("speed");
                String nomeCidade = dadosApi.getString("name");

                LeituraClimatica leitura = new LeituraClimatica(nextId++, nomeCidade, temperatura, umidade, condicao, vento);
                leituras.add(leitura);
                return true;

            } catch (Exception e) {
                System.out.println("Erro ao processar dados da API");
                return false;
            }
        }
        return false;
    }

    public List<LeituraClimatica> listarLeituras() {
        return new ArrayList<>(leituras);
    }

    public boolean atualizarLeitura(int id, String novaCidade) {
        for (LeituraClimatica leitura : leituras) {
            if (leitura.getId() == id) {
                JSONObject dadosApi = apiClimatica.buscarDadosClimaticos(novaCidade);

                if (dadosApi != null) {
                    try {
                        leitura.setCidade(dadosApi.getString("name"));
                        leitura.setTemperatura(dadosApi.getJSONObject("main").getDouble("temp"));
                        leitura.setUmidade(dadosApi.getJSONObject("main").getDouble("humidity"));
                        leitura.setCondicao(dadosApi.getJSONArray("weather").getJSONObject(0).getString("description"));
                        leitura.setVento(dadosApi.getJSONObject("wind").getDouble("speed"));
                        leitura.atualizarData();
                        return true;

                    } catch (Exception e) {
                        System.out.println("Erro ao atualizar dados da API");
                        return false;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public boolean excluirLeitura(int id){
        return leituras.removeIf(leitura -> leitura.getId()== id);
    }
}