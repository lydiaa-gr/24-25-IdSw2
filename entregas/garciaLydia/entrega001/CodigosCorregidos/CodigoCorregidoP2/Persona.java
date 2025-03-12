package entregas.garciaLydia.entrega001.CodigosCorregidos.CodigoCorregidoP2;

import java.util.concurrent.ThreadLocalRandom;

public class Persona {
    private int items;

    public Persona() {
        // Se genera correctamente entre 5 y 15 items
        this.items = ThreadLocalRandom.current().nextInt(5, 16);
    }

    public int getItems() {
        return items;
    }
}
