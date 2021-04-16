package ipvc.estg.prog2.games.batalhaNaval.players;

import java.util.Random;

public class ShipCreator {
    public static int numRows = 10;
    public static int numCols = 10;
    public static String[][] grid = new String[numRows][numCols];

    public static void adicionarSubmarino() {
        int r1 = new Random().nextInt(numRows);
        int r2 = new Random().nextInt(numCols);

        if (grid[r1][r2] == "") {
            grid[r1][r2] = "1";
        } else {
            adicionarSubmarino();
        }
    }

    public static void adicionar2canhoes() {
        int r1 = new Random().nextInt(numRows);
        int r2 = new Random().nextInt(numCols-1);

        if (grid[r1][r2] == "" && grid[r1][r2+1] == "") {
            grid[r1][r2] = "2";
            grid[r1][r2+1] = "2";
        } else {
            adicionar2canhoes();
        }
    }

    public static void adicionar3canhoes() {
        int r1 = new Random().nextInt(numRows);
        int r2 = new Random().nextInt(numCols-2);

        if (grid[r1][r2] == "" && grid[r1][r2+1] == "" && grid[r1][r2+2] == "") {
            grid[r1][r2] = "3";
            grid[r1][r2+1] = "3";
            grid[r1][r2+2] = "3";
        } else {
            adicionar3canhoes();
        }
    }

    public static void adicionar4canhoes() {
        int r1 = new Random().nextInt(numRows);
        int r2 = new Random().nextInt(numCols-3);

        if (grid[r1][r2] == "" && grid[r1][r2+1] == "" && grid[r1][r2+2] == "" && grid[r1][r2+3] == "") {
            grid[r1][r2] = "4";
            grid[r1][r2+1] = "4";
            grid[r1][r2+2] = "4";
            grid[r1][r2+3] = "4";
        } else {
            adicionar4canhoes();
        }
    }

    public static void adicionarPortaAvioes() {
        int r1 = new Random().nextInt(numRows);
        int r2 = new Random().nextInt(numCols-2);

        if (grid[r1][r2] == "" && grid[r1][r2+1] == "" && grid[r1][r2+2] == "" && grid[r1][r2+3] == "") {
            grid[r1][r2] = "5";
            grid[r1][r2+1] = "5";
            grid[r1][r2+2] = "5";
            grid[r1][r2+3] = "5";
        } else {
            adicionar4canhoes();
        }
    }



}
