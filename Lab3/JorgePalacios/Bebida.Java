package Lab3.JorgePalacios;
class Bebida extends Producto {
    private int mililitros;
    private String tipo;

    public Bebida(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean estado, double precio, int mililitros, String tipo) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.mililitros = mililitros;
        this.tipo = tipo;
    }

    public int getMililitros() {
        return mililitros;
    }

    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + mililitros + "," + tipo;
    }

    public static Bebida fromCSV(String linea) {
        Producto producto = Producto.fromCSV(linea);
        if (producto instanceof Bebida) {
            return (Bebida) producto;
        }
        return null;
    }
}