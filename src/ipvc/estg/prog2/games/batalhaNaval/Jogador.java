package ipvc.estg.prog2.games.batalhaNaval;

import java.util.Scanner;

public class Jogador {

//    private static int[] jogar(int jogador, int linha, int coluna) {
//        int venceu = 0;
//        int jogadaValida = 0;
//        int[] aux = new int[2];
//
//        jogadaValida = Tabuleiro.verificarJogada(linha, coluna, jogador);
//
//        if (jogadaValida == 1) {
//            venceu = Tabuleiro.verificarVitoria(jogador);
//        }
//
//        aux[0] = venceu;
//        aux[1] = jogadaValida;
//
//        return aux;
//    }

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

            if(Tabuleiro.verificarPosicaoLivre(linha, coluna, jogador)==1) {
                Tabuleiro.adicionarNovaJogada(linha, coluna, jogador);

                if (Tabuleiro.verificarVitoria(jogador)==1) {
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
        int i = 0;
        int[] posicao;

        while (i < 3) {
            if (algoritmo == 1) {
                posicao = AlgoritmosPesquisa.dificuldadeFacil(jogador);
            } else if (algoritmo == 2) {
                posicao = AlgoritmosPesquisa.dificuldadeMedia(jogador);
            } else {
                posicao = AlgoritmosPesquisa.dificuldadeAlta(jogador);
            }

            if(Tabuleiro.verificarPosicaoLivre(posicao[0], posicao[1], jogador)==1) {
                Tabuleiro.adicionarNovaJogada(posicao[0], posicao[1], jogador);

                if (Tabuleiro.verificarVitoria(jogador)==1) {
                    return 1; //VENCEU
                }
                i++;
            }
        }

        return 0;
    }
}
