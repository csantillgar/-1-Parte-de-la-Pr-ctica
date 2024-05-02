package logicadenegocio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {
    public Experimento abrirExperimento(String nombreArchivo) {
        Experimento experimento = null;
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            // Leer los datos del experimento desde el archivo
            String nombre = br.readLine();
            String fechaInicioStr = br.readLine();
            String fechaFinStr = br.readLine();
            // Convertir las fechas de String a LocalDate
            LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);
            LocalDate fechaFin = LocalDate.parse(fechaFinStr);
            // Crear el objeto Experimento
            experimento = new Experimento(nombre, fechaInicio, fechaFin);
        } catch (IOException e) {
            System.err.println("Error al abrir el archivo: " + e.getMessage());
        }
        return experimento;
    }

    public void guardarExperimento(Experimento experimento, String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir los datos del experimento en el archivo
            bw.write(experimento.getNombre());
            bw.newLine();
            bw.write(experimento.getFechaInicio().toString());
            bw.newLine();
            bw.write(experimento.getFechaFin().toString());
        } catch (IOException e) {
            System.err.println("Error al guardar el experimento: " + e.getMessage());
        }
    }

    public void guardarComoExperimento(Experimento experimento, String nuevoNombreArchivo) {
        guardarExperimento(experimento, nuevoNombreArchivo);
    }
}
