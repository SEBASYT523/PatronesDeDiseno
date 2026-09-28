package AntiPatron;

public class AplMain {

    public static void main(String[] args) {
        System.out.println("=== AntiPatrón: Acoplamiento Directo ===\n");

        Pedido pedido = new Pedido(
                101,
                new NotificadorCliente(),
                new SistemaInventario(),
                new SistemaFacturacion());

        pedido.cambiarEstado(EstadoPedido.PAGADO);
        System.out.println();
        pedido.cambiarEstado(EstadoPedido.ENVIADO);
        System.out.println();
        pedido.cambiarEstado(EstadoPedido.ENTREGADO);
    }
}