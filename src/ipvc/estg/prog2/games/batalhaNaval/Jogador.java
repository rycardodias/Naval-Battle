package ipvc.estg.prog2.games.batalhaNaval;

import java.util.Scanner;

public class Jogador {
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

            if (Tabuleiro.verificarPosicaoLivre(linha, coluna, jogador) == 1) {
                Tabuleiro.adicionarNovaJogada(linha, coluna, jogador);

                if (Tabuleiro.verificarVitoria(jogador) == 1) {
                    Tabuleiro.chamarTabuleiroJogadas(jogador);
                    System.out.println("Parabens! Jogador " + jogador + " venceu!");
                    return 1; //VENCEU
                }
                i++;
            } else {
                System.out.println("Posição já foi ocupada! Insira nova jogada");
            }
        }
        return 0; //NAO VENCEU
    }

    public static int jogarAutomatico(int jogador, int algoritmo) {
        if (algoritmo == 1) {
            return AlgoritmosPesquisa.dificuldadeFacil(jogador);
        } else if (algoritmo == 2) {
            return AlgoritmosPesquisa.dificuldadeMedia(jogador);
        } else {
            return AlgoritmosPesquisa.dificuldadeAlta(jogador);
        }
    }
}
