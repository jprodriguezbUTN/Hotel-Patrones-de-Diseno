package Huespedes;



import Huespedes.Huesped;
import java.util.*;

public class RepositorioHuespedes {
    private final Map<String, Huesped> data = new HashMap<>();

    public void guardar(Huesped h) { data.put(h.getId(), h); }
    public Optional<Huesped> buscar(String id) { return Optional.ofNullable(data.get(id)); }
    public List<Huesped> listar() { return new ArrayList<>(data.values()); }
}
