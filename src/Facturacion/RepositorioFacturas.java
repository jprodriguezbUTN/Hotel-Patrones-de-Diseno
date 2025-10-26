package Facturacion;



import Facturacion.Factura;
import java.util.*;

public class RepositorioFacturas {
    private final Map<String, Factura> data = new HashMap<>();

    public void guardar(Factura f) { data.put(f.getNumero(), f); }
    public Optional<Factura> buscar(String numero) { return Optional.ofNullable(data.get(numero)); }
    public List<Factura> listar() { return new ArrayList<>(data.values()); }
}
