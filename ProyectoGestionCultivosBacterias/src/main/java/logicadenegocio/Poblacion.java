package logicadenegocio;
public class Poblacion {
    private String nombre;
    private int numeroIndividuos;
    private String fechaRegistro;

    public Poblacion(String nombre, int numeroIndividuos, String fechaRegistro) {
        this.nombre = nombre;
        this.numeroIndividuos = numeroIndividuos;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroIndividuos() {
        return numeroIndividuos;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }
}
