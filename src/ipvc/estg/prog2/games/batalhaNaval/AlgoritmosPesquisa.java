package ipvc.estg.prog2.games.batalhaNaval;

import java.util.Random;

public class AlgoritmosPesquisa {
    protected static int[] random () {
        int[] posicao = new int[2];
        Random r = new Random();

        posicao[0] = r.nextInt(10);
        posicao[1] = r.nextInt(10);

        //Tens de desenvolver o algoritmo que retorne uma posição de cada vez mais indicada.
        //por cada "jogada" este algoritmo vai ser chamado 3 vezes
        return posicao; //[X][Y]
    }
}
