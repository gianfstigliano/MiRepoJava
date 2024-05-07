package dominio;

public class Mouse extends Perifericos{
    private final int idRaton;
    private static int contadorRatones;

    public Mouse(String tipoEntrada, String marca){
        super(tipoEntrada,marca);
        this.idRaton = ++Mouse.contadorRatones;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "idRaton=" + idRaton +
                super.toString() +
                '}';
    }
}
