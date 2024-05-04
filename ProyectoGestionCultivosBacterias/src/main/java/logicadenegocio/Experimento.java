package logicadenegocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Experimento {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<PoblacionBacterias> poblaciones;

    // Constructor
    public Experimento(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.poblaciones = new ArrayList<>();
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

    public List<PoblacionBacterias> getPoblaciones() {
        return poblaciones;
    }

    public void setPoblaciones(List<PoblacionBacterias> poblaciones) {
        this.poblaciones = poblaciones;
    }

    public void agregarPoblacion(PoblacionBacterias poblacion) {
        poblaciones.add(poblacion);
    }

    public boolean eliminarPoblacionPorNombre(String nombrePoblacion) {
        PoblacionBacterias poblacion = buscarPoblacionPorNombre(nombrePoblacion);
        if (poblacion != null) {
            return poblaciones.remove(poblacion);
        }
        return false;
    }

    public int calcularDuracionExperimento() {
        return fechaInicio.until(fechaFin).getDays() + 1;
    }

    public PoblacionBacterias buscarPoblacionPorNombre(String nombrePoblacion) {
        for (PoblacionBacterias poblacion : poblaciones) {
            if (poblacion.getNombre().equalsIgnoreCase(nombrePoblacion)) {
                return poblacion;
            }
        }
        return null;
    }

    public String getDetallesPoblacion(String nombrePoblacion) {
        for (PoblacionBacterias poblacion : poblaciones) {
            if (poblacion.getNombre().equalsIgnoreCase(nombrePoblacion)) {
                return poblacion.toString();
            }
        }
        return null; // Si no se encontró la población con el nombre especificado
    }

}
