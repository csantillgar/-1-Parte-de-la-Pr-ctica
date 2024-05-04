package logicadenegocio;

import java.io.*;

public class GestorArchivos {

    public void guardarExperimento(Experimento experimento, File archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(experimento);
            System.out.println("Experimento guardado correctamente en: " + archivo.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Error al guardar el experimento en: " + archivo.getAbsolutePath());
        }
    }

    public Experimento cargarExperimento(File archivo) {
        Experimento experimento = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            experimento = (Experimento) ois.readObject();
            System.out.println("Experimento cargado correctamente desde: " + archivo.getAbsolutePath());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Error al cargar el experimento desde: " + archivo.getAbsolutePath());
        }
        return experimento;
    }
}

