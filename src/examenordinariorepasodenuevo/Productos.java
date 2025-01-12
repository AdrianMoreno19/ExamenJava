package examenordinariorepasodenuevo;

public abstract class Productos {
    
    private String nombreProducto;
    private int cantidad;
    private int precio;

    public Productos(String nombreProducto, int cantidad, int precio) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "EL nombre del producto es: " + this.nombreProducto + 
               "\nLa cantidad de ese producto es: " + this.cantidad + 
               "\nEl precio del producto es: " + this.precio;
    }
}
