package org.example;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner entrada = new Scanner(System.in);

        int pedidos = 0;
        double total = 0.0;
        double maiorC = 0.0;
        double menorC = 0.0;
        int compra50 = 0;
        String cliente = "";
        double acima30 = 0.0;
        int qtd30 = 0;

        System.out.println("\n=== Sistema de Registro de Pedidos de uma Lanchonete ===");

        System.out.println("""
                    \nEscolha uma opção abaixo:
                    \n1 - Cadastrar Pedido
                    2 - Exibir Relatório
                    3 - Encerrar Sistema
                    """);
        int opcao = entrada.nextInt();
        entrada.nextLine();

        while (opcao == 1){
            System.out.println("Nome do cliente: ");
            String nome = entrada.nextLine();

            System.out.println("Valor da compra: ");
            double valor = entrada.nextDouble();

            while (valor <= 0) {
                System.out.println("O valor deve ser maior que zero! Digite outro valor: ");
                valor = entrada.nextDouble();
            }

            pedidos++;
            total += valor;

            if (valor > 50.0) {
                compra50++;
            }

            if (valor > 30.0) {
                acima30 += valor;
                qtd30++;

            }

            if (valor > maiorC) {
                maiorC = valor;
                cliente = nome;
            }

            if (pedidos == 1 || valor < menorC) {
                menorC = valor;
            }

            System.out.println("""
                    \nEscolha uma opção abaixo:
                    \n1 - Cadastrar Pedido
                    2 - Exibir Relatório
                    3 - Encerrar Sistema
                    """);
            opcao = entrada.nextInt();
            entrada.nextLine();

        }

        if (opcao == 2) {
            double ticketMedio = 0.0;
            if (pedidos > 0) {
                ticketMedio = total / pedidos;
            } else {
                menorC = 0.0;
            }

            double media30 = 0.0;
            if (qtd30 > 0) {
                media30 = acima30 / qtd30;
            }

            System.out.println("\n===== RELATÓRIO FINAL =====");
            System.out.println("\nQuantidade de pedidos: " + pedidos);
            System.out.println("Valor total vendido: R$" + total);
            System.out.println("Ticket médio: R$" + ticketMedio);
            System.out.println("Maior compra: R$" + maiorC);
            System.out.println("Menor compra: R$" + menorC);
            System.out.println("Compras acima de R$50,00: " + compra50);
            System.out.println("Cliente que realizou a maior compra: " + cliente);
            System.out.println("Média das compras acima de R$30,00: R$" + media30);

            if (total > 500.0) {
                System.out.println("\nMeta atingida!");
            } else {
                System.out.println("\nMeta não atingida :( \nFalta R$" + (500.0 - total) + " para atingir a meta!");
            }

        } else if (opcao == 3) {
            System.out.println("\nSistema encerrando...");
        }

    }
}
