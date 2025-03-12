package entregas.garciaLydia.entrega001.CodigosCorregidos.CodigoCorregidoP2;

import java.util.Scanner;


public class Mundo {
    private CentroComercial centroComercial;
    private int tiempoTotal;
    private int minutosConColaCero;
    private int personasAtendidas;
    private int itemsVendidos;

    public Mundo(int tiempoTotal) {
        centroComercial = new CentroComercial();
        this.tiempoTotal = tiempoTotal;
        this.minutosConColaCero = 0;
        this.personasAtendidas = 0;
        this.itemsVendidos = 0;
    }

    public void simular() {
        boolean centroAbierto = true;
        int minutoActual = 0;
        Scanner scanner = new Scanner(System.in); // Se usa un único Scanner

        do {
            minutoActual++;
            centroAbierto = minutoActual <= this.tiempoTotal;

            if (llegaUnCliente()) {
                Persona persona = new Persona();
                centroComercial.recibe(persona);
            }

            centroComercial.actualizar();
            centroComercial.verEstado(minutoActual);
            actualizarEstadisticas();

            scanner.nextLine(); // Mantiene la pausa sin crear múltiples objetos Scanner
        } while (centroAbierto);

        scanner.close(); // Se cierra el Scanner después de su uso
        mostrarResumen();
    }

    private boolean llegaUnCliente() {
        return Math.random() <= 0.6;
    }

    private void actualizarEstadisticas() {
        if (centroComercial.personasEnCola() == 0) {
            minutosConColaCero++;
        }

        for (Caja caja : centroComercial.getCajas()) {
            if (caja.getItemsPorAtender() == 0) { // Se cuenta correctamente cada persona atendida
                personasAtendidas++;
            }
            itemsVendidos += caja.getItemsPorAtender();
        }
    }

    private void mostrarResumen() {
        System.out.println("RESUMEN");
        System.out.println("============================================================");
        System.out.println("Minutos con cola en cero   : " + minutosConColaCero);
        System.out.println("Personas en la cola al cierre : " + centroComercial.personasEnCola());
        System.out.println("Personas atendidas en el dia  : " + personasAtendidas);
        System.out.println("Artículos vendidos en el dia  : " + itemsVendidos);
        System.out.println("============================================================");
    }

    public static void main(String[] args) {
        final int TIEMPO_TOTAL = 12 * 60; // 12 horas de simulación en minutos
        new Mundo(TIEMPO_TOTAL).simular();
    }
}