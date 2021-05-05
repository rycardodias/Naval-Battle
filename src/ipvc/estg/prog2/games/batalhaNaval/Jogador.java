package ipvc.estg.prog2.games.batalhaNaval;

import java.util.Scanner;

public class Jogador {

    private static int[] jogar(int jogador, int linha, int coluna) {
        int venceu = 0;
        int jogadaValida = 0;
        int[] aux = new int[2];

        jogadaValida = Tabuleiro.verificarJogada(linha, coluna, jogador);

        if (jogadaValida == 1) {
            venceu = Tabuleiro.verificarVitoria(jogador);
        }

        aux[0] = venceu;
        aux[1] = jogadaValida;

        return aux;
    }

    public static int jogarManual(int jogador) {
        System.out.println("\n\nJOGADOR " + jogador + " - INDIQUE 3 POSIÇOES PARA JOGAR");
        int i = 0;
        int linha, coluna;
        Scanner entrada = new Scanner(System.in);

        while (i < 3) {
            System.out.println("\nJogada " + (i + 1));
            System.out.print("Linha: ");
            linha = Character.getNumericValue(entrada.next().charAt(0));
            System.out.print("Coluna: ");
            coluna = Character.getNumericValue(entrada.next().charAt(0));

            int[] valorJogada = jogar(jogador, linha, coluna);

            if (valorJogada[0] == 1) {
                Tabuleiro.chamarTabuleiroJogadas(jogador);
                return 1;
            } else {
                if (valorJogada[1] == 0) {
                    System.out.println("Posição já foi ocupada! Insira nova jogada");
                } else {
                    i++;
                }

            }

        }
        Tabuleiro.chamarTabuleiroJogadas(jogador);
        return 0;
    }

    public static int jogarAutomatico(int jogador, int algoritmo) {
        int i = 0;
        int[] posicao = new int[2];

        while (i < 3) {
            if (algoritmo == 1) {
                posicao = AlgoritmosPesquisa.random();
            }


            int[] valorJogada = jogar(jogador, posicao[0], posicao[1]);

            if (valorJogada[0] == 1) {
                Tabuleiro.chamarTabuleiroJogadas(jogador);
                return 1;
            } else {
                if (valorJogada[1] != 0) { //verifica se não era uma posicao ja usada
                    i++;
                }
            }
        }

        Tabuleiro.chamarTabuleiroJogadas(jogador);
        return 0;
    }
}
