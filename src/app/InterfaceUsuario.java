package app;

import java.util.Scanner;

import repository.GerenciadorLeituras;

// IMPORTS CORRETOS (estão no pacote service)
import service.CadastrarLeitura;
import service.ListarLeituras;
import service.AtualizarLeitura;
import service.ExcluirLeitura;

public class InterfaceUsuario {
    private GerenciadorLeituras gerenciador;
    private Scanner scanner;
    private CadastrarLeitura cadastrarLeitura;
    private ListarLeituras listarLeituras;
    private AtualizarLeitura atualizarLeitura;
    private ExcluirLeitura excluirLeitura;

    public InterfaceUsuario() {
        this.gerenciador = new GerenciadorLeituras();
        this.scanner = new Scanner(System.in);
        this.cadastrarLeitura = new CadastrarLeitura(gerenciador, scanner);
        this.listarLeituras = new ListarLeituras(gerenciador);
        this.atualizarLeitura = new AtualizarLeitura(gerenciador, scanner);
        this.excluirLeitura = new ExcluirLeitura(gerenciador, scanner);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n=== SISTEMA DE MONITORAMENTO CLIMATICO ===");
            System.out.println("1. Cadastrar leitura climatica");
            System.out.println("2. Listar leituras");
            System.out.println("3. Atualizar leitura");
            System.out.println("4. Excluir leitura");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarLeitura.executar();
                    break;
                case "2":
                    listarLeituras.executar();
                    break;
                case "3":
                    atualizarLeitura.executar();
                    break;
                case "4":
                    excluirLeitura.executar();
                    break;
                case "5":
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
