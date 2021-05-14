package ipvc.estg.prog2.games.batalhaNaval;

import java.util.Random;
import java.util.Stack;

public class AlgoritmosPesquisa {

    private static int verificarVitoria(int jogador) {
        if (Tabuleiro.verificarVitoria(jogador) == 1) {
            Tabuleiro.chamarTabuleiroJogadas(jogador);
            System.out.println("Parabens! Jogador " + jogador + " venceu!");
            return 1;
        }
        return 0;
    }

    private static int[] calcularAdjacente(int i, int j) {
        int[] posicao = new int[2];
        int k = 0;
        Random r = new Random();

        while (k < 1) {
            switch (r.nextInt(4) + 1) {
                case 1 -> { //direita
                    if (j < 9) {
                        posicao[0] = i;
                        posicao[1] = j + 1;
                        k++;
                    } else if (j == 9 && i < 9) {
                        posicao[0] = i + 1;
                        posicao[1] = 0;
                        k++;
                    }
                }
                case 2 -> { //baixo
                    if (i < 9) {
                        posicao[0] = i + 1;
                        posicao[1] = j;
                        k++;
                    }
                }
                case 3 -> { //esquerda
                    if (j > 0) {
                        posicao[0] = i;
                        posicao[1] = j - 1;
                        k++;
                    } else if (j == 0 && i > 0) {
                        posicao[0] = i - 1;
                        posicao[1] = 9;
                        k++;
                    }
                }
                case 4 -> { //cima
                    if (i > 0) {
                        posicao[0] = i - 1;
                        posicao[1] = j;
                        k++;
                    }
                }
            }
        }
        return posicao;
    }

    //os algoritmos sao chamados uma vez por posição,
    //cada vez que chamar o algoritmo vai devolver apenas uma posição e verificar no jogo
    protected static int dificuldadeFacil(int jogador) {
        int[] posicao = new int[2];
        int i = 0;
        Random r = new Random();

        while (i < 3) {
            while (Tabuleiro.verificarPosicaoLivre(posicao[0], posicao[1], jogador) == 0) {
                posicao[0] = r.nextInt(10);
                posicao[1] = r.nextInt(10);
            }

            Tabuleiro.adicionarNovaJogada(posicao[0], posicao[1], jogador);

            if (verificarVitoria(jogador) == 1) return 1;
            i++;
        }

        return 0; //[X][Y]
    }

    public static int[] adjacenteGlobal = new int[2];

    protected static int dificuldadeMedia(int jogador) {
        int[] posicao = new int[2];
        int i = 0;
        Random r = new Random();
        int[] adjacente = new int[3]; //[i][j][alterado]

        System.out.println(adjacenteGlobal[0] + "este");

        while (i < 3) {
            while (Tabuleiro.verificarPosicaoLivre(posicao[0], posicao[1], jogador) == 0) {

                posicao[0] = (adjacenteGlobal[2]==1 ? adjacenteGlobal[0]: r.nextInt(10));
                posicao[1] = (adjacenteGlobal[2]==1 ? adjacenteGlobal[1]: r.nextInt(10));
            }

            int valorJogada = Tabuleiro.adicionarNovaJogada(posicao[0], posicao[1], jogador);

            if (valorJogada > 1) {
//                System.out.println("maior");
                //guardar posicao na stack
//                    adjacente = calcularAdjacente(posicao[0], posicao[1]); //[x][y] novo

            } else {
//                System.out.println("menor");
                Tabuleiro.adicionarNovaJogada(posicao[0], posicao[1], jogador);
            }

            if (verificarVitoria(jogador) == 1) return 1;
            i++;
        }

        return 0; //[X][Y]
    }

    protected static int dificuldadeAlta(int jogador) {
        int[] posicao = new int[2];
        int i = 0;
        Random r = new Random();



        return 1; //[X][Y]
    }


}
