package Facturacion;



import java.math.BigDecimal;

public class ItemFactura {
    private String concepto;
    private int cantidad;
    private BigDecimal precioUnitario;

    public ItemFactura(String concepto, int cantidad, BigDecimal precioUnitario) {
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getConcepto() { return concepto; }
    public int getCantidad() { return cantidad; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }

    public BigDecimal getSubtotal() {
        return precioUnitario.multiply(BigDecimal.valueOf(cantidad));
    }

    @Override
    public String toString() {
        return "ItemFactura{" +
                "concepto='" + concepto + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", subtotal=" + getSubtotal() +
                '}';
    }
}
