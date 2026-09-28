package Patron;

public class AplMain {

    public static void main(String[] args) {
        System.out.println("=== Patrón Observer ===\n");

        Pedido pedido = new Pedido(101);

        Observador notificador = new NotificadorCliente(pedido);
        Observador inventario = new SistemaInventario(pedido);
        Observador facturacion = new SistemaFacturacion(pedido);

        System.out.println("--- Se registran 3 observadores ---");
        pedido.agregarObservador(notificador);
        pedido.agregarObservador(inventario);
        pedido.agregarObservador(facturacion);
        pedido.cambiarEstado(EstadoPedido.PAGADO);

        System.out.println("\n--- Se elimina NotificadorCliente ---");
        pedido.eliminarObservador(notificador);
        pedido.cambiarEstado(EstadoPedido.ENVIADO);

        System.out.println("\n--- Se agrega SistemaAuditoria SIN modificar Pedido ---");
        pedido.agregarObservador(new SistemaAuditoria(pedido));
        pedido.cambiarEstado(EstadoPedido.ENTREGADO);
    }
}