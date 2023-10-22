package Lab3.JorgePalacios;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Inventario
        Inventario inventario = new Inventario();

        // Cargar productos desde un archivo CSV
        inventario.cargarProductosDesdeCSV("productos.csv");

        // Determinar la categoría de los productos y listar productos de una categoría
        String categoria = "Bebida"; // Cambia esto por la categoría que desees
        ArrayList<Producto> productosCategoria = new ArrayList<>();

        // Lógica para determinar la categoría de cada producto
        for (Producto producto : inventario.getProductos()) {
            if (producto instanceof Bebida && categoria.equals("Bebida")) {
                productosCategoria.add(producto);
            } else if (producto instanceof Snack && categoria.equals("Snack")) {
                productosCategoria.add(producto);
            }
            // Puedes agregar más categorías y lógica según tus necesidades
        }

        // Mostrar productos de la categoría seleccionada
        System.out.println("Productos de la categoría: " + categoria);
        for (Producto producto : productosCategoria) {
            System.out.println(producto);
        }
    }
}
