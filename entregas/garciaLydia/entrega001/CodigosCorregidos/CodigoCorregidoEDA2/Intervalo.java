package entregas.garciaLydia.entrega001.CodigosCorregidos.CodigoCorregidoEDA2;

public class Intervalo {
    private double puntoMedio;
    private double longitud;

    public Intervalo(double inferior, double superior) {
        this.setExtremos(inferior, superior);
    }

    public void setExtremos(double inferior, double superior) {
        this.longitud = superior - inferior;
        this.puntoMedio = (inferior + superior) / 2;
    }

    public double getInferior() {
        return puntoMedio - longitud / 2;
    }

    public double getSuperior() {
        return puntoMedio + longitud / 2;
    }
}