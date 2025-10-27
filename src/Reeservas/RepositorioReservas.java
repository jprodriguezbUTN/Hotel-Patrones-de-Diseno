package Reeservas;



import Reeservas.Reserva;
import java.util.*;

public class RepositorioReservas {
    private final Map<String, Reserva> data = new HashMap<>();

    public void guardar(Reserva r) { data.put(r.getId(), r); }
    public Optional<Reserva> buscar(String id) { return Optional.ofNullable(data.get(id)); }
    public List<Reserva> listar() { return new ArrayList<>(data.values()); }
}
