package Lab3.JorgePalacios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void cargarProductosDesdeCSV(String archivoCSV) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Producto producto = Producto.fromCSV(linea);
                if (producto != null) {
                    productos.add(producto);
                }
            }
            System.out.println("Catálogo cargado desde archivo '" + archivoCSV + "'.");
        } catch (IOException e) {
            System.err.println("Error al cargar el catálogo desde archivo: " + e.getMessage());
        }
    }

    public void guardarProductosEnCSV(String archivoCSV) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCSV))) {
            for (Producto producto : productos) {
                writer.write(producto.toCSV());
                writer.newLine();
            }
            System.out.println("Catálogo guardado en archivo '" + archivoCSV + "'.");
        } catch (IOException e) {
            System.err.println("Error al guardar el catálogo en archivo: " + e.getMessage());
        }
    }

    public Producto buscarProductoPorID(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;  // Producto no encontrado
    }

    public ArrayList<Producto> listarProductosPorCategoria(String categoria) {
        ArrayList<Producto> productosCategoria = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto instanceof Bebida && categoria.equals("Bebida")) {
                productosCategoria.add(producto);
            } else if (producto instanceof Snack && categoria.equals("Snack")) {
                productosCategoria.add(producto);
            } else if (!producto.getClass().equals(Bebida.class) && !producto.getClass().equals(Snack.class) && categoria.equals("Producto")) {
                productosCategoria.add(producto);
            }
        }
        return productosCategoria;
    }

    public void mostrarInforme() {
        double ventasTotales = 0.0;
        double comisiones = 0.0;

        for (Producto producto : productos) {
            ventasTotales += producto.getPrecio() * producto.getCantidadVendidos();
            // Aquí puedes calcular comisiones basadas en tus reglas de negocio.
        }

        System.out.println("Informe del inventario:");
        System.out.println("Ventas Totales: " + ventasTotales);
        System.out.println("Comisiones: " + comisiones);
    }

    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // Ejemplo de carga y guardado de productos desde/hacia archivos CSV
        inventario.cargarProductosDesdeCSV("productos.csv");
        // Realiza operaciones con productos...
        inventario.guardarProductosEnCSV("productos_actualizados.csv");
    }
}
