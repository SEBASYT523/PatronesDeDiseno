package Patron;

public class NotificadorCliente implements Observador {

    private final Pedido pedido; 

    public NotificadorCliente(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void actualizar() {
        System.out.println("Mensaje enviado: tu pedido #"
                + pedido.getId() + " ahora está " + pedido.getEstado());
    }
}