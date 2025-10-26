package Facturacion.Notificaciones;



import Facturacion.Notificaciones.CanalNotificacion;
import Facturacion.Notificaciones.Notificacion;

public class ServicioNotificaciones {
    public Notificacion enviar(CanalNotificacion canal, String destinatario, String mensaje) {
        Notificacion n = new Notificacion(java.util.UUID.randomUUID().toString(), canal, destinatario, mensaje);
        // Simulación de envío
        n.marcarEnviada();
        System.out.println("[NOTIFICACION] " + n);
        return n;
    }
}
