package dominio;

public class Auriculares extends Perifericos {
    private final int idAuricular;
    private static int contadorAuriculares;

    public Auriculares(String tipoEntrada, String marca){
        super(tipoEntrada,marca);
        this.idAuricular = ++Auriculares.contadorAuriculares;
    }

    @Override
    public String toString() {
        return "Auriculares{" +
                "idAuricular=" + idAuricular +
                super.toString() +
                '}';
    }
}
