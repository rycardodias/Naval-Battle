package ipvc.estg.prog2.games.batalhaNaval.players;

public class Tabuleiro {
    private static final int numRows = 10;
    private static final int numCols = 10;
    private static String[][] tabuleiroBarcos1 = new String[numRows][numCols];
    private static String[][] tabuleiroBarcos2 = new String[numRows][numCols];
    private static String[][] tabuleiroJogadas1 = new String[numRows][numCols];
    private static String[][] tabuleiroJogadas2 = new String[numRows][numCols];

    public static void chamarTabuleiroJogadas(int numeroTabuleiro) {
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < numRows; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < numCols; j++) {
                if (j < numCols - 1) {
                    System.out.print("|" + (numeroTabuleiro == 1 ? (tabuleiroJogadas1[i][j]== null ? " ": tabuleiroJogadas1[i][j]) : (tabuleiroJogadas2[i][j]== null ? " ": tabuleiroJogadas2[i][j])));
                } else {
                    System.out.println('|' + (numeroTabuleiro == 1 ? (tabuleiroJogadas1[i][j]== null ? " ": tabuleiroJogadas1[i][j]) : (tabuleiroJogadas2[i][j]== null ? " ": tabuleiroJogadas2[i][j])) + '|');
                }
            }
        }
    }

    public static int verificarJogada(int linha, int coluna, int numeroTabuleiro) {
        if ((numeroTabuleiro == 1 && tabuleiroJogadas1[linha][coluna] != null) ||
                (numeroTabuleiro == 2 && tabuleiroJogadas2[linha][coluna] != null)) {
            return 0;
        }
        if (numeroTabuleiro == 1) {
            if (tabuleiroBarcos2[linha][coluna] == null) {
                System.out.println("Acertou na agua!");
                adicionarJogada(linha, coluna, numeroTabuleiro, false);
                chamarTabuleiroJogadas(numeroTabuleiro);

            } else {
                adicionarJogada(linha, coluna, numeroTabuleiro, true);
//                tabuleiroJogadas1[linha][coluna] = tabuleiroBarcos2[linha][coluna];
                chamarTabuleiroJogadas(numeroTabuleiro);
            }
        }


        return 1;
    }


    private static void adicionarJogada(int linha, int coluna, int numeroTabuleiro, boolean acertou) {
        if (numeroTabuleiro == 1) {
            tabuleiroJogadas1[linha][coluna] = acertou ? "X" : "-";
        } else {
            tabuleiroJogadas2[linha][coluna] = acertou ? "X" : "-";
        }
    }

    public static void adicionarNaviosPredefinidos() {
        //adicionar barco1
        tabuleiroBarcos1[0][0] = "1";
        tabuleiroBarcos1[0][9] = "1";
        tabuleiroBarcos1[9][0] = "1";
        tabuleiroBarcos1[9][9] = "1";

        tabuleiroBarcos1[3][7] = "2";
        tabuleiroBarcos1[3][8] = "2";

        tabuleiroBarcos1[4][2] = "2";
        tabuleiroBarcos1[4][3] = "2";

        tabuleiroBarcos1[7][7] = "2";
        tabuleiroBarcos1[7][8] = "2";

        tabuleiroBarcos1[1][7] = "3";
        tabuleiroBarcos1[1][8] = "3";
        tabuleiroBarcos1[1][9] = "3";

        tabuleiroBarcos1[2][2] = "3";
        tabuleiroBarcos1[2][3] = "3";
        tabuleiroBarcos1[2][4] = "3";

        tabuleiroBarcos1[5][6] = "4";
        tabuleiroBarcos1[5][7] = "4";
        tabuleiroBarcos1[5][8] = "4";
        tabuleiroBarcos1[5][9] = "4";

        tabuleiroBarcos1[6][2] = "5";
        tabuleiroBarcos1[8][2] = "5";
        tabuleiroBarcos1[7][2] = "5";
        tabuleiroBarcos1[7][3] = "5";
        tabuleiroBarcos1[7][4] = "5";

        //tabuleiro 2

        tabuleiroBarcos2[6][1] = "1";
        tabuleiroBarcos2[3][5] = "1";
        tabuleiroBarcos2[1][4] = "1";
        tabuleiroBarcos2[7][4] = "1";

        tabuleiroBarcos2[2][1] = "2";
        tabuleiroBarcos2[2][2] = "2";

        tabuleiroBarcos2[4][1] = "2";
        tabuleiroBarcos2[4][2] = "2";

        tabuleiroBarcos2[6][7] = "2";
        tabuleiroBarcos2[6][8] = "2";

        tabuleiroBarcos2[5][3] = "3";
        tabuleiroBarcos2[5][4] = "3";
        tabuleiroBarcos2[5][5] = "3";

        tabuleiroBarcos2[8][6] = "3";
        tabuleiroBarcos2[8][7] = "3";
        tabuleiroBarcos2[8][8] = "3";

        tabuleiroBarcos2[8][1] = "4";
        tabuleiroBarcos2[8][2] = "4";
        tabuleiroBarcos2[8][3] = "4";
        tabuleiroBarcos2[8][4] = "4";

        tabuleiroBarcos2[1][7] = "5";
        tabuleiroBarcos2[1][8] = "5";
        tabuleiroBarcos2[1][9] = "5";
        tabuleiroBarcos2[2][8] = "5";
        tabuleiroBarcos2[3][8] = "5";

//        for (int i = 0; i < numRows; i++) {
//            for (int j = 0; j < numRows; j++) {
//                if (tabuleiroBarcos1[i][j] == null) {
//                    tabuleiroBarcos1[i][j] = " ";
//                }
//                if (tabuleiroBarcos2[i][j] == null) {
//                    tabuleiroBarcos2[i][j] = " ";
//                }
//            }
//        }
    }


}
