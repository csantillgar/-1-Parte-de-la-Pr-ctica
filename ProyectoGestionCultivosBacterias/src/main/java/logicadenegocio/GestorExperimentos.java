package logicadenegocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorExperimentos {
    private List<Experimento> experimentos;
    private Experimento experimentoActual;

    public GestorExperimentos() {
        this.experimentos = new ArrayList<>();
    }

    public void crearExperimento(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        Experimento experimento = new Experimento(nombre, fechaInicio, fechaFin);
        experimentos.add(experimento);
        this.experimentoActual = experimento;
    }

    public void agregarPoblacionBacterias(Experimento experimento, PoblacionBacterias poblacion) {
        experimento.agregarPoblacion(poblacion);
    }

    public Experimento buscarExperimentoPorNombre(String nombre) {
        for (Experimento experimento : experimentos) {
            if (experimento.getNombre().equalsIgnoreCase(nombre)) {
                return experimento;
            }
        }
        return null; // Si no se encuentra el experimento
    }

    public List<Experimento> buscarExperimentosPorFecha(LocalDate fecha) {
        List<Experimento> experimentosEnFecha = new ArrayList<>();
        for (Experimento experimento : experimentos) {
            if (fecha.equals(experimento.getFechaInicio()) || fecha.equals(experimento.getFechaFin())) {
                experimentosEnFecha.add(experimento);
            }
        }
        return experimentosEnFecha;
    }

    public boolean borrarPoblacion(String nombrePoblacion) {
        return experimentoActual != null && experimentoActual.eliminarPoblacionPorNombre(nombrePoblacion);
    }

    public List<String> getPoblacionesExperimentoActual() {
        if (experimentoActual != null) {
            List<PoblacionBacterias> poblaciones = experimentoActual.getPoblaciones();
            List<String> nombresPoblaciones = new ArrayList<>();
            for (PoblacionBacterias poblacion : poblaciones) {
                nombresPoblaciones.add(poblacion.getNombre());
            }
            return nombresPoblaciones;
        }
        return new ArrayList<>();
    }

    public String getDetallesPoblacion(String nombrePoblacion) {
        if (experimentoActual != null) {
            PoblacionBacterias poblacion = experimentoActual.buscarPoblacionPorNombre(nombrePoblacion);
            if (poblacion != null) {
                return poblacion.toString();
            }
        }
        return null;
    }

    public List<Experimento> getExperimentos() {
        return experimentos;
    }

    public void setExperimentos(List<Experimento> experimentos) {
        this.experimentos = experimentos;
    }

    public Experimento getExperimentoActual() {
        return experimentoActual;
    }

    public void setExperimentoActual(Experimento experimento) {
        this.experimentoActual = experimento;
    }

    public void eliminarPoblacionPorNombre(String nombrePoblacion) {
        if (experimentoActual != null) {
            experimentoActual.eliminarPoblacionPorNombre(nombrePoblacion);
        }
    }
}


