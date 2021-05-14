package ipvc.estg.prog2.games.batalhaNaval;

import java.util.Arrays;

public class Tabuleiro {
    private static final int numRows = 10;
    private static final int numCols = 10;
    private static final Integer[][] tabuleiroBarcos1 = new Integer[numRows][numCols];
    private static final Integer[][] tabuleiroBarcos2 = new Integer[numRows][numCols];
    public static final Integer[][] tabuleiroJogadas1 = new Integer[numRows][numCols];
    public static final Integer[][] tabuleiroJogadas2 = new Integer[numRows][numCols];

//    public static Integer[] arrayTabuleiro1 = new Integer[100];
//    public static Integer[] arrayTabuleiro2 = new Integer[100];
    static Integer mensagens = 0;

    protected static void mostrarMensagens(int valor) {
        if (valor == 1) {
            mensagens = 1;
        } else {
            mensagens = 0;
        }
    }

    protected static void limparTabuleiros() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                tabuleiroJogadas1[i][j] = null;
                tabuleiroJogadas2[i][j] = null;
            }
        }
    }

    public static void chamarTabuleiroJogadas(int numeroTabuleiro) {
        System.out.println("\n   TABULEIRO JOGADOR " + numeroTabuleiro);
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < numRows; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < numCols; j++) {
                if (j < numCols - 1) {
                    System.out.print("|" + (numeroTabuleiro == 1
                            ? (tabuleiroJogadas1[i][j] == null ? " " : tabuleiroJogadas1[i][j])
                            : (tabuleiroJogadas2[i][j] == null ? " " : tabuleiroJogadas2[i][j])));
                } else {
                    System.out.println('|' + (numeroTabuleiro == 1
                            ? (tabuleiroJogadas1[i][j] == null ? " " : tabuleiroJogadas1[i][j].toString())
                            : (tabuleiroJogadas2[i][j] == null ? " " : tabuleiroJogadas2[i][j].toString())) + '|');
                }
            }
        }
    }

    protected static int verificarPosicaoLivre(int i, int j, int tabuleiro) {
        if ((tabuleiro == 1 && tabuleiroJogadas1[i][j] != null) || (tabuleiro == 2 && tabuleiroJogadas2[i][j] != null)) {
            return 0;
        }
        return 1;
    }

//    protected static int verificarValorJogada(int i, int j, int tabuleiro) {
//        if (tabuleiro == 1) {
//            return (tabuleiroJogadas1[i][j] != null ? tabuleiroJogadas1[i][j] : 0);
//        }
//        return (tabuleiroJogadas2[i][j] != null ? tabuleiroJogadas2[i][j] : 0);
//    }

    protected static int adicionarNovaJogada(int i, int j, int tabuleiro) {
        int tamanhoBarco;

        if (tabuleiro == 1) {
            tamanhoBarco = (tabuleiroBarcos2[i][j] != null ? tabuleiroBarcos2[i][j] : 0);
            tabuleiroJogadas1[i][j] = tamanhoBarco;
        } else {
            tamanhoBarco = (tabuleiroBarcos1[i][j] != null ? tabuleiroBarcos1[i][j] : 0);
            tabuleiroJogadas2[i][j] = tamanhoBarco;
        }

        if (mensagens == 1) {
            if (tamanhoBarco == 0) {
                System.out.println("Acertou na agua!");
            } else {
                System.out.println("Acertou num navio de tamanho " + tamanhoBarco);
            }
        }
        return tamanhoBarco;
    }


//    protected static void popularArray(int tabuleiro) {
//
//        for (int i = 0; i < numRows; i++) {
//            for (int j = 0; j < numCols; j++) {
//                if ((tabuleiro == 1)) {
//                    arrayTabuleiro1[i * 10 + j] = (tabuleiroJogadas1[i][j] == null ? 0 : tabuleiroJogadas1[i][j]);
//                } else {
//                    arrayTabuleiro2[i * 10 + j] = (tabuleiroJogadas2[i][j] == null ? 0 : tabuleiroJogadas2[i][j]);
//                }
//            }
//        }
//    }

    protected static int verificarVitoria(int jogador) {
        int barcos1 = 0;
        int barcos2 = 0;
        int barcos3 = 0;
        int barcos4 = 0;
        int barcos5 = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (jogador == 1) {
                    if (tabuleiroJogadas1[i][j] != null) {
                        if (tabuleiroJogadas1[i][j] == 1) {
                            barcos1 += 1;
                        } else if (tabuleiroJogadas1[i][j] == 2) {
                            barcos2 += 1;
                        } else if (tabuleiroJogadas1[i][j] == 3) {
                            barcos3 += 1;
                        } else if (tabuleiroJogadas1[i][j] == 4) {
                            barcos4 += 1;
                        } else if (tabuleiroJogadas1[i][j] == 5) {
                            barcos5 += 1;
                        }
                    }
                } else {
                    if (tabuleiroJogadas2[i][j] != null) {
                        if (tabuleiroJogadas2[i][j] == 1) {
                            barcos1 += 1;
                        } else if (tabuleiroJogadas2[i][j] == 2) {
                            barcos2 += 1;
                        } else if (tabuleiroJogadas2[i][j] == 3) {
                            barcos3 += 1;
                        } else if (tabuleiroJogadas2[i][j] == 4) {
                            barcos4 += 1;
                        } else if (tabuleiroJogadas2[i][j] == 5) {
                            barcos5 += 1;
                        }
                    }
                }

            }
        }

        if (mensagens == 1) {
            if (barcos1 == 4) {
                System.out.println("Acertou em todos os barcos de tamanho 1");
            }
            if (barcos2 == 6) {
                System.out.println("Acertou em todos os barcos de tamanho 2");
            }
            if (barcos3 == 6) {
                System.out.println("Acertou em todos os barcos de tamanho 3");
            }
            if (barcos4 == 4) {
                System.out.println("Acertou em todos os barcos de tamanho 4");
            }
            if (barcos5 == 5) {
                System.out.println("Acertou em todos os barcos de tamanho 5");
            }
        }

        if (barcos1 == 4 && barcos2 == 6 && barcos3 == 6 && barcos4 == 4 && barcos5 == 5) {
            return 1;
        }
        return 0;
    }


    public static void adicionarNaviosPredefinidos() {
        //adicionar barco1
        tabuleiroBarcos1[0][0] = 1;
        tabuleiroBarcos1[0][9] = 1;
        tabuleiroBarcos1[9][0] = 1;
        tabuleiroBarcos1[9][9] = 1;

        tabuleiroBarcos1[3][7] = 2;
        tabuleiroBarcos1[3][8] = 2;

        tabuleiroBarcos1[4][2] = 2;
        tabuleiroBarcos1[4][3] = 2;

        tabuleiroBarcos1[7][7] = 2;
        tabuleiroBarcos1[7][8] = 2;

        tabuleiroBarcos1[1][7] = 3;
        tabuleiroBarcos1[1][8] = 3;
        tabuleiroBarcos1[1][9] = 3;

        tabuleiroBarcos1[2][2] = 3;
        tabuleiroBarcos1[2][3] = 3;
        tabuleiroBarcos1[2][4] = 3;

        tabuleiroBarcos1[5][6] = 4;
        tabuleiroBarcos1[5][7] = 4;
        tabuleiroBarcos1[5][8] = 4;
        tabuleiroBarcos1[5][9] = 4;

        tabuleiroBarcos1[6][2] = 5;
        tabuleiroBarcos1[8][2] = 5;
        tabuleiroBarcos1[7][2] = 5;
        tabuleiroBarcos1[7][3] = 5;
        tabuleiroBarcos1[7][4] = 5;

        //tabuleiro 2

        tabuleiroBarcos2[6][1] = 1;
        tabuleiroBarcos2[3][5] = 1;
        tabuleiroBarcos2[1][4] = 1;
        tabuleiroBarcos2[7][4] = 1;

        tabuleiroBarcos2[2][1] = 2;
        tabuleiroBarcos2[2][2] = 2;

        tabuleiroBarcos2[4][1] = 2;
        tabuleiroBarcos2[4][2] = 2;

        tabuleiroBarcos2[6][7] = 2;
        tabuleiroBarcos2[6][8] = 2;

        tabuleiroBarcos2[5][3] = 3;
        tabuleiroBarcos2[5][4] = 3;
        tabuleiroBarcos2[5][5] = 3;

        tabuleiroBarcos2[8][6] = 3;
        tabuleiroBarcos2[8][7] = 3;
        tabuleiroBarcos2[8][8] = 3;

        tabuleiroBarcos2[8][1] = 4;
        tabuleiroBarcos2[8][2] = 4;
        tabuleiroBarcos2[8][3] = 4;
        tabuleiroBarcos2[8][4] = 4;

        tabuleiroBarcos2[1][7] = 5;
        tabuleiroBarcos2[1][8] = 5;
        tabuleiroBarcos2[1][9] = 5;
        tabuleiroBarcos2[2][8] = 5;
        tabuleiroBarcos2[3][8] = 5;

    }


}
