package entregas.garciaLydia.entrega001.CodigosCorregidos.CodigoCorregidoEDA2;

import java.util.Comparator;

public class OrdenarCartas {
    public static void clasificarNumero(Carta[] cartas) {
        ordenarBurbuja(cartas, Comparator.comparingInt(Carta::getNumero));
    }

    public static void clasificarPaloYNumero(Carta[] cartas) {
        ordenarBurbuja(cartas, Comparator.comparingInt(Carta::getPalo)
                .thenComparingInt(Carta::getNumero));
    }

    private static void ordenarBurbuja(Carta[] cartas, Comparator<Carta> comparator) {
        boolean swapped;
        int n = cartas.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (comparator.compare(cartas[i - 1], cartas[i]) > 0) {
                    Carta temp = cartas[i];
                    cartas[i] = cartas[i - 1];
                    cartas[i - 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}