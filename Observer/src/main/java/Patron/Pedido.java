package Patron;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Sujeto {

    private final int id;
    private EstadoPedido estado;

    private final List<Observador> observadores = new ArrayList<>();

    public Pedido(int id) {
        this.id = id;
        this.estado = EstadoPedido.CREADO;
    }

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        System.out.println("[Pedido #" + id + "] Notificando a "
                + observadores.size() + " observador(es)");
      
        for (Observador o : new ArrayList<>(observadores)) {
            o.actualizar();
        }
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        EstadoPedido anterior = this.estado;
        this.estado = nuevoEstado;
        System.out.println("[Pedido #" + id + "] " + anterior + " -> " + nuevoEstado);
        notificarObservadores();
    }

    public int getId() {
        return id;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
}