package Patron;

public class SistemaFacturacion implements Observador {

    private final Pedido pedido;

    public SistemaFacturacion(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void actualizar() {
        if (pedido.getEstado() == EstadoPedido.PAGADO) {
            System.out.println("Factura generada para el pedido #" + pedido.getId());
        }
    }
}