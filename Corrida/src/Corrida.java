import java.util.Random;
import java.util.Scanner;

public class Corrida {
    private Carro carro1;
    private Carro carro2;
    private final int tamPista = 20;

    public boolean ganhou() {
        if (carro1.getPosicao() >= tamPista || carro2.getPosicao() >= tamPista) {
            if (carro1.getPosicao() > carro2.getPosicao()) {
                System.out.println("Carro1 é o vencedor da corrida!");
            } else if (carro2.getPosicao() > carro1.getPosicao()) {
                System.out.println("Carro2 é o vencedor da corrida!");
            } else {
                System.out.println("Empate!");
            }
            return true;
        }
        return false;
    }

    public void run() {
        carro1 = new Carro();
        carro2 = new Carro();
        Random random = new Random();
        printPistaInicial();
        int count = 0;

        while (!ganhou()) {
            System.out.println("Turno: " + (count + 1));


            int velocidadeCarro1 = random.nextInt(3) + 1;
            int velocidadeCarro2 = random.nextInt(3) + 1;

            System.out.println("Velocidade Carro1: " + velocidadeCarro1);
            System.out.println("Velocidade Carro2: " + velocidadeCarro2);


            carro1.andar(velocidadeCarro1);
            carro2.andar(velocidadeCarro2);


            printPista();
            count++;


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printPistaInicial() {
        for (int i = 0; i < tamPista; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.print("d");

        for (int i = 0; i < tamPista - 1; i++) {
            System.out.print(" ");
        }
        System.out.println();

        System.out.print("d");

        for (int i = 0; i < tamPista - 1; i++) {
            System.out.print(" ");
        }
        System.out.println();

        for (int i = 0; i < tamPista; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void printPista() {
        System.out.println("Carro1 está na posição: " + carro1.getPosicao());
        System.out.println("Carro2 está na posição: " + carro2.getPosicao());

        // Linha superior
        for (int i = 0; i < tamPista; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Carro1 na pista
        System.out.printf("%" + (carro1.getPosicao() + 1) + "s%n", "d");

        // Espaço entre os carros
        System.out.println(" ".repeat(tamPista));

        // Carro2 na pista
        System.out.printf("%" + (carro2.getPosicao() + 1) + "s%n", "d");

        // Linha inferior
        for (int i = 0; i < tamPista; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
