package examenordinariorepasodenuevo;

public class Juguetes extends Productos{
    
    private int edad;

    public Juguetes(int edad, String nombreProducto, int cantidad, int precio) {
        super(nombreProducto, cantidad, precio);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nLa edad es: " + this.edad; 
    }
}
