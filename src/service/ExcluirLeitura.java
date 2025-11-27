package service;

import model.LeituraClimatica;
import repository.GerenciadorLeituras;

import java.util.List;
import java.util.Scanner;

public class ExcluirLeitura{
    private GerenciadorLeituras gerenciador;
    private Scanner scanner;

    public ExcluirLeitura(GerenciadorLeituras gerenciador, Scanner scanner) {
        this.gerenciador= gerenciador;
        this.scanner =scanner;
    }

    public void executar() {
        List<LeituraClimatica>leituras= gerenciador.listarLeituras();

        if (leituras.isEmpty()){
            System.out.println("Nenhuma leitura cadastrada.");
            return;
        }

        System.out.println("\n--- LEITURAS CADASTRADAS ---");
        for (LeituraClimatica leitura : leituras) {
            System.out.println("ID: " + leitura.getId());
            System.out.println("Data: " + leitura.getData());
            System.out.println("Cidade: " + leitura.getCidade());
            System.out.println("Temperatura: " + leitura.getTemperatura() + "C | Umidade: " + leitura.getUmidade() + "%");
            System.out.println("Condição: " + leitura.getCondicao() + " | Vento: " + leitura.getVento() + " m/s");
            System.out.println("----------------------------------------");
        }

        System.out.print("ID da leitura para excluir: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());

            if (gerenciador.excluirLeitura(id)) {
                System.out.println("Leitura excluída com sucesso!");
            } else {
                System.out.println("Leitura não encontrada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID deve ser um número válido.");
        }
    }
}