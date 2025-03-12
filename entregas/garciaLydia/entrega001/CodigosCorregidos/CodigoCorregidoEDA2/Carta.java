package entregas.garciaLydia.entrega001.CodigosCorregidos.CodigoCorregidoEDA2;

public class Carta {

    private int palo;
    private int numero;
    private boolean bocaArriba;
    private static final String[] PALOS = { "♠️", "♣️", "♦️", "♥️" };
    private static final String[] NUMEROS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K" };

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
        bocaArriba = false;
    }

    public void mostrar() {
        if (!bocaArriba) {
            System.out.print("[? ?]");
            return;
        }

        if (numero < 0 || numero >= NUMEROS.length || palo < 0 || palo >= PALOS.length) {
            System.out.print("[X X]"); // Carta inválida
        } else {
            System.out.print("[" + NUMEROS[numero] + " " + PALOS[palo] + "]");
        }
    }

    public void voltear() {
        bocaArriba = !bocaArriba;
    }

    public boolean esAs() {
        return numero == 0;
    }

    public boolean igualPalo(Carta carta) {
        return this.palo == carta.palo;
    }

    public boolean siguiente(Carta carta) {
        return this.numero == carta.numero + 1;
    }

    public boolean esRey() {
        return numero == 12;
    }

    public boolean bocaArriba() {
        return bocaArriba;
    }

    public boolean distintoColor(Carta carta) {
        return (this.palo < 2 && carta.palo >= 2) || (this.palo >= 2 && carta.palo < 2);
    }

    public int getNumero() {
        return numero;
    }

    public int getPalo() {
        return palo;
    }
}