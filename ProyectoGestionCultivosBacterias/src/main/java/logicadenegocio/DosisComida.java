package logicadenegocio;

public class DosisComida {
    private int cantidadInicial;
    private int diaIncremento;
    private int comidaDiaIncremento;
    private int cantidadFinal;

    public DosisComida(int cantidadInicial, int diaIncremento, int comidaDiaIncremento, int cantidadFinal) {
        if (cantidadInicial < 0 || diaIncremento < 1 || diaIncremento > 30 || comidaDiaIncremento < 0 || cantidadFinal < 0) {
            throw new IllegalArgumentException("Los valores proporcionados para la dosis de comida no son válidos.");
        }
        this.cantidadInicial = cantidadInicial;
        this.diaIncremento = diaIncremento;
        this.comidaDiaIncremento = comidaDiaIncremento;
        this.cantidadFinal = cantidadFinal;
    }

    public int getCantidadInicial() {
        return cantidadInicial;
    }
    public int getDiaIncremento() {
        return diaIncremento;
    }
    public int getComidaDiaIncremento() {
        return comidaDiaIncremento;
    }
    public int getCantidadFinal() {
        return cantidadFinal;
    }
    public int calcularCantidadComida(int dia) {
        if (dia < 1 || dia > 30) {
            throw new IllegalArgumentException("El día especificado no es válido.");
        }
        if (dia <= diaIncremento) {
            return cantidadInicial + (dia - 1) * comidaDiaIncremento;
        } else if (dia <= 30) {
            int diasRestantes = 30 - diaIncremento;
            return cantidadInicial + diasRestantes * comidaDiaIncremento - (dia - diaIncremento) * comidaDiaIncremento;
        } else {
            return cantidadFinal;
        }
    }
}
