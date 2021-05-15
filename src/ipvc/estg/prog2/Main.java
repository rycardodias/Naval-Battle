package ipvc.estg.prog2;

import ipvc.estg.prog2.games.batalhaNaval.Jogador;
import ipvc.estg.prog2.games.batalhaNaval.Simulador;
import ipvc.estg.prog2.games.batalhaNaval.Tabuleiro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tabuleiro.adicionarNaviosPredefinidos();

        char option;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("\n\nBEM-VINDO AO BATALHA NAVAL");
            System.out.println("1 - Jogador-Jogador");
            System.out.println("2 - Jogador-Computador");
            System.out.println("3 - Computador-Computador");
            System.out.println("4 - Sair");
            option = entrada.next().charAt(0);

            switch (option) {
                case '1': {
                    Simulador.correrSimulador(1);
                    break;
                }
                case '2': {
                    Simulador.correrSimulador(2);
                    break;
                }
                case '3': {
                    Simulador.correrSimulador(3);
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                }
            }
        } while (option != '4');

    }

}
