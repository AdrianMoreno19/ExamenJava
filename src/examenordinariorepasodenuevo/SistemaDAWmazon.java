package examenordinariorepasodenuevo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDAWmazon {

    private ArrayList<Productos> losProductos = new ArrayList();
    private ArrayList<Usuarios> losUsuarios = new ArrayList();
    ;
    protected int usuarioActivo;
    private Scanner datos;

    public SistemaDAWmazon() {
        //Aqui lo que hacemos es añadir al arraylist de Productos los productos directamente
        //en el construcor para que cada vez que iniciemos aplicacion se generen automaticamente
        Juguetes j1 = new Juguetes(12, "Sonajero", 20, 10);
        this.losProductos.add(j1);
        Juguetes j2 = new Juguetes(10, "Balon", 11, 20);
        this.losProductos.add(j2);
        Juguetes j3 = new Juguetes(2, "Chupete", 5, 5);
        this.losProductos.add(j3);
        Tecnologicos T1 = new Tecnologicos("Informatica", "RAM", 20, 100);
        this.losProductos.add(T1);
        Tecnologicos T2 = new Tecnologicos("Consola", "PS5", 1, 300);
        this.losProductos.add(T2);
        Tecnologicos T3 = new Tecnologicos("Tablet", "iPad", 24, 250);
        this.losProductos.add(T3);

        String users = "";
        ArrayList<String> ayuda = new ArrayList();
        try {
            FileReader miLector = new FileReader("usuarios.txt");
            BufferedReader miBuffer = new BufferedReader(miLector);
            while (users != null) {
                users = miBuffer.readLine();
                ayuda.add(users);
            }
        } catch (IOException e) {
            System.err.println("ARCHIVO NO ENCONTRADO");
        }

        Usuarios u1 = new Usuarios(ayuda.get(0), 13, ayuda.get(2), ayuda.get(3), 200);
        this.losUsuarios.add(u1);
        Usuarios u2 = new Usuarios(ayuda.get(5), 18, ayuda.get(7), ayuda.get(8), 100);
        this.losUsuarios.add(u2);
        Usuarios u3 = new Usuarios(ayuda.get(10), 8, ayuda.get(12), ayuda.get(13), 20);
        this.losUsuarios.add(u3);
        Usuarios u4 = new Usuarios(ayuda.get(15), 43, ayuda.get(17), ayuda.get(18), 1000);
        this.losUsuarios.add(u4);

        this.usuarioActivo = -1;
        this.datos = new Scanner(System.in);
    }

    public boolean validador(String usu, String passwd) {
        try {
            if (usu.equalsIgnoreCase("") || usu.equalsIgnoreCase(" ")) {
                throw new Exception();
            }
            if (passwd.equalsIgnoreCase("") || passwd.equalsIgnoreCase(" ")) {
                throw new Exception();
            }
            return false;
        } catch (Exception e) {
            System.out.println("Datos Erroneos Vuelve a introducirlos de nuevo");
        }
        return true;
    }

    public boolean hacerLogin() {
        boolean parada = false;
        String nombreUsu = "";
        String pass = "";
        try {
            do {
                System.out.println("Introduce el nombre de usuario");
                nombreUsu = datos.nextLine();
                System.out.println("Introduce la password");
                pass = datos.nextLine();
                validador(nombreUsu, pass);
                parada = true;
            } while (parada == false);
            for (Usuarios actual : this.losUsuarios) {
                if (actual.getUsername().equals(nombreUsu) && actual.getPassword().equals(pass)) {
                    this.usuarioActivo = this.losUsuarios.indexOf(actual);
                    System.out.println("Has iniciado sesion bienvenido " + actual.getNombreApellidos());
                    return true;
                } else if (actual.getUsername().equals(nombreUsu) && actual.getPassword().equals(pass)) {
                    System.out.println("No has iniciado sesion");
                    this.usuarioActivo = -1;
                }
            }
        } catch (Exception e) {
            System.out.println("Datos erroneos");
        }
        return false;
    }

    public void usuarioActivo() {
        if (this.usuarioActivo != -1) {
            System.out.println("El usuario activo es el numero: " + this.usuarioActivo);
        } else {
            System.out.println("El usuario no esta activo");
        }
    }

    public void mostrarProductos() {
        for (Productos actual : losProductos) {
            if (actual instanceof Juguetes) {
                Juguetes jugue = (Juguetes) actual;
                System.out.println("Categoria Juguetes");
                System.out.println("---------------------");
                System.out.println(actual);
                System.out.println("---------------------");
            }
            if (actual instanceof Tecnologicos) {
                Tecnologicos tecno = (Tecnologicos) actual;
                System.out.println("Categoria Tecnologica");
                System.out.println("---------------------");
                System.out.println(actual);
                System.out.println("---------------------");
            }
        }
    }

    public boolean buscarJuguete() {
        int edadDeseada;
        System.out.println("Introduce la edad");
        edadDeseada = this.datos.nextInt();
        for (Productos actual : losProductos) {
            if (actual instanceof Juguetes) {
                Juguetes jugue = (Juguetes) actual;
                if (edadDeseada == jugue.getEdad()) {
                    System.out.println("---------------------");
                    System.out.println(actual);
                    System.out.println("---------------------");
                    return true;
                }
            }
        }
        System.out.println("No se ha encontrado la edad deseada");
        return false;
    }

    public boolean buscarTecnologia() {
        String nombreTecnologiaDeseada;
        System.out.println("Introduce el nombre de la tecnologia deseada");
        nombreTecnologiaDeseada = this.datos.nextLine();
        for (Productos actual : losProductos) {
            if (actual instanceof Tecnologicos) {
                Tecnologicos tecno = (Tecnologicos) actual;
                if (nombreTecnologiaDeseada.equalsIgnoreCase(tecno.getNombreProducto())) {
                    System.out.println("---------------------");
                    System.out.println(actual);
                    System.out.println("---------------------");
                    return true;
                }
            }
        }
        System.out.println("No se ha encontrado el nombre de la tecnologia deseada");
        return false;
    }

    public boolean comprar() {
        int numIndice = 0;
        int numeroIndiceDeseado;
        for (Productos actual : losProductos) {
            System.out.println(numIndice + " - " + actual.getNombreProducto());
            numIndice++;
        }
        System.out.println("Introduce el indice deseado");
        numeroIndiceDeseado = datos.nextInt();
        for (Productos actual : losProductos) {
            if (numeroIndiceDeseado == this.losProductos.indexOf(actual)) {
                if (actual instanceof Juguetes) {
                    Juguetes jugue = (Juguetes) actual;
                    if (jugue.getCantidad() == 0) {
                        System.out.println("No queda stock del producto juguete");
                        return false;
                    }
                    for (Usuarios actuUsu : losUsuarios) {
                        if (actuUsu.getEdad() >= jugue.getEdad()) {
                            System.out.println("La venta esta permitida");
                            if (actuUsu.getSaldo() > jugue.getPrecio()) {
                                actuUsu.setSaldo(actuUsu.getSaldo() - jugue.getPrecio());
                                actual.setCantidad(-1);
                                System.out.println("Venta realizada");
                                return true;
                            } else {
                                System.out.println("No tienes la edad necesaria");
                                return false;
                            }
                        }
                    }
                } else if (actual instanceof Tecnologicos) {
                    Tecnologicos tecno = (Tecnologicos) actual;
                    if (tecno.getCantidad() == 0) {
                        System.out.println("No queda stock de ese producto");
                        return false;
                    }
                    tecno.setCantidad(-1);
                    System.out.println("Venta realizada");
                    return true;
                }
            } else if (numeroIndiceDeseado != this.losProductos.indexOf(actual)) {
                System.out.println("No se puede realizar la venta");
            }
        }
        return false;
    }
}
