package entregas.garciaLydia.entrega001.CodigosCorregidos.CodigoCorregidoEDA1;

import java.util.*;

public class GestorEncuesta {
    private final Scanner scanner;
    private EncuestaNutricional encuesta;

    public GestorEncuesta() {
        this.scanner = new Scanner(System.in);
    }

    public void simular() {
        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();

        System.out.print("Ingrese la fecha de alta (dd/MM/yyyy): ");
        String fechaAlta = scanner.nextLine();

        encuesta = new EncuestaNutricional(nombrePaciente, fechaAlta);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> agregarDia();
                case 2 -> registrarAlimento();
                case 3 -> mostrarEncuesta();
                case 4 -> System.out.println("Saliendo del programa. ¡Hasta luego!");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close(); // Cerramos el scanner después de su uso
    }

    private void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Agregar día");
        System.out.println("2. Registrar alimento");
        System.out.println("3. Mostrar encuesta");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void agregarDia() {
        System.out.print("Ingrese el número del día: ");
        int numeroDia = scanner.nextInt();
        scanner.nextLine();

        Dia dia = new Dia(numeroDia);
        encuesta.agregarDia(dia);

        System.out.println("Día " + numeroDia + " agregado correctamente.");
    }

    private void registrarAlimento() {
        System.out.print("Ingrese el número del día: ");
        int numeroDia = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el tipo de ingesta (Desayuno, Media mañana, Almuerzo, Merienda, Cena): ");
        String tipoIngesta = scanner.nextLine();

        System.out.print("Ingrese el nombre del alimento: ");
        String nombreAlimento = scanner.nextLine();

        Alimento alimento = new Alimento(nombreAlimento);

        encuesta.getDias().stream()
                .filter(d -> d.getNumero() == numeroDia)
                .findFirst()
                .ifPresentOrElse(
                        dia -> {
                            dia.agregarAlimento(tipoIngesta, alimento);
                            System.out.println("Alimento registrado correctamente.");
                        },
                        () -> System.out.println("Día no encontrado. Registre el día primero.")
                );
    }

    private void mostrarEncuesta() {
        System.out.println("Encuesta Nutricional para " + encuesta.getNombrePaciente() + " (Fecha de alta: " +
                encuesta.getFechaAlta() + "):\n");

        for (Dia dia : encuesta.getDias()) {
            System.out.println("Día " + dia.getNumero() + ":");
            dia.getIngestas().forEach((tipo, alimentos) -> {
                System.out.println("  " + tipo + ":");
                alimentos.forEach(alimento -> System.out.println("      " + alimento.getNombre()));
            });
            System.out.println();
        }
    }
}