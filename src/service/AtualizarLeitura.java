package service;

import model.LeituraClimatica;
import repository.GerenciadorLeituras;

import java.util.List;
import java.util.Scanner;

public class AtualizarLeitura {
    private GerenciadorLeituras gerenciador;
    private Scanner scanner;

    public AtualizarLeitura(GerenciadorLeituras gerenciador, Scanner scanner) {
        this.gerenciador= gerenciador;
        this.scanner= scanner;
    }

    public void executar(){
        List<LeituraClimatica> leituras= gerenciador.listarLeituras();

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

        System.out.print("ID da leitura para atualizar: ");
        try{
            int id= Integer.parseInt(scanner.nextLine());
            System.out.print("Nova cidade: ");
            String novaCidade = scanner.nextLine();

            if (gerenciador.atualizarLeitura(id, novaCidade)) {
                System.out.println("Leitura atualizada com sucesso!");
            } else{
                System.out.println("Falha ao atualizar leitura. Verifique o ID e nome da cidade.");
            }
        } catch (NumberFormatException e){
            System.out.println("ID deve ser um número válido.");
        }
    }
}