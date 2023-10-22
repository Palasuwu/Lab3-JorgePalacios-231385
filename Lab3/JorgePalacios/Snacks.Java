package Lab3.JorgePalacios;
class Snack extends Producto {
    private int gramos;
    private String sabor;
    private String tamaño;

    public Snack(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean estado, double precio, int gramos, String sabor, String tamaño) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.gramos = gramos;
        this.sabor = sabor;
        this.tamaño = tamaño;
    }

    public int getGramos() {
        return gramos;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + gramos + "," + sabor + "," + tamaño;
    }

    public static Snack fromCSV(String linea) {
        Producto producto = Producto.fromCSV(linea);
        if (producto instanceof Snack) {
            return (Snack) producto;
        }
        return null;
    }
}