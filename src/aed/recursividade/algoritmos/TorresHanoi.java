package aed.recursividade.algoritmos;

public class TorresHanoi {

    //n - num de discos
    //tg - torre origem
    //ta - torre auxiliar
    //td - torre destino
    public static void execute(int n) {

        if (n < 1) {
            throw new IllegalArgumentException(n + " is an invalid argument : should be higher than 1");
        }
        recursiveExecute(n, 'A', 'B', 'C');
    }

    private static void recursiveExecute(int n, char to, char ta, char td) {
        if(n==1){
            moverDisco(to,td);
            return;
        }

        recursiveExecute(n-1,to,td,ta);
        moverDisco(to,td);
        recursiveExecute(n-1,ta,to,td);
    }

    private static void moverDisco(char to, char td) {
        System.out.println(to + " --> " + td);
    }

    public static void show(int n) {
        try {
            System.out.println("Movimentações de Torres Hanoi com "+ n +" discos: ");
            execute(n);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
