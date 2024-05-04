package logicadenegocio;
import logicadenegocio.PoblacionBacterias;

import java.util.ArrayList;
import java.util.List;


public class GestorPoblaciones {

    private List<PoblacionBacterias> poblaciones;

    public GestorPoblaciones() {
        this.poblaciones = new ArrayList<>();
    }

    public void agregarPoblacion(PoblacionBacterias poblacion) {
        poblaciones.add(poblacion);
    }

    public void borrarPoblacion(String nombrePoblacion) {
        PoblacionBacterias poblacion = buscarPoblacionPorNombre(nombrePoblacion);
        if (poblacion != null) {
            poblaciones.remove(poblacion);
            System.out.println("La población '" + nombrePoblacion + "' ha sido eliminada correctamente.");
        } else {
            System.out.println("No se pudo encontrar la población '" + nombrePoblacion + "'.");
        }
    }

    private PoblacionBacterias buscarPoblacionPorNombre(String nombrePoblacion) {
        for (PoblacionBacterias poblacion : poblaciones) {
            if (poblacion.getNombre().equals(nombrePoblacion)) {
                return poblacion;
            }
        }
        return null;
    }

    public Poblacion obtenerPoblacion(String nombrePoblacion) {

        return null;
    }
}
