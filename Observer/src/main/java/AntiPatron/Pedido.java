package AntiPatron;

public class Pedido {

    private final int id;
    private EstadoPedido estado;

    private  NotificadorCliente notificadorCliente;
    private  SistemaInventario sistemaInventario;
    private  SistemaFacturacion sistemaFacturacion;

    public Pedido(int id,
                  NotificadorCliente notificadorCliente,
                  SistemaInventario sistemaInventario,
                  SistemaFacturacion sistemaFacturacion) {
        this.id = id;
        this.estado = EstadoPedido.CREADO;
        this.notificadorCliente = notificadorCliente;
        this.sistemaInventario = sistemaInventario;
        this.sistemaFacturacion = sistemaFacturacion;
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        EstadoPedido anterior = this.estado;
        this.estado = nuevoEstado;
        System.out.println("[Pedido #" + id + "] " + anterior + " -> " + nuevoEstado);

       
        notificadorCliente.enviarMensaje(id, nuevoEstado);

        if (nuevoEstado == EstadoPedido.PAGADO) {
            sistemaInventario.reducirStock(id);
            sistemaFacturacion.generarFactura(id);
        }
       
    }

    public int getId() {
        return id;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
}