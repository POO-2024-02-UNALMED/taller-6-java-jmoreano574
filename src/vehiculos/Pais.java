package vehiculos;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String nombre;
    public Pais(String nombre) {
        this.nombre = nombre;
    }
    private static List<Vehiculo> listaVehiculos = Vehiculo.listaVehiculos;
    private static List<Pais> obtenerListaPaises() {
        List<Pais> listaPaises = new ArrayList<>();
        for (Vehiculo vehiculo : listaVehiculos) {
            Pais pais = vehiculo.getFabricante().getPais();
            if (!listaPaises.contains(pais)) {
                listaPaises.add(pais);
            }
        }
        return listaPaises;
    }

    private static int contarVentasPorPais(Pais pais) {
        int contador = 0;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getFabricante().getPais().equals(pais)) {
                contador++;
            }
        }
        return contador;
    }

    public static Pais paisMasVendedor() {
        Pais paisMasVendedor = null;
        int ventasMax = 0;

        for (Pais pais : obtenerListaPaises()) {
            int ventas = contarVentasPorPais(pais);
            if (ventas > ventasMax) {
                ventasMax = ventas;
                paisMasVendedor = pais;
            }
        }
        return paisMasVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}