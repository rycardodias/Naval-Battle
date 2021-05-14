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

    public static void correrSimulador(int tipoJogo) {
        int venceu = 0;

        switch (tipoJogo) {
            case 1: { //JOGADOR-JOGADOR
                Tabuleiro.mostrarMensagens(1);
                while (venceu == 0) {
                    venceu = Jogador.jogarManual(1);
                    if (venceu == 0) {
                        venceu = Jogador.jogarManual(2);
                    }
                }
            }
            case 2: { //JOGADOR-COMPUTADOR
                int dificuldade = escolherDificuldade();
                while (venceu == 0) {
                    Tabuleiro.mostrarMensagens(1);
                    venceu = Jogador.jogarManual(1);
                    if (venceu == 0) {
                        Tabuleiro.mostrarMensagens(0);
                        venceu = Jogador.jogarAutomatico(2, dificuldade);
                    }
                }
            }
            case 3: { //COMPUTADOR-COMPUTADOR
                Tabuleiro.mostrarMensagens(0);
                while (venceu == 0) {
                    venceu = Jogador.jogarAutomatico(1, 2);
                    if (venceu == 0) {
                        venceu = Jogador.jogarAutomatico(2, 1);
                    }
                }
            }
        }
        Tabuleiro.limparTabuleiros();
    }


}
