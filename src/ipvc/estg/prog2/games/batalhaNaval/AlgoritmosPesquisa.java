package ipvc.estg.prog2.games.batalhaNaval;

import java.util.Random;

public class AlgoritmosPesquisa {

    private static int verificarVitoria(int jogador) {
        if (Tabuleiro.verificarVitoria(jogador) == 1) {
            Tabuleiro.chamarTabuleiroJogadas(jogador);
            System.out.println("Parabens! Jogador " + jogador + " venceu!");
            return 1;
        }
        return 0;
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

            if (verificarVitoria(jogador) == 1) {
                return 1;
            }
            i++;
        }
        Tabuleiro.chamarTabuleiroJogadas(jogador);

        return 0;
    }

    public static int[][] arrayBuracos1 = new int[10][10];
    public static int[][] arrayBuracos2 = new int[10][10];

    protected static int dificuldadeMedia(int jogador) {
        int jogadaAdicionada = 0;
        int i = 0;
        Random r = new Random();

        for (int j = 0; (j < 10) && (jogadaAdicionada < 3); j++) {
            for (int k = 0; (k < 10) && (jogadaAdicionada < 3); k++) {
                if ((Tabuleiro.verificarPosicaoLivre(j, k, jogador) == 1) &&
                        ((arrayBuracos1[j][k] == 0 && jogador == 1) || (arrayBuracos2[j][k] == 0 && jogador == 2))) {

                    if (Tabuleiro.adicionarNovaJogada(j, k, jogador)==1) {
                        if (k<9) {
                            posicaoSeguinteBuracos(j, k, jogador);
                        }
                        k++;
                    }
                    jogadaAdicionada++;
                }
            }
        }

        Tabuleiro.chamarTabuleiroJogadas(jogador);
        return 0;
    }

    private static void posicaoSeguinteBuracos(int i, int j, int tabuleiro) {
        if (tabuleiro == 1) {
            if (j < 9) {
                arrayBuracos1[i][j + 1] = 1;
            } else if (j == 9 && i < 9) {
                arrayBuracos1[i + 1][0] = 1;
            } else {
                arrayBuracos1[i][j] = 1;
            }
        } else {
            if (j < 9) {
                arrayBuracos2[i][j + 1] = 1;
            } else if (j == 9 && i < 9) {
                arrayBuracos2[i + 1][0] = 1;
            } else {
                arrayBuracos2[i][j] = 1;
            }
        }

    }

    public static int[] posicaoCentral1 = new int[3];
    public static int[] posicaoCentral2 = new int[3];

    protected static int dificuldadeAlta(int jogador) {
        int[] posicao = new int[3];
        int i = 0;
        Random r = new Random();

        while (i < 3) {
            if (jogador == 1 && posicaoCentral1[2] == 1) {
                if (adicionarAdjacente(posicaoCentral1[0], posicaoCentral1[1], jogador) == 0) {
                    i--;
                }
                ;
            } else if (jogador == 2 && posicaoCentral2[2] == 1) {
                if (adicionarAdjacente(posicaoCentral2[0], posicaoCentral2[1], jogador) == 0) {
                    i--;
                }
                ;
            } else { //se nao tem posicao central vai buscar um random

                while (Tabuleiro.verificarPosicaoLivre(posicao[0], posicao[1], jogador) == 0) {
                    posicao[0] = r.nextInt(10);
                    posicao[1] = r.nextInt(10);
                }

                Tabuleiro.adicionarNovaJogada(posicao[0], posicao[1], jogador);

                if (jogador == 1) {
                    posicaoCentral1[0] = posicao[0];
                    posicaoCentral1[1] = posicao[1];
                    posicaoCentral1[2] = 1;
                } else {
                    posicaoCentral2[0] = posicao[0];
                    posicaoCentral2[1] = posicao[1];
                    posicaoCentral2[2] = 1;
                }
            }

            if (verificarVitoria(jogador) == 1) {
                return 1;
            }
            i++;
        }
        Tabuleiro.chamarTabuleiroJogadas(jogador);
        return 0;
    }


    private static int adicionarAdjacente(int i, int j, int jogador) {
        int posicaoValida = 0;
        int d = 0;
        int b = 0;
        int e = 0;
        int c = 0;
        Random r = new Random();
        int[] posicao = new int[3];

        while ((posicaoValida == 0) && (d < 1 || b < 1 || e < 1 || c < 1)) {
            switch (r.nextInt(4) + 1) {
                case 1 -> { //direita
                    if (d < 1) {
                        d++;
                        if (j < 9) {
                            posicao[0] = i;
                            posicao[1] = j + 1;
                        } else if (j == 9 && i < 9) {
                            posicao[0] = i + 1;
                            posicao[1] = 0;
                        }
                    }
                }
                case 2 -> { //baixo
                    if (b < 1) {
                        b++;
                        if (i < 9) {
                            posicao[0] = i + 1;
                            posicao[1] = j;
                        }
                    }
                }
                case 3 -> { //esquerda
                    if (e < 1) {
                        e++;
                        if (j > 0) {
                            posicao[0] = i;
                            posicao[1] = j - 1;
                        } else if (j == 0 && i > 0) {
                            posicao[0] = i - 1;
                            posicao[1] = 9;
                        }
                    }
                }
                case 4 -> { //cima
                    if (c < 1) {
                        c++;
                        if (i > 0) {
                            posicao[0] = i - 1;
                            posicao[1] = j;
                        }
                    }
                }
            }

            posicaoValida = Tabuleiro.verificarPosicaoLivre(posicao[0], posicao[1], jogador);
        }

        if (posicaoValida == 1) {
            Tabuleiro.adicionarNovaJogada(posicao[0], posicao[1], jogador);
            return 1;
        } else {
            if (jogador == 1) posicaoCentral1[2] = 0;
            if (jogador == 2) posicaoCentral2[2] = 0;
            return 0;
        }
    }


}
