package Facturacion.Notificaciones;



import java.time.LocalDateTime;

public class Notificacion {
    private String id;
    private CanalNotificacion canal;
    private String destinatario;
    private String mensaje;
    private EstadoNotificacion estado;
    private LocalDateTime fecha;

    public Notificacion(String id, CanalNotificacion canal, String destinatario, String mensaje) {
        this.id = id;
        this.canal = canal;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.estado = EstadoNotificacion.PENDIENTE;
        this.fecha = LocalDateTime.now();
    }

    public void marcarEnviada() { this.estado = EstadoNotificacion.ENVIADA; }

    @Override
    public String toString() {
        return "Notificacion{" +
                "id='" + id + '\'' +
                ", canal=" + canal +
                ", destinatario='" + destinatario + '\'' +
                ", estado=" + estado +
                ", fecha=" + fecha +
                '}';
    }
}
