package examenordinariorepasodenuevo;

public class Tecnologicos extends Productos{
    
    private String tipo;

    public Tecnologicos(String tipo, String nombreProducto, int cantidad, int precio) {
        super(nombreProducto, cantidad, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\nEl tipo de aparato tecnologico es: " + this.tipo;
    }
}
