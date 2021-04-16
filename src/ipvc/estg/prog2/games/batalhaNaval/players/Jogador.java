package ipvc.estg.prog2.games.batalhaNaval.players;

import java.util.Scanner;

public class Jogador {
    public static void jogar(int jogador) {
        System.out.println("INDIQUE 3 POSIÇOES PARA JOGAR");
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
                i++;
            }
        }
    }
}
