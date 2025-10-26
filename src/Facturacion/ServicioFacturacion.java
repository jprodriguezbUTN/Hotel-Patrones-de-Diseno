package Facturacion;



import Facturacion.RepositorioFacturas;
import Reeservas.Reserva;
import Facturacion.Factura;
import Facturacion.ItemFactura;

import java.math.BigDecimal;

public class ServicioFacturacion {
    private final RepositorioFacturas repo;

    public ServicioFacturacion(RepositorioFacturas repo) {
        this.repo = repo;
    }

    public Factura generarFactura(String numero, Reserva reserva, BigDecimal importeAlojamiento, BigDecimal impuestos) {
        Factura f = new Factura(numero, reserva.getHuesped());
        f.agregarItem(new ItemFactura("Alojamiento habitación " + reserva.getHabitacion().getNumero(), 1, importeAlojamiento));
        if (impuestos.compareTo(BigDecimal.ZERO) > 0) {
            f.agregarItem(new ItemFactura("Impuestos", 1, impuestos));
        }
        repo.guardar(f);
        return f;
    }
}
