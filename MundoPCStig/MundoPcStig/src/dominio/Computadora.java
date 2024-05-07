package dominio;

public class Computadora {
    private int idComputadora;
    private String nombre;
    private Monitor monitor;
    private Mouse mouse;
    private Teclado teclado;
    private Auriculares auriculares;
    private static int contadorComputadoras;

    private Computadora(){
        this.idComputadora = ++Computadora.contadorComputadoras;
    }

    public Computadora(String nombre, Monitor monitor, Teclado teclado, Mouse mouse, Auriculares auriculares){
        this();
        this.nombre = nombre;
        this.monitor = monitor;
        this.teclado = teclado;
        this.mouse = mouse;
        this.auriculares = auriculares;
    }

    public int getIdComputadora() {
        return this.idComputadora;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Monitor getMonitor() {
        return this.monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Mouse getMouse() {
        return this.mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Teclado getTeclado() {
        return this.teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    public Auriculares getAuriculares() {
        return this.auriculares;
    }

    public void setAuriculares(Auriculares auriculares) {
        this.auriculares = auriculares;
    }

    @Override
    public String toString() {
        return "Computadora{" +
                "idComputadora=" + idComputadora +
                ", nombre='" + nombre + '\'' +
                ", monitor=" + monitor +
                ", mouse=" + mouse +
                ", teclado=" + teclado +
                ", auriculares=" + auriculares +
                '}';
    }
}
