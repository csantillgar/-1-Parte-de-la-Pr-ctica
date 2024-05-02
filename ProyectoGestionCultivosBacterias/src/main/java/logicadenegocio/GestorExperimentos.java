package logicadenegocio;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class GestorExperimentos {
    private List<Experimento> experimentos;

    public GestorExperimentos() {
        this.experimentos = new ArrayList<>();
    }

    public void crearExperimento(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        Experimento experimento = new Experimento(nombre, fechaInicio, fechaFin);
        experimentos.add(experimento);
    }

    public void agregarPoblacionBacterias(Experimento experimento, PoblacionBacterias poblacion) {
        experimento.agregarPoblacion(poblacion);
    }

    // Método para buscar experimentos por nombre exacto
    public Experimento buscarExperimentoPorNombre(String nombre) {
        for (Experimento experimento : experimentos) {
            if (experimento.getNombre().equalsIgnoreCase(nombre)) {
                return experimento;
            }
        }
        return null; // Si no se encuentra el experimento
    }

    // Método para buscar experimentos por fecha de inicio o fin
    public List<Experimento> buscarExperimentosPorFecha(LocalDate fecha) {
        List<Experimento> experimentosEnFecha = new ArrayList<>();
        for (Experimento experimento : experimentos) {
            if (fecha.equals(experimento.getFechaInicio()) || fecha.equals(experimento.getFechaFin())) {
                experimentosEnFecha.add(experimento);
            }
        }
        return experimentosEnFecha;
    }

    // Método para cargar experimentos desde un archivo
    public void cargarExperimentos(String nombreArchivo) {
        // Implementa la lógica para cargar los experimentos desde un archivo
    }

    // Método para guardar experimentos en un archivo
    public void guardarExperimentos(String nombreArchivo) {
        // Implementa la lógica para guardar los experimentos en un archivo
    }

    // Getters y setters
    public List<Experimento> getExperimentos() {
        return experimentos;
    }

    public void setExperimentos(List<Experimento> experimentos) {
        this.experimentos = experimentos;
    }
}


