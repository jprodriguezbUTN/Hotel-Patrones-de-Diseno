package main;

import Facturacion.Notificaciones.ServicioNotificaciones;
import Facturacion.ServicioFacturacion;
import Reeservas.ServicioReservas;
import Facturacion.RepositorioFacturas;
import Huespedes.RepositorioHuespedes;
import Habitaciones.RepositorioHabitaciones;
import Reeservas.RepositorioReservas;
import Huespedes.Huesped;
import Habitaciones.Habitacion;
import Habitaciones.TipoHabitacion;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AppHotel {
    public static void main(String[] args) {
        // Repositorios
        RepositorioHabitaciones repoHab = new RepositorioHabitaciones();
        RepositorioHuespedes repoHue = new RepositorioHuespedes();
        RepositorioReservas repoRes = new RepositorioReservas();
        RepositorioFacturas repoFac = new RepositorioFacturas();

        // Datos base
        repoHab.guardar(new Habitacion(101, TipoHabitacion.SENCILLA, new BigDecimal("35000")));
        repoHab.guardar(new Habitacion(102, TipoHabitacion.DOBLE, new BigDecimal("55000")));
        repoHue.guardar(new Huesped("H-1", "Ana Pérez", "ana@correo.com", "8888-8888"));

        // Servicios
        ServicioReservas srvRes = new ServicioReservas(repoHab, repoHue, repoRes);
        ServicioFacturacion srvFac = new ServicioFacturacion(repoFac);
        ServicioNotificaciones srvNot = new ServicioNotificaciones();

        // Flujo
        var reserva = srvRes.crearReserva("R-1", "H-1", 101, LocalDate.now(), LocalDate.now().plusDays(2));
        var importe = srvRes.calcularImporte(reserva);
        var impuestos = importe.multiply(new BigDecimal("0.13"));
        var factura = srvFac.generarFactura("F-1001", reserva, importe, impuestos);

        srvNot.enviar(Facturacion.Notificaciones.CanalNotificacion.EMAIL, "ana@correo.com",
                "Reserva confirmada: " + reserva.getId() + ", total: " + factura.getTotal());

        srvRes.finalizarReserva("R-1");
        System.out.println("Factura generada: " + factura);
    }
}
