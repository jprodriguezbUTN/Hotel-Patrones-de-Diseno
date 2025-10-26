package Reeservas;



import Huespedes.Huesped;
import Habitaciones.Habitacion;
import java.time.LocalDate;

public class Reserva {
    private String id;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoReserva estado;

    public Reserva(String id, Huesped huesped, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = EstadoReserva.PENDIENTE;
    }

    public String getId() { return id; }
    public Huesped getHuesped() { return huesped; }
    public Habitacion getHabitacion() { return habitacion; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public EstadoReserva getEstado() { return estado; }
    public void setEstado(EstadoReserva estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", huesped=" + huesped +
                ", habitacion=" + habitacion +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", estado=" + estado +
                '}';
    }
}
