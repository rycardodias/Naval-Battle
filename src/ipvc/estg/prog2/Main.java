package ipvc.estg.prog2;

import ipvc.estg.prog2.games.batalhaNaval.Jogador;
import ipvc.estg.prog2.games.batalhaNaval.Tabuleiro;

import java.util.Scanner;

public class Main {

//    public static void runSimulation(String desc, GameSimulator simulator, long iterations) {
////        ProgressBar pb = new ProgressBar(desc, iterations);
//        for (long i = 0; i < iterations; ++i/*, pb.step()*/) {
//            simulator.changePlayerPositions();
//            simulator.runSimulation();
//        }
////        pb.stepTo(iterations);
////        pb.close();
//
//        System.out.println("Results for the game:");
//        simulator.printStats();
//
//    }

    public static void main(String[] args) {
//        runSimulation("Connect4 - Random VS Random",
//                new Connect4Simulator(new RandomConnect4Player("Random 1"),new RandomConnect4Player("Random 2")),10000);
//        runSimulation("Connect4 - Greedy VS Random",
//                new Connect4Simulator(new GreedyConnect4Player("Greedy"),new RandomConnect4Player("Random")),10000);
        Tabuleiro.adicionarNaviosPredefinidos();
        int venceu1 = 0;
        int venceu2 = 0;

        System.out.println("\n\nBEM-VINDO AO BATALHA NAVAL");
        System.out.println("1 - Jogador-Computador");
        System.out.println("2 - Jogador-Jogador");
        System.out.println("3 - Computador-Computador");
        System.out.println("4 - Sair");

        char option;
        Scanner entrada = new Scanner(System.in);

        do {
            option = entrada.next().charAt(0);

            switch (option) {
                case '1': {
                    while (venceu1 == 0 && venceu2 == 0) {
                        venceu1 = Jogador.jogar(1);
                        if (venceu1 == 0) {
                            Jogador.jogar(2);
                        }
                    }
                    System.out.println("Parabens! Jogador " + (venceu1==1?1:2) + " venceu!");
                    break;
                }
                case '2': {

                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                }
            }
        } while (option != '4');

    }

}
