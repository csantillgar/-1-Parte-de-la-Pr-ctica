package logicadenegocio;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class Experimento {
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private List<PoblacionBacterias> poblaciones;

    // Constructor
    public Experimento(String nombre, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.poblaciones = new ArrayList<>();
        // Inicializar otros atributos
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<PoblacionBacterias> getPoblaciones() {
        return poblaciones;
    }
    public void setPoblaciones(List<PoblacionBacterias> poblaciones) {
        this.poblaciones = poblaciones;
    }

    public void agregarPoblacion(PoblacionBacterias poblacion) {
        poblaciones.add(poblacion);
    }

    public void eliminarPoblacion(PoblacionBacterias poblacion) {
        poblaciones.remove(poblacion);
    }
}

