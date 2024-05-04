package persistenciadatos;

import logicadenegocio.PoblacionBacterias;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PoblacionBacteriasDAO {
    private static final String CARPETA_ARCHIVOS = "poblaciones/";

    public static void guardarPoblacionBacterias(PoblacionBacterias poblacion, String nombreArchivo) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(CARPETA_ARCHIVOS + nombreArchivo);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(poblacion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PoblacionBacterias cargarPoblacionBacterias(String nombreArchivo) {
        try (FileInputStream fileInputStream = new FileInputStream(CARPETA_ARCHIVOS + nombreArchivo);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (PoblacionBacterias) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> listarArchivosPoblacionBacterias() {
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
