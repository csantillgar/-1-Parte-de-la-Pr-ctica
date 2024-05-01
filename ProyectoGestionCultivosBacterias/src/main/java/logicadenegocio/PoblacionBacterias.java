package logicadenegocio;

import java.util.Date;

public class PoblacionBacterias {
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private int numBacteriasIniciales;
    private int temperatura;
    private String luminosidad;
    private int dosisComidaInicial;
    private int diaIncrementoComida;
    private int comidaIncremento;
    private int comidaFinal;
    // Otros atributos y métodos necesarios

    // Constructor
    public PoblacionBacterias(String nombre, Date fechaInicio, Date fechaFin, int numBacteriasIniciales, int temperatura,
                              String luminosidad, int dosisComidaInicial, int diaIncrementoComida, int comidaIncremento,
                              int comidaFinal) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numBacteriasIniciales = numBacteriasIniciales;
        this.temperatura = temperatura;
        this.luminosidad = luminosidad;
        this.dosisComidaInicial = dosisComidaInicial;
        this.diaIncrementoComida = diaIncrementoComida;
        this.comidaIncremento = comidaIncremento;
        this.comidaFinal = comidaFinal;
        // Inicializar otros atributos
    }

    // Getters y setters
    // Métodos necesarios para la gestión de poblaciones de bacterias, cálculo de comida, etc.
}

