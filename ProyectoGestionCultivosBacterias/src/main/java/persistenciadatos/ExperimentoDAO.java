package persistenciadatos;

import logicadenegocio.Experimento;

import java.util.List;

public class ExperimentoDAO {
    public static void guardarExperimento(Experimento experimento, String nombreArchivo) {
        ArchivoExperimento.guardarExperimento(experimento, nombreArchivo);
    }

    public static Experimento cargarExperimento(String nombreArchivo) {
        return ArchivoExperimento.cargarExperimento(nombreArchivo);
    }

    public static List<String> listarArchivosExperimento() {
        return ArchivoExperimento.listarArchivosExperimento();
    }
}
