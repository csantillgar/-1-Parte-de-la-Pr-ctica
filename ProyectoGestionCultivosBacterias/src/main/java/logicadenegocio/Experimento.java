package logicadenegocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Experimento {
    private String nombreExperimento;
    private List<PoblacionBacterias> poblacionesBacterias;

    public Experimento(String nombreExperimento) {
        this.nombreExperimento = nombreExperimento;
        this.poblacionesBacterias = new ArrayList<>();
    }

    public Experimento(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombreExperimento = nombre;
        this.poblacionesBacterias = new ArrayList<>();
    }

    public String getNombreExperimento() {
        return nombreExperimento;
    }

    public void setNombreExperimento(String nombreExperimento) {
        this.nombreExperimento = nombreExperimento;
    }

    public List<PoblacionBacterias> getPoblacionesBacterias() {
        return poblacionesBacterias;
    }

    public void agregarPoblacionBacterias(PoblacionBacterias poblacionBacterias) {
        this.poblacionesBacterias.add(poblacionBacterias);
    }


    public List<PoblacionBacterias> getPoblaciones() {

        return null;
    }

    public void agregarPoblacion(PoblacionBacterias poblacion) {
    }

    public String getNombre() {

        return null;
    }

    public LocalDate getFechaInicio() {

        return null;
    }

    public boolean eliminarPoblacionPorNombre(String nombrePoblacion) {
        return false;
    }

    public PoblacionBacterias buscarPoblacionPorNombre(String nombrePoblacion) {

        return null;
    }

    public LocalDate getFechaFin() {
    return null;
    }
}

