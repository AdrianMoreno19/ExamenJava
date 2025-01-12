package examenordinariorepasodenuevo;

public class Usuarios {
    private String nombreApellidos;
    private int edad;
    private String username;
    private String password;
    private int saldo;

    public Usuarios(String nombreApellidos, int edad, String username, String password, int saldo) {
        this.nombreApellidos = nombreApellidos;
        this.edad = edad;
        this.username = username;
        this.password = password;
        this.saldo = saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getSaldo() {
        return saldo;
    }
   
}
