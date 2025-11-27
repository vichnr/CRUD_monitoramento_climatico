package service;

import model.LeituraClimatica;
import repository.GerenciadorLeituras;

import java.util.List;

public class ListarLeituras{
    private GerenciadorLeituras gerenciador;

    public ListarLeituras(GerenciadorLeituras gerenciador){
        this.gerenciador = gerenciador;
    }

    public void executar() {
        List<LeituraClimatica>leituras= gerenciador.listarLeituras();

        if (leituras.isEmpty()) {
            System.out.println("Nenhuma leitura cadastrada.");
            return;
        }

        System.out.println("\n--- LEITURAS CADASTRADAS ---");
        for (LeituraClimatica leitura : leituras) {
            System.out.println("ID: " + leitura.getId());
            System.out.println("Data: " + leitura.getData());
            System.out.println("Cidade: " + leitura.getCidade());
            System.out.println("Temperatura: " + leitura.getTemperatura() + "C | Umidade: " + leitura.getUmidade() + "%");
            System.out.println("Condicao: " + leitura.getCondicao() + " | Vento: " + leitura.getVento() + " m/s");
            System.out.println("----------------------------------------");
        }
    }
}