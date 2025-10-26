package Habitaciones;



import java.math.BigDecimal;

public class Habitacion {
    private int numero;
    private TipoHabitacion tipo;
    private BigDecimal precioNoche;
    private boolean disponible;

    public Habitacion(int numero, TipoHabitacion tipo, BigDecimal precioNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
        this.disponible = true;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public TipoHabitacion getTipo() { return tipo; }
    public void setTipo(TipoHabitacion tipo) { this.tipo = tipo; }

    public BigDecimal getPrecioNoche() { return precioNoche; }
    public void setPrecioNoche(BigDecimal precioNoche) { this.precioNoche = precioNoche; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numero +
                ", tipo=" + tipo +
                ", precioNoche=" + precioNoche +
                ", disponible=" + disponible +
                '}';
    }
}
