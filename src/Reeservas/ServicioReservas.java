package Reeservas;



import Habitaciones.RepositorioHabitaciones;
import Huespedes.RepositorioHuespedes;
import Reeservas.RepositorioReservas;
import Habitaciones.Habitacion;
import Huespedes.Huesped;
import Reeservas.Reserva;
import Reeservas.EstadoReserva;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class ServicioReservas {
    private final RepositorioHabitaciones repoHab;
    private final RepositorioHuespedes repoHue;
    private final RepositorioReservas repoRes;

    public ServicioReservas(RepositorioHabitaciones repoHab, RepositorioHuespedes repoHue, RepositorioReservas repoRes) {
        this.repoHab = repoHab;
        this.repoHue = repoHue;
        this.repoRes = repoRes;
    }

    public Reserva crearReserva(String idReserva, String idHuesped, int numHab, java.time.LocalDate ini, java.time.LocalDate fin) {
        Huesped h = repoHue.buscar(idHuesped).orElseThrow(() -> new IllegalArgumentException("Huésped no existe"));
        Habitacion hab = repoHab.buscar(numHab).orElseThrow(() -> new IllegalArgumentException("Habitación no existe"));
        if (!hab.isDisponible()) throw new IllegalStateException("Habitación no disponible");
        Reserva r = new Reserva(idReserva, h, hab, ini, fin);
        r.setEstado(EstadoReserva.CONFIRMADA);
        hab.setDisponible(false);
        repoRes.guardar(r);
        return r;
    }

    public BigDecimal calcularImporte(Reserva r) {
        long noches = ChronoUnit.DAYS.between(r.getFechaInicio(), r.getFechaFin());
        if (noches <= 0) noches = 1;
        return r.getHabitacion().getPrecioNoche().multiply(BigDecimal.valueOf(noches));
    }

    public void finalizarReserva(String idReserva) {
        Reserva r = repoRes.buscar(idReserva).orElseThrow(() -> new IllegalArgumentException("Reserva no existe"));
        r.setEstado(EstadoReserva.FINALIZADA);
        r.getHabitacion().setDisponible(true);
    }

    public void cancelarReserva(String idReserva) {
        Reserva r = repoRes.buscar(idReserva).orElseThrow(() -> new IllegalArgumentException("Reserva no existe"));
        r.setEstado(EstadoReserva.CANCELADA);
        r.getHabitacion().setDisponible(true);
    }
}
