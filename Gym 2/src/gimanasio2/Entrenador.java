package gimanasio2;
import java.util.ArrayList;
import java.util.List;

public class Entrenador {

    private String id;
    private  String nombre;


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



    public Entrenador(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;

    }

}
