package persistenciadatos;

import logicadenegocio.Experimento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoExperimento {
    private static final String CARPETA_ARCHIVOS = "experimentos/";

    public static void guardarExperimento(Experimento experimento, String nombreArchivo) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(CARPETA_ARCHIVOS + nombreArchivo);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(experimento);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Experimento cargarExperimento(String nombreArchivo) {
        try (FileInputStream fileInputStream = new FileInputStream(CARPETA_ARCHIVOS + nombreArchivo);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Experimento) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> listarArchivosExperimento() {
        File carpeta = new File(CARPETA_ARCHIVOS);
        File[] archivos = carpeta.listFiles();
        List<String> nombresArchivos = new ArrayList<>();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    nombresArchivos.add(archivo.getName());
                }
            }
        }
        return nombresArchivos;
    }
}
