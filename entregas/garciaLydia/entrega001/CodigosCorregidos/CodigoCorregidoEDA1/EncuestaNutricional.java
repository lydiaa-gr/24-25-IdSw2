package entregas.garciaLydia.entrega001.CodigosCorregidos.CodigoCorregidoEDA1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EncuestaNutricional {
    private String nombrePaciente;
    private Date fechaAlta;
    private List<Dia> dias;

    public EncuestaNutricional(String nombrePaciente, String fechaAlta) {
        this.nombrePaciente = nombrePaciente;
        this.dias = new ArrayList<>();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.fechaAlta = formato.parse(fechaAlta);
        } catch (ParseException e) {
            System.out.println("Error: Formato de fecha incorrecto.");
            this.fechaAlta = new Date(); // Asigna la fecha actual si hay error
        }
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getFechaAlta() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fechaAlta);
    }

    public List<Dia> getDias() {
        return dias;
    }

    public void agregarDia(Dia dia) {
        dias.add(dia);
    }
}

