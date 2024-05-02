package logicadenegocio;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

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
        // Agregar población de bacterias al experimento específico
        // Implementar lógica según sea necesario
    }

    // Otros métodos necesarios para la gestión de experimentos

    // Getters y setters
}