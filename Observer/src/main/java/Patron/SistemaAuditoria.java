package Patron;

public class SistemaAuditoria implements Observador {

    private final Pedido pedido;

    public SistemaAuditoria(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void actualizar() {
        System.out.println("Registro: pedido #"
                + pedido.getId() + " cambió a " + pedido.getEstado());
    }
}