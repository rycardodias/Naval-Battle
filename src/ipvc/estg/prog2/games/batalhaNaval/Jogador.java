package ipvc.estg.prog2.games.batalhaNaval;

import java.util.Scanner;

public class Jogador {
    public static int jogar(int jogador) {
        System.out.println("\n\nJOGADOR "+ jogador + " - INDIQUE 3 POSIÇOES PARA JOGAR");
        int i = 0;
        char linha, coluna;
        Scanner entrada = new Scanner(System.in);

        while (i < 3) {
            System.out.println("\nJogada " + (i + 1));
            System.out.print("Linha: ");
            linha = entrada.next().charAt(0);
            System.out.print("Coluna: ");
            coluna = entrada.next().charAt(0);

            int jogada = Tabuleiro.verificarJogada(Character.getNumericValue(linha), Character.getNumericValue(coluna), jogador);
            if (jogada == 0) {
                System.out.println("Posição já foi ocupada! Insira nova jogada");
            } else {
                //verifica vitoria
                if (Tabuleiro.verificarVitoria(jogador) == 1)  {
                    Tabuleiro.chamarTabuleiroJogadas(jogador);
                    return 1;
                }
                i++;
            }
        }
        Tabuleiro.chamarTabuleiroJogadas(jogador);
        return 0;
    }
}
