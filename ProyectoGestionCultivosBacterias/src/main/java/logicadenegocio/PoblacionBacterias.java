package logicadenegocio;

import java.time.LocalDate;

public class PoblacionBacterias {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int numBacteriasIniciales;
    private int temperatura;
    private String condicionesLuminosidad;
    private DosisComida dosisComida;

    public PoblacionBacterias(String nombre, LocalDate fechaInicio, LocalDate fechaFin, int numBacteriasIniciales,
                              int temperatura, String condicionesLuminosidad, DosisComida dosisComida) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numBacteriasIniciales = numBacteriasIniciales;
        this.temperatura = temperatura;
        this.condicionesLuminosidad = condicionesLuminosidad;
        this.dosisComida = dosisComida;
    }

    public PoblacionBacterias(String nombrePoblacion, LocalDate fechaInicio, LocalDate fechaFin, int numBacteriasIniciales, int temperatura, String luminosidad, int dosisInicial, int diaIncremento, int comidaIncremento, int dosisFinal) {
    }

    // Método para calcular el crecimiento diario de la población de bacterias
    public int calcularCrecimientoDiario(int dia) {
        int cantidadComida = dosisComida.calcularCantidadComida(dia);
        // Ajusta la lógica según el comportamiento real de las bacterias
        return cantidadComida / 2; // Simulación del crecimiento diario
    }

    // Método para calcular la disminución diaria de la población de bacterias
    public int calcularDisminucionDiaria(int dia) {
        // Ajusta la lógica según el comportamiento real de las bacterias
        return numBacteriasIniciales / 3; // Simulación de la disminución diaria
    }

    // Método para calcular el total de bacterias al final del experimento
    public int calcularTotalBacterias() {
        int totalBacterias = numBacteriasIniciales;
        for (int dia = 1; dia <= 30; dia++) {
            int crecimiento = calcularCrecimientoDiario(dia);
            int disminucion = calcularDisminucionDiaria(dia);
            totalBacterias += crecimiento - disminucion;
        }
        return totalBacterias;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getNumBacteriasIniciales() {
        return numBacteriasIniciales;
    }

    public void setNumBacteriasIniciales(int numBacteriasIniciales) {
        this.numBacteriasIniciales = numBacteriasIniciales;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getCondicionesLuminosidad() {
        return condicionesLuminosidad;
    }

    public void setCondicionesLuminosidad(String condicionesLuminosidad) {
        this.condicionesLuminosidad = condicionesLuminosidad;
    }

    public DosisComida getDosisComida() {
        return dosisComida;
    }

    public void setDosisComida(DosisComida dosisComida) {
        this.dosisComida = dosisComida;
    }
}

