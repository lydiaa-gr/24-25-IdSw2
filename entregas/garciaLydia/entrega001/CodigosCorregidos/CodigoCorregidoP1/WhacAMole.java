package entregas.garciaLydia.entrega001.CodigosCorregidos.CodigoCorregidoP1;

import java.util.Scanner;

public class WhacAMole {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int agujeroElegido;
        int aciertos = 0;
        int agujeroMonigote1;
        int agujeroMonigote2;
        int intentos = 15;

        do {
            System.out.print("\nEscoje un agujero entre el 1 y el 16: ");
            agujeroElegido = entrada.nextInt();

            // Validación del número elegido
            if (agujeroElegido < 1 || agujeroElegido > 16) {
                System.out.println("Ese agujero no existe. Escoja un número entre 1 y 16.");
                continue; // Salta la iteración para pedir otro número válido
            }

            // Generamos las posiciones de los monigotes
            agujeroMonigote1 = (int) (Math.random() * 16 + 1);

            do {
                agujeroMonigote2 = (int) (Math.random() * 16 + 1);
            } while (agujeroMonigote1 == agujeroMonigote2);

            intentos--; // Restamos un intento

            // Comprobamos si acertó
            if (agujeroElegido == agujeroMonigote1 || agujeroElegido == agujeroMonigote2) {
                aciertos++;
                System.out.println("¡Has acertado!");
            } else {
                System.out.println("¡Fallaste! Sigue intentando.");
            }

            // Mostramos la información del juego
            System.out.println("Aciertos: " + aciertos);
            System.out.println("Intentos restantes: " + intentos);

        } while (intentos > 0);

        System.out.println("\nJuego terminado. Has acertado " + aciertos + " veces.");
    }
}


