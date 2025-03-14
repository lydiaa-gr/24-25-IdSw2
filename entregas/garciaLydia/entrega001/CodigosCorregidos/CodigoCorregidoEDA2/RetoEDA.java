package entregas.garciaLydia.entrega001.CodigosCorregidos.CodigoCorregidoEDA2;

import java.util.Scanner;

public class RetoEDA {
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escoge una opción para ordenar la baraja:");
        System.out.println("1. Ordenar por palo");
        System.out.println("2. Ordenar por número");
        System.out.print("Introduce tu elección: ");
        int opcion = scanner.nextInt();

        Carta[] cartas = new Carta[52];
        for (int i = 0; i < 52; i++) {
            cartas[i] = baraja.sacar();
        }

        if (opcion == 1) {
            OrdenarCartas.clasificarPaloYNumero(cartas);
        } else if (opcion == 2) {
            OrdenarCartas.clasificarNumero(cartas);
        }

        for (Carta carta : cartas) {
            baraja.poner(carta);
        }

        while (!baraja.vacia()) {
            Carta carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
            System.out.println();
        }
        scanner.close();
    }
}