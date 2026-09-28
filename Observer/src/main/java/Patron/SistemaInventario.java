package Patron;

public class SistemaInventario implements Observador {

    private final Pedido pedido;

    public SistemaInventario(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void actualizar() {
        if (pedido.getEstado() == EstadoPedido.PAGADO) {
            System.out.println("Stock reducido por el pedido #" + pedido.getId());
        }
    }
}