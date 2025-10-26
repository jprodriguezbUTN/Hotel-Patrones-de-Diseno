package Huespedes;



public class MetodoPago {
    private String tipo; // tarjeta, transferencia, efectivo
    private String detalle;

    public MetodoPago(String tipo, String detalle) {
        this.tipo = tipo;
        this.detalle = detalle;
    }

    public String getTipo() { return tipo; }
    public String getDetalle() { return detalle; }
}
