package logicadenegocio;

import java.util.ArrayList;
import java.util.List;
import persistenciadatos.ExperimentoDAO;
import persistenciadatos.PoblacionBacteriasDAO;

public class GestorArchivos {
    public void guardarExperimento(Experimento experimento, String nombreArchivo) {
        ExperimentoDAO.guardarExperimento(experimento, nombreArchivo);
    }

    public Experimento cargarExperimento(String nombreArchivo) {
        return ExperimentoDAO.cargarExperimento(nombreArchivo);
    }

    public List<String> listarArchivosExperimento() {
        return ExperimentoDAO.listarArchivosExperimento();
    }

    // Métodos para guardar y cargar poblaciones de bacterias
    public void guardarPoblacionBacterias(PoblacionBacterias poblacion, String nombreArchivo) {
        PoblacionBacteriasDAO.guardarPoblacionBacterias(poblacion, nombreArchivo);
    }

    public PoblacionBacterias cargarPoblacionBacterias(String nombreArchivo) {
        return PoblacionBacteriasDAO.cargarPoblacionBacterias(nombreArchivo);
    }

    public List<String> listarArchivosPoblacionBacterias() {
        return PoblacionBacteriasDAO.listarArchivosPoblacionBacterias();
    }
}

