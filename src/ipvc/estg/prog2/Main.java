package ipvc.estg.prog2;

import ipvc.estg.prog2.games.GameSimulator;
import ipvc.estg.prog2.games.batalhaNaval.players.Jogador;
import ipvc.estg.prog2.games.batalhaNaval.players.ShipCreator;
import ipvc.estg.prog2.games.batalhaNaval.players.Tabuleiro;
import ipvc.estg.prog2.games.connect4.Connect4Simulator;
import ipvc.estg.prog2.games.connect4.players.GreedyConnect4Player;
import ipvc.estg.prog2.games.connect4.players.MinimaxConnect4Player;
import ipvc.estg.prog2.games.connect4.players.RandomConnect4Player;

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

        System.out.println("BEM-VINDO AO BATALHA NAVAL");
        System.out.println("1 - Jogador-Computador");
        System.out.println("2 - Jogador-Jogador");
        System.out.println("3 - Computador-Computador");
        System.out.println("4 - Sair");

        char option;
        Scanner entrada = new Scanner(System.in);

        do {
            option = entrada.next().charAt(0);

            switch (option) {
                case '1':  {
                    int jogador = 1;
                    Tabuleiro.adicionarNaviosPredefinidos();
                    Jogador.jogar(jogador);
                    Tabuleiro.chamarTabuleiroJogadas(jogador);

                    break;
                }
                default:
                {
                    System.out.println("Opção inválida!");
                }
            }

        } while (option != '4');

    }

}
