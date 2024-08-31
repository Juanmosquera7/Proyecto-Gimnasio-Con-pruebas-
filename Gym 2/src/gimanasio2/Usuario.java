package gimanasio2;

import java.util.ArrayList;
 import  java.util.List;



public class Usuario {

    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private  String contrasena;
    private List<Entrenamiento> entrenamientos;


    //Constructor
    public Usuario(String cedula, String nombre, String direccion, String telefono, String email, String contrasena){
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contrasena = contrasena;
        this.entrenamientos = new ArrayList<>();

    }

    public List<Entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    public void setEntrenamientos(List<Entrenamiento> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    public String getCedula() {
        return cedula;
    }



    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void registrarEntrenamiento(int duracionEntreno, String fecha, String numsesion, int caloriasQuemadas){
        Entrenamiento entrenamiento = new Entrenamiento(duracionEntreno, fecha, numsesion, caloriasQuemadas);
        entrenamientos.add(entrenamiento);
    }
    public int obtenerCaloriasQuemadas(){
        int totalCalorias = 0;
        for (Entrenamiento entrenamiento : entrenamientos){
            totalCalorias += entrenamiento.getCaloriasQuemadas();

        }
        return totalCalorias;
    }







}
