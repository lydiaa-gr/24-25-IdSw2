package entregas.garciaLydia.entrega001.CodigosCorregidos.CodigoCorregidoEDA1;


import java.util.*;

public class Dia {
    private int numero;
    private Map<String, List<Alimento>> ingestas;

    public Dia(int numero) {
        this.numero = numero;
        this.ingestas = new HashMap<>();
    }

    public int getNumero() {
        return numero;
    }

    public void agregarAlimento(String tipoIngesta, Alimento alimento) {
        ingestas.putIfAbsent(tipoIngesta, new ArrayList<>());
        ingestas.get(tipoIngesta).add(alimento);
    }

    public Map<String, List<Alimento>> getIngestas() {
        return ingestas;
    }
}
