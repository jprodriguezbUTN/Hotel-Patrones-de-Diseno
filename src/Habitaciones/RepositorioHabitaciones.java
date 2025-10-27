package Habitaciones;



import Habitaciones.Habitacion;
import java.util.*;

public class RepositorioHabitaciones {
    private final Map<Integer, Habitacion> data = new HashMap<>();

    public void guardar(Habitacion h) { data.put(h.getNumero(), h); }
    public Optional<Habitacion> buscar(int numero) { return Optional.ofNullable(data.get(numero)); }
    public List<Habitacion> listar() { return new ArrayList<>(data.values()); }
}
