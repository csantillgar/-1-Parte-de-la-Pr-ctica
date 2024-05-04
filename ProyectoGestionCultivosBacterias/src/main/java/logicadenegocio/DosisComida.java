package logicadenegocio;

public class DosisComida {
    private int cantidadInicial;
    private int diaIncremento;
    private int comidaDiaIncremento;
    private int cantidadFinal;

    public DosisComida(int cantidadInicial, int diaIncremento, int comidaDiaIncremento, int cantidadFinal) {
        this.cantidadInicial = cantidadInicial;
        this.diaIncremento = diaIncremento;
        this.comidaDiaIncremento = comidaDiaIncremento;
        this.cantidadFinal = cantidadFinal;
    }

    // Getters y setters

    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(int cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public int getDiaIncremento() {
        return diaIncremento;
    }

    public void setDiaIncremento(int diaIncremento) {
        this.diaIncremento = diaIncremento;
    }

    public int getComidaDiaIncremento() {
        return comidaDiaIncremento;
    }

    public void setComidaDiaIncremento(int comidaDiaIncremento) {
        this.comidaDiaIncremento = comidaDiaIncremento;
    }

    public int getCantidadFinal() {
        return cantidadFinal;
    }

    public void setCantidadFinal(int cantidadFinal) {
        this.cantidadFinal = cantidadFinal;
    }
}
