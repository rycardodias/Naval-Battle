package ipvc.estg.prog2.games.batalhaNaval;

import java.util.Random;

public class AlgoritmosPesquisa {

    //os algoritmos sao chamados uma vez por posição,
    //cada vez que chamar o algoritmo vai devolver apenas uma posição e verificar no jogo
    protected static int[] dificuldadeFacil(int jogador) {
        int[] posicao = new int[2];
        Random r = new Random();

        posicao[0] = r.nextInt(10);
        posicao[1] = r.nextInt(10);

        while(Tabuleiro.verificarPosicaoLivre(posicao[0], posicao[1], jogador) == 0) {
            posicao[0] = r.nextInt(10);
            posicao[1] = r.nextInt(10);
        }

        return posicao; //[X][Y]
    }

    protected static int[] dificuldadeMedia(int jogador) {
        int[] posicao = new int[2];
        //colocar aqui

        //ver jogadas necessárias

//        posicao[0] = r.nextInt(10);
//        posicao[1] = r.nextInt(10);
//        int posicaoArray = posicao[0] * 10 + posicao[1];
//
//        while ((jogador==1 && posicaoJogadas1[posicaoArray] == 1) || (jogador==2 && posicaoJogadas1[posicaoArray] == 1)) {
//            posicao[0] = r.nextInt(10);
//            posicao[1] = r.nextInt(10);
//            posicaoArray = posicao[0] * 10 + posicao[1];
//        }

//        adicionarPosicaoJogada(posicao[0], posicao[1], jogador);

        return posicao;
    }

    protected static int[] dificuldadeAlta(int jogador) {
        int[] posicao = new int[2];
        //colocar aqui

        return posicao;
    }




}
