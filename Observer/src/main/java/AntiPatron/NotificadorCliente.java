package AntiPatron;
public class NotificadorCliente {
    public void enviarMensaje(int idPedido, EstadoPedido estado) {
        System.out.println("Mensaje enviado: tu pedido #"
                + idPedido + " ahora está " + estado);
    }
}