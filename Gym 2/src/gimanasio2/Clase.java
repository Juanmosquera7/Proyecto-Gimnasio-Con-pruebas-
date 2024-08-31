package gimanasio2;
import java.util.ArrayList;
import java.util.List;

public class Clase {
    //Atributos de la clase
    private String id;
    private String nombre;
    private String horario;
    private int capacidad;
    private String fechaIncio;
    private String fechaFin;
    private String estado;

    private String tipo;
    private List<Usuario> inscritos;
    private Entrenador entrenador;

    //Constructor

    public Clase(String id, String nombre, String horario, int capacidad, String fechaIncio, String fechaFin, String estado,  String tipo, Entrenador entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
        this.fechaIncio = fechaIncio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.inscritos = new ArrayList<>();
        this.tipo = tipo;
        this.entrenador = entrenador;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getFechaIncio() {
        return fechaIncio;
    }

    public void setFechaIncio(String fechaIncio) {
        this.fechaIncio = fechaIncio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        //this.entrenador =entrenador;
    }

    public List<Usuario> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<Usuario> inscritos) {
        this.inscritos = inscritos;
    }
}
