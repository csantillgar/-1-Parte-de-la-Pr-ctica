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

    public void calcularCantidadComidaDiaria() {
        int diasExperimento = 30;
        int diaIncremento = dosisComida.getDiaIncremento();
        int cantidadInicial = dosisComida.getCantidadInicial();
        int cantidadFinal = dosisComida.getCantidadFinal();
        // Calcular la pendiente de la recta de incremento y decremento de la comida
        double pendienteIncremento = (double) (cantidadFinal - cantidadInicial) / diaIncremento;
        double pendienteDecremento = (double) (cantidadInicial - cantidadFinal) / (diasExperimento - diaIncremento);
        // Calcular la cantidad de comida para cada día y almacenarla
        for (int dia = 1; dia <= diasExperimento; dia++) {
            if (dia <= diaIncremento) {
                // Incremento lineal de comida
                int cantidadComida = (int) (cantidadInicial + pendienteIncremento * dia);
                // Aquí deberías hacer algo con la cantidad de comida calculada
                // Por ejemplo, podrías imprimir el valor o almacenarlo en una lista
                System.out.println("Día " + dia + ": " + cantidadComida + " unidades de comida");
            } else {
                // Decremento lineal de comida
                int cantidadComida = (int) (cantidadFinal + pendienteDecremento * (dia - diaIncremento));
                // Aquí deberías hacer algo con la cantidad de comida calculada
                // Por ejemplo, podrías imprimir el valor o almacenarlo en una lista
                System.out.println("Día " + dia + ": " + cantidadComida + " unidades de comida");
            }
        }
    }
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



