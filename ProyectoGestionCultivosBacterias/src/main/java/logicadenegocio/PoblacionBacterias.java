package logicadenegocio;

import java.util.Date;

public class PoblacionBacterias {
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private int numBacteriasIniciales;
    private int temperatura;
    private String condicionesLuminosidad;
    private DosisComida dosisComida;

    public PoblacionBacterias(String nombre, Date fechaInicio, Date fechaFin, int numBacteriasIniciales,
                              int temperatura, String condicionesLuminosidad, DosisComida dosisComida) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numBacteriasIniciales = numBacteriasIniciales;
        this.temperatura = temperatura;
        this.condicionesLuminosidad = condicionesLuminosidad;
        this.dosisComida = dosisComida;
    }

    // Getters y setters
}
