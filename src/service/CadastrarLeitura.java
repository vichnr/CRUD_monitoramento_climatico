package service;

import repository.GerenciadorLeituras;

import java.util.Scanner;

public class CadastrarLeitura{
    private GerenciadorLeituras gerenciador;
    private Scanner scanner;

    public CadastrarLeitura(GerenciadorLeituras gerenciador, Scanner scanner){
        this.gerenciador =gerenciador;
        this.scanner =scanner;
    }

    public void executar(){
        System.out.println("\n--- Nova Leitura Climática ---");
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        if (gerenciador.criarLeitura(cidade)) {
            System.out.println("Leitura cadastrada com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar leitura. Verifique o nome da cidade.");
        }
    }
}