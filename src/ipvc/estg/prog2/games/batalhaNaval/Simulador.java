package ipvc.estg.prog2.games.batalhaNaval;

public class Simulador {
    public static int correrSimulador(int tipoJogo) {
        int[] venceu = new int[2]; //[VITORIA][JOGADOR]

        switch (tipoJogo) {
            case 1: { //JOGADOR-JOGADOR
                while (venceu[0] == 0) {
                    venceu[0] = Jogador.jogarManual(1);
                    venceu[1] = 1;
                    if (venceu[0] == 0) {
                        Jogador.jogarManual(2);
                        venceu[1] = 2;
                    }
                }
            }
            case 2: {
                while (venceu[0] == 0) {
                    venceu[0] = Jogador.jogarManual(1);
                    venceu[1] = 1;
                    if (venceu[0] == 0) {
                        venceu[0] = Jogador.jogarAutomatico(2, 1);
                        venceu[1] = 2;
                    }
                }
            }
            default: {
                System.out.println("Opção inválida!");
            }
        }
        System.out.println("Parabens! Jogador " + (venceu[1] == 1 ? 1 : 2) + " venceu!");
        return 0;
    }
}
