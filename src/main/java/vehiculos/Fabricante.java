package vehiculos;

import java.util.ArrayList;
import java.util.List;

public class Fabricante {
    private String nombre;
    private Pais pais;
    private static List<Vehiculo> listaVehiculos = Vehiculo.listaVehiculos;

    public Fabricante(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public static Fabricante fabricaMayorVentas() {
        Fabricante fabricaMayorVentas = null;
        int maxVentas = 0;

        for (Fabricante fabricante : obtenerListaFabricantes()) {
            int ventas = contarVentasPorFabricante(fabricante);
            if (ventas > maxVentas) {
                maxVentas = ventas;
                fabricaMayorVentas = fabricante;
            }
        }
        return fabricaMayorVentas;
    }

    private static List<Fabricante> obtenerListaFabricantes() {
        List<Fabricante> listaFabricantes = new ArrayList<>();
        for (Vehiculo vehiculo : listaVehiculos) {
            Fabricante fabricante = vehiculo.getFabricante();
            if (!listaFabricantes.contains(fabricante)) {
                listaFabricantes.add(fabricante);
            }
        }
        return listaFabricantes;
    }

    private static int contarVentasPorFabricante(Fabricante fabricante) {
        int contador = 0;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getFabricante().equals(fabricante)) {
                contador++;
            }
        }
        return contador;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}