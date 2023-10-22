package Lab3.JorgePalacios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Producto {
    private int id;
    private String nombre;
    private int cantidadDisponible;
    private int cantidadVendidos;
    private boolean estado;
    private double precio;

    public Producto(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean estado, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadVendidos = cantidadVendidos;
        this.estado = estado;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidadVendidos() {
        return cantidadVendidos;
    }

    public void setCantidadVendidos(int cantidadVendidos) {
        this.cantidadVendidos = cantidadVendidos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toCSV() {
        return id + "," + nombre + "," + cantidadDisponible + "," + cantidadVendidos + "," + estado + "," + precio;
    }

    public static Producto fromCSV(String linea) {
        String[] datos = linea.split(",");
        if (datos.length != 6) {
            return null;
        }
        int id = Integer.parseInt(datos[0]);
        String nombre = datos[1];
        int cantidadDisponible = Integer.parseInt(datos[2]);
        int cantidadVendidos = Integer.parseInt(datos[3]);
        boolean estado = Boolean.parseBoolean(datos[4]);
        double precio = Double.parseDouble(datos[5]);
        return new Producto(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
    }
}