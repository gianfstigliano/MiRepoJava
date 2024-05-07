package test;

import dominio.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MundoPcStigTest {
    public static void main(String[] args) {
        Scanner scanpc = new Scanner(System.in);
        String respuesta;
        ArrayList<Computadora> listaComputadoras = new ArrayList<>();
        System.out.println("Desea armar una computadora?");
        respuesta = scanpc.nextLine();
        Computadora compu = null;
        while (respuesta.equalsIgnoreCase("Si")) {
            System.out.println("Ingrese el tipo de entrada del Auricular");
            String tipoEA = scanpc.nextLine();
            System.out.println("Ingrese la marca del Auricular");
            String marca = scanpc.nextLine();
            Auriculares auricular = new Auriculares(tipoEA, marca);
            System.out.println("Ingrese el tipo de entrada del Teclado");
            tipoEA = scanpc.nextLine();
            System.out.println("Ingrese la marca del Teclado");
            marca = scanpc.nextLine();
            Teclado teclado = new Teclado(tipoEA, marca);
            System.out.println("Ingrese el tipo de entrada del Mouse");
            tipoEA = scanpc.nextLine();
            System.out.println("Ingrese la marca del Mouse");
            marca = scanpc.nextLine();
            Mouse mouse = new Mouse(tipoEA, marca);
            System.out.println("Ingrese la marca del Monitor");
            marca = scanpc.nextLine();
            System.out.println("Ingrese el tamaño del monitor");
            double tam = Double.parseDouble(scanpc.nextLine());
            Monitor monitor = new Monitor(marca, tam);
            System.out.println("Ingrese el nombre de la PC");
            String nom = scanpc.nextLine();
            compu = new Computadora(nom, monitor, teclado, mouse, auricular);
            System.out.print("¿Quiere cargar otra computadora? ");
            respuesta = scanpc.nextLine();
        }
        Orden orden = new Orden();
        orden.agregarComputadora(compu);
        orden.mostrarOrden();
    }
}
