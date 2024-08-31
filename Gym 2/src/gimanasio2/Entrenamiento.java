package gimanasio2;

public class Entrenamiento {
    private int duracionEntreno;
    private String fecha;
    private String numsesion;
    private int caloriasQuemadas;

    public int getDuracionEntreno() {
        return duracionEntreno;
    }

    public void setDuracionEntreno(int duracionEntreno) {
        this.duracionEntreno = duracionEntreno;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumsesion() {
        return numsesion;
    }

    public void setNumsesion(String numsesion) {
        this.numsesion = numsesion;
    }

    public int getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public void setCaloriasQuemadas(int caloriasQuemadas) {
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public Entrenamiento(int duracionEntreno, String fecha, String numsesion, int caloriasQuemadas) {
        this.duracionEntreno = duracionEntreno;
        this.fecha = fecha;
        this.numsesion = numsesion;
        this.caloriasQuemadas = caloriasQuemadas;
    }
}
