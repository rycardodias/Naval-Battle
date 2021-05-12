package ipvc.estg.prog2.games.batalhaNaval;

import java.util.Scanner;

public class Simulador {
    private static int escolherDificuldade() {
        int resposta;
        Scanner entrada = new Scanner(System.in);

        System.out.println("\nEscolha a dificuldade: 1- Facil; 2- Média; 3- Dificil");
        resposta = Character.getNumericValue(entrada.next().charAt(0));

        return resposta;
    }

    public static int correrSimulador(int tipoJogo) {
        int[] venceu = new int[2]; //[VITORIA][JOGADOR]

        switch (tipoJogo) {
            case 1: { //JOGADOR-JOGADOR
                Tabuleiro.mostrarMensagens(1);
                while (venceu[0] == 0) {
                    venceu[0] = Jogador.jogarManual(1);
                    venceu[1] = 1;
                    if (venceu[0] == 0) {
                        venceu[0] = Jogador.jogarManual(2);
                        venceu[1] = 2;
                    }
                }
            }
            case 2: { //JOGADOR-COMPUTADOR
                int dificuldade = escolherDificuldade();
                while (venceu[0] == 0) {
                    Tabuleiro.mostrarMensagens(1);
                    venceu[0] = Jogador.jogarManual(1);
                    venceu[1] = 1;
                    if (venceu[0] == 0) {
                        Tabuleiro.mostrarMensagens(0);
                        venceu[0] = Jogador.jogarAutomatico(2, dificuldade);
                        venceu[1] = 2;
                    }
                }
            }
            case 3: { //JOGADOR-COMPUTADOR
                Tabuleiro.mostrarMensagens(0);
                while (venceu[0] == 0) {
                    venceu[0] = Jogador.jogarAutomatico(1, 1);
                    venceu[1] = 1;
                    if (venceu[0] == 0) {
                        venceu[0] = Jogador.jogarAutomatico(2, 1);
                        venceu[1] = 2;
                    }
                }
            }
        }
        Tabuleiro.chamarTabuleiroJogadas(venceu[1]);
        System.out.println("Parabens! Jogador " + (venceu[1] == 1 ? 1 : 2) + " venceu!");
        return 0;
    }


}
