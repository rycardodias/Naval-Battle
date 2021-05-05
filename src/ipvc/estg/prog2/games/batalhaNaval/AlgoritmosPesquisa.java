package ipvc.estg.prog2.games.batalhaNaval;

import java.util.Random;

public class AlgoritmosPesquisa {
    //os algoritmos sao chamados uma vez por posição,
    //cada vez que chamar o algoritmo vais devolver apenas uma posição e verificar no jogo
    protected static int[] dificuldadeFacil () {
        int[] posicao = new int[2];
        Random r = new Random();

//        falta verificar as posicoes ocupadas para nao estar a fazer random em todos
        posicao[0] = r.nextInt(10);
        posicao[1] = r.nextInt(10);

        return posicao; //[X][Y]
    }

    protected static int[] dificuldadeMedia() {
        int[] posicao = new int[2];
        //colocar aqui

        return posicao;
    }

    protected static int[] dificuldadeAlta() {
        int[] posicao = new int[2];
        //colocar aqui

        return posicao;
    }
}
