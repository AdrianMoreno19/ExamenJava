package examenordinariorepasodenuevo;

import java.util.Scanner;

public class ExamenOrdinarioRepasoDeNuevo {

    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);
        SistemaDAWmazon s1 = new SistemaDAWmazon();
        boolean parada = false;
        boolean parada2 = false;
        int numEleccion;
        String eleccionSIoNo;
        while (parada == false) {
            System.out.println("Bienvenido a la aplicacion DAWmazon");
            System.out.println("Debes iniciar sesion!");
            if (s1.usuarioActivo == -1) {
                s1.hacerLogin();
                while (parada2 == false) {
                    if (s1.usuarioActivo != -1) {
                        System.out.println("1 - Mostrar Productos");
                        System.out.println("2 - Buscar Juguete");
                        System.out.println("3 - Buscar Tecnologia");
                        System.out.println("4 - Comprar");
                        System.out.println("Introduce tu eleccion");
                        numEleccion = datos.nextInt();
                        switch (numEleccion) {
                            case 1:
                                s1.mostrarProductos();
                                System.out.println("-------------");
                                System.out.println("Quieres volver al menu de eleccion - S/N");
                                datos.nextLine();
                                eleccionSIoNo = datos.nextLine();
                                if (eleccionSIoNo.equalsIgnoreCase("s")) {
                                    parada2 = false;
                                } else {
                                    System.out.println("Gracias por usar la aplicacion");
                                    parada2 = true;
                                    parada = true;
                                }
                                break;
                            case 2:
                                s1.buscarJuguete();
                                System.out.println("-------------");
                                System.out.println("Quieres volver al menu de eleccion - S/N");
                                eleccionSIoNo = datos.nextLine();
                                if (eleccionSIoNo.equalsIgnoreCase("s")) {
                                    parada2 = false;
                                } else {
                                    System.out.println("Gracias por usar la aplicacion");
                                    parada2 = true;
                                    parada = true;
                                }
                                break;
                            case 3:
                                s1.buscarTecnologia();
                                System.out.println("-------------");
                                System.out.println("Quieres volver al menu de eleccion - S/N");
                                eleccionSIoNo = datos.nextLine();
                                if (eleccionSIoNo.equalsIgnoreCase("s")) {
                                    parada2 = false;
                                } else {
                                    System.out.println("Gracias por usar la aplicacion");
                                    parada2 = true;
                                    parada = true;
                                }
                                break;
                            case 4:
                                s1.comprar();
                                System.out.println("-------------");
                                System.out.println("Quieres volver al menu de eleccion - S/N");
                                eleccionSIoNo = datos.nextLine();
                                if (eleccionSIoNo.equalsIgnoreCase("s")) {
                                    parada2 = false;
                                } else {
                                    System.out.println("Gracias por usar la aplicacion");
                                    parada2 = true;
                                    parada = true;
                                }
                                break;
                            default:
                                System.out.println("Elige otra opcion");
                        }
                    }
                }
            }
        }
    }
}
