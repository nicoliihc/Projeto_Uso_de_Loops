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

        System.out.println("\n=== Sistema de Registro de Pedidos de uma Lanchonete ===");

        System.out.println("""
                            \nDeseja cadastrar um pedido?
                            1 - Sim
                            2 - Não
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

            if (valor > maiorC) {
                maiorC = valor;
                cliente = nome;
            }

            if (pedidos == 1 || valor < menorC) {
                menorC = valor;
            }

            System.out.println("""
                            \nCadastrar novo pedido?
                            1 - Sim
                            2 - Não
                            """);
            opcao = entrada.nextInt();
            entrada.nextLine();

        }

        double ticketMedio = 0.0;
        if (pedidos > 0) {
            ticketMedio = total / pedidos;
        } else {
            menorC = 0.0;
        }

        System.out.println("\n===== RELATÓRIO FINAL =====");
        System.out.println("\nQuantidade de pedidos: " + pedidos);
        System.out.println("Valor total vendido: R$ " + total);
        System.out.println("Ticket médio: R$ " + ticketMedio);
        System.out.println("Maior compra: R$ " + maiorC);
        System.out.println("Menor compra: R$ " + menorC);
        System.out.println("Compras acima de R$ 50,00: " + compra50);
        System.out.println("Cliente que realizou a maior compra: " + cliente);

    }
}
