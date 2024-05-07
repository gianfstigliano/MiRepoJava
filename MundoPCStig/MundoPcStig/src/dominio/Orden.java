package dominio;

import java.util.Arrays;

public class Orden {
    private int idOrden;
    private Computadora computadoras[];
    private static int contadorOrdenes;
    private static int contadorComputadoras;
    private static int MAX_COMPUTADORAS = 10;

    public Orden(){
        this.idOrden = ++Orden.contadorOrdenes;
        this.computadoras = new Computadora[MAX_COMPUTADORAS];
    }

    public void agregarComputadora(Computadora computadora){
        if (this.contadorComputadoras < MAX_COMPUTADORAS){
            computadoras[contadorComputadoras++] = computadora;
        }
        else {
            System.out.println("Se ha superado el numero de computadoras");
        }
    }

    public void mostrarOrden(){
        System.out.println("Orden # = " + this.idOrden);
        System.out.println("Computadoras de la orden #: " + this.idOrden);
        for (int i = 0; i < this.contadorComputadoras; i++) {
            System.out.println(this.computadoras[i]);
        }
    }
}
