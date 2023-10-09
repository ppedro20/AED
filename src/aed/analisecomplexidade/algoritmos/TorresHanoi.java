package aed.analisecomplexidade.algoritmos;

public class TorresHanoi {

    public static void execute(int numDiscos) {

        if (numDiscos < 1) {
            throw new IllegalArgumentException(numDiscos + " is an invalid argument : should be higher than 1");
        }
        Torre torreOrigem = new Torre('A', numDiscos);
        Torre torreAuxiliar = new Torre('B', numDiscos);
        Torre torreDestino = new Torre('C', numDiscos);
        torreOrigem.preencherComDiscos();
        recursiveExecute(numDiscos, torreOrigem, torreAuxiliar, torreDestino);
    }

    private static void recursiveExecute(int numDiscos, Torre torreOrigem, Torre torreAuxiliar, Torre torreDestino) {
        if (numDiscos == 1) {
            moverDisco(torreOrigem, torreDestino);
            return;
        }

        recursiveExecute(numDiscos - 1, torreOrigem, torreAuxiliar, torreDestino);
        moverDisco(torreOrigem, torreDestino);
        recursiveExecute(numDiscos - 1, torreAuxiliar, torreOrigem, torreDestino);
    }

    private static void moverDisco(Torre torreOrigem, Torre torreDestino) {
        torreOrigem.moverDisco(torreDestino);
    }

    public static void show(int numDiscos) {
        try {
            System.out.println("Movimentações de Torres Hanoi com " + numDiscos + " discos: ");
            execute(numDiscos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
