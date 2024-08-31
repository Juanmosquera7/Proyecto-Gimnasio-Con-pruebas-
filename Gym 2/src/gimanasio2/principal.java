package gimanasio2;

import java.util.ArrayList;
import java.util.List;

public class principal{
    private  ArrayList<Usuario> usuariosRegistrados;
    private List<Clase> clasesAsignadas;
    private  List<Entrenador> entrenadores;

    public principal(){
        this.usuariosRegistrados = new ArrayList<>();
        this.clasesAsignadas = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
    }

    public ArrayList<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public void setUsuariosRegistrados(ArrayList<Usuario> usuariosRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;
    }

    public List<Clase> getClasesAsignadas() {
        return clasesAsignadas;
    }

    public void setClasesAsignadas(List<Clase> clasesAsignadas) {
        this.clasesAsignadas = clasesAsignadas;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public  void registrar(String cedula, String nombre, String direccion, String telefono, String email, String contrasena) throws Exception{
        if(cedula == null || cedula.isEmpty()){
            throw new Exception("La cédula no puede estar vacía");
        }
        if(nombre == null || nombre.isEmpty())  {
            throw new Exception("El nombre no puede estar vacío");

        }
        if(direccion== null || direccion.isEmpty()){
            throw new Exception("La dirección no puede estar vacía");

        }
        if(telefono == null || telefono.isEmpty()){
            throw new Exception("El telefono no puede estar vacío");
        }
        if(email == null || email.isEmpty()){
            throw new Exception("El email no puede estar vació");

        }
        if (contrasena == null || contrasena.isEmpty()){
            throw new Exception("La contraseña no puede estar vacía");
        }

        //Validar que la cédula no este registrada
        for(Usuario usuario : usuariosRegistrados){
            if(usuario.getCedula().equals(cedula)){
                throw new Exception("Ya existe un usuario con esa cedula");
            }
        }
        Usuario usuario = new Usuario(cedula, nombre, direccion, telefono, email, contrasena);
        usuariosRegistrados.add(usuario);
        System.out.println("Usuario registrado con exito");


    }

    public void imprimirUsuarios() {

        for(Usuario usuario : usuariosRegistrados){
            System.out.println("Cédula (Número de identificación): " + usuario.getCedula()+" -Nombre: "+usuario.getNombre() +" -Dirección: "+ usuario.getDireccion() +"  -Correo: " + usuario.getEmail());
        }

    }
    public void actualizarDaotos(String cedula,String nuevoNombre, String nuevaDireccion, String nuevoTelefono, String nuevoEmail, String nuevaContrasena)throws Exception {
        //Buscar el usuario con la cédula proporcionada
        Usuario usuario = buscarUsuario(cedula);

        //Actualizar los datos del Usuario
        usuario.setNombre(nuevoNombre);
        usuario.setDireccion(nuevaDireccion);
        usuario.setTelefono(nuevoTelefono);
        usuario.setEmail(nuevoEmail);
        usuario.setContrasena(nuevaContrasena);

        System.out.println("Datos del usuario con cédula " + cedula + " Actualizados exitosamente.");
    }
    public Usuario buscarUsuario(String cedula) throws Exception {
        //Recorrer la lista de usuarios registrados
        for (int i = 0; i < usuariosRegistrados.size(); i++){
            Usuario u = usuariosRegistrados.get(i);
            if(u.getCedula().equals(cedula)){
                return u;
            }
        }
        throw new Exception("La cédula " + cedula + " NO existe");
    }
    public void eliminarUsuario(String cedula) throws  Exception{
        //Buscar el usuario con la cédula
        Usuario usuario = buscarUsuario(cedula);
        //Eliminar el usuario
        usuariosRegistrados.remove(usuario);

    }

    //Métodos para gestionar entrenadores

    public void registrarEntrenador(String id, String nombre) throws Exception{
        if(buscarEntrenador(id) != null){
            throw new Exception("El entrenador con ID " + id + " ya está registrado.");

        }
        Entrenador nuevoEntrenador = new Entrenador(id, nombre);
        entrenadores.add(nuevoEntrenador);
        System.out.println("Entrenador registrado exitosamente");

    }
    public Entrenador buscarEntrenador(String id){
        for(Entrenador entrenador : entrenadores){
            if (entrenador.getId().equals(id)){
                return entrenador;
            }
        }
        return null;
    }
    public void eliminarEntrenador(String id) throws Exception{
        Entrenador entrenador = buscarEntrenador(id);
        if(entrenador == null){
            throw new Exception("El entrenador con ID" + id + " no existe");

        }
        entrenadores.remove(entrenador);
        System.out.println("Entrenador eliminado exitosamente");
    }
    public void imprimirEntrenadores(){
        for (Entrenador entrenador : entrenadores){
            System.out.println("-Id: "+entrenador.getId() + " -Nombre Entrenador: " + entrenador.getNombre());

        }
    }

    // Métodos para gestionar Clases

    public void agregarClase(String id, String nombre, String horario, int capacidad, String fechaInicio, String fechaFin, String estado, String tipo, String entrenadorId) throws Exception {
        if (buscarClase(id) != null) {
            throw new Exception("La clase con ID " + id + " Ya está registrada.");
        }

        Entrenador entrenador = buscarEntrenador(entrenadorId);
        if (entrenador == null) {
            throw new Exception("No se encontró con el ID " + entrenadorId);
        }

        Clase nuevaClase = new Clase(id, nombre, horario, capacidad, fechaInicio, fechaFin, estado, tipo, entrenador);
        clasesAsignadas.add(nuevaClase);
        System.out.println("Clase agregada exitosamente.");
    }
    public Clase buscarClase (String id) {
        for(Clase clase : clasesAsignadas){
            if(clase.getId().equals(id)){
                return clase;

            }
        }
        return null;
    }
    public void imprimirClases(){
        for(Clase clase : clasesAsignadas){
            System.out.println("-Id de la clase: " + (clase.getId() + " -Nombre " + clase.getNombre() + " -Horario: " +clase.getHorario() + " -Entrenador:  " + clase.getEntrenador().getNombre()));
        }
    }
    public void eliminarClase(String id) throws Exception{

        Clase clase = buscarClase(id);
        if(clase==null){
            throw new Exception("La clase con ID " + id + " No existe.");
        }
        clasesAsignadas.remove(clase);

        System.out.println("Clase con ID " + id + " Eliminada exitosamente ");
    }
    public void reservarClase(String cedula, String idClase) throws Exception {
        Usuario usuario = buscarUsuario(cedula);
        if (usuario == null) {
            throw new Exception("Usuario con cédula " + cedula + " No encontrado");
        }
        Clase clase = buscarClase(idClase);
        if (clase == null) {
            throw new Exception("Clase con ID " + idClase + " No encontrada."); // Corregido
        }
        // Se agrega el usuario a la lista de inscritos de la clase
        clase.getInscritos().add(usuario);
        System.out.println("Clase de: <" + clase.getNombre() + "> Reservada exitosamente para <" + usuario.getNombre() + "> con cédula " + cedula + ".");
    }

    //Método para consultar el historial de entrenamiento de un Usuario con la cédula

    public void consultarHistorialEntrenamiento(String cedula) throws Exception{
        Usuario usuario = buscarUsuario(cedula);
        if(usuario == null){
            throw new Exception("Usuario con cédula " + cedula + " No encontrado.");

        }
        List<Clase> historial = obtenerHistorialClases(cedula);
        if(historial.isEmpty()){
            System.out.println("El usuario con cédula " + cedula + " no tiene clases reservadas.");
            return;
        }
        System.out.println("Historial de entrenamiento para el usuario con cédula " + cedula + ":");
        for (Clase clase : historial){
            System.out.println("- Clase: " + clase.getNombre() + " - Horario: " + clase.getHorario() + " - Entrenador: " + clase.getEntrenador().getNombre());
        }
    }

    public List<Clase> obtenerHistorialClases(String cedulaCliente){

        List<Clase> respuesta = new ArrayList<>();

        for(Clase clase: clasesAsignadas){

            for(Usuario usuario: clase.getInscritos()){

                if( usuario.getCedula().equals(cedulaCliente) ){
                    respuesta.add(clase);
                }

            }

        }
        return respuesta;
    }


    public void cancelarReservaClase(String cedula, String idClase) throws Exception{

        Usuario usuario = buscarUsuario(cedula);
        if(usuario == null){
            throw  new Exception("Usuario con cédula " + cedula + "No encontrada. ");
        }

        boolean claseEliminada = false;
        Clase clase = buscarClase(idClase);

        for (int i = 0; i < clase.getInscritos().size() && !claseEliminada; i++){
            if (clase.getInscritos().get(i).getCedula().equals(cedula)){
                clase.getInscritos().remove(i);
                claseEliminada = true;
            }

        }
        if (!claseEliminada){
            throw new Exception("La clase con ID " + idClase + " no está reservada por el usuario con cédula " + cedula + ".");

        }
        System.out.println("Reserva de la clase con ID "+ idClase + " cancelada exitosamente para el usuario con cédula " + cedula + ".");
    }

    public void reporteClaseMasPopular(){

        Clase claseMasPopular = null;
        int maxReservas = 0;

        for (Clase clase : clasesAsignadas){

            if (clase.getInscritos().size() > maxReservas){
                maxReservas = clase.getInscritos().size();
                claseMasPopular = clase;
            }
        }
        if(claseMasPopular != null){
            System.out.println("La clase más popular es: " + claseMasPopular.getNombre() + " con " + maxReservas + " Reservas. ");
        }
    }
    public void  topUsuariosActivos() throws Exception{
        if (usuariosRegistrados.isEmpty()){
            throw new Exception("No hay usuarios registrados.");
        }
        List<Usuario> topUsuarios = new ArrayList<>(usuariosRegistrados);

        for (int i = 0; i < topUsuarios.size(); i++){
            for (int j = i +1; j < topUsuarios.size(); j++){
                if(topUsuarios.get(j).obtenerCaloriasQuemadas() > topUsuarios.get(i).obtenerCaloriasQuemadas()) {
                    Usuario temp = topUsuarios.get(i);
                    topUsuarios.set(i, topUsuarios.get(j));
                    topUsuarios.set(j, temp);
                }
            }
        }
        System.out.println("Top 3 Usuarios más activos (Con más calorías quemadas):");

        for (int i = 0; i < Math.min(3, topUsuarios.size()); i++){
            Usuario usuario = topUsuarios.get(i);
            System.out.println((i + 1) + ". - Cédula " + usuario.getCedula() + " - Nombre: " + usuario.getNombre() + " - Calorías Quemadas: " + usuario.obtenerCaloriasQuemadas());
        }
    }





}
