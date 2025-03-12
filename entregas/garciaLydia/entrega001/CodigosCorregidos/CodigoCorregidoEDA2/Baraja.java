package entregas.garciaLydia.entrega001.CodigosCorregidos.CodigoCorregidoEDA2;

import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Baraja {

    private Carta[] cartas;
    private final int PALOS = 4;
    private final int NUMEROS = 13;
    private final int TOTAL_CARTAS = PALOS * NUMEROS;
    private int ultima;

    public Baraja() {
        ultima = 0;
        cartas = new Carta[TOTAL_CARTAS];
        for (int palo = 0; palo < PALOS; palo++) {
            for (int numero = 0; numero < NUMEROS; numero++) {
                this.poner(new Carta(palo, numero));
            }
        }
        this.barajar();
    }

    private void barajar() {
        List<Carta> listaCartas = Arrays.asList(cartas);
        Collections.shuffle(listaCartas);
        cartas = listaCartas.toArray(new Carta[0]);
    }

    public void poner(Carta carta) {
        if (ultima < TOTAL_CARTAS) {
            cartas[ultima++] = carta;
        }
    }

    public void mostrar() {
        System.out.print("BARAJA: ");
        if (this.vacia()) {
            System.out.println("No hay cartas en la baraja");
        } else {
            Carta carta = this.cima();
            carta.mostrar();
            System.out.println();
        }
    }

    private Carta cima() {
        return cartas[ultima - 1];
    }

    public void moverA(Descarte descarte) {
        if (this.vacia()) {
            System.out.println("¡No hay cartas en la baraja!");
        } else {
            for (int i = 0; i < 3 && !this.vacia(); i++) {
                Carta carta = this.sacar();
                carta.voltear();
                descarte.poner(carta);
            }
        }
    }

    public Carta sacar() {
        return this.vacia() ? null : cartas[--ultima];
    }

    public boolean vacia() {
        return ultima == 0;
    }
}