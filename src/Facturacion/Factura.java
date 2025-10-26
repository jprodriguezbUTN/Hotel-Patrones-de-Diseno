package Facturacion;



import Huespedes.Huesped;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private String numero;
    private Huesped huesped;
    private LocalDateTime fecha;
    private List<ItemFactura> items;

    public Factura(String numero, Huesped huesped) {
        this.numero = numero;
        this.huesped = huesped;
        this.fecha = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemFactura item) { items.add(item); }

    public BigDecimal getTotal() {
        return items.stream()
                .map(ItemFactura::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getNumero() { return numero; }
    public Huesped getHuesped() { return huesped; }
    public LocalDateTime getFecha() { return fecha; }
    public List<ItemFactura> getItems() { return items; }

    @Override
    public String toString() {
        return "Factura{" +
                "numero='" + numero + '\'' +
                ", huesped=" + huesped +
                ", fecha=" + fecha +
                ", total=" + getTotal() +
                '}';
    }
}
