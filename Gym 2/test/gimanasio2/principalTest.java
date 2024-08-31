package gimanasio2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class principalTest {

    @org.junit.jupiter.api.Test
   void registrar() {
        principal principal = new principal();

        assertDoesNotThrow(() -> {
            principal.registrar(
                    "7",
                    "Cristiano",
                    "Madrid",
                    "311",
                    "cr7@gmail.com",
                    "123"


            );
        });

        //Verificar que el usuario fue agregado correctamente a la lista de usuarios registrados
        assertEquals(1, principal.getUsuariosRegistrados().size());
        assertEquals("Cristiano", principal.getUsuariosRegistrados().get(0).getNombre());

    }


    @Test
    void testBuscarUsuario() {
        //Crear una instancia de la clase principal
        principal principal = new principal();

        //Registro de algunos usuarios para la prueba
        assertDoesNotThrow(()->{
            principal.registrar("5", "Jude", "Ingaleterra", "555", "jude@gmail.com", "557");
            principal.registrar("7", "Vini jr", "Brasil", "777", "vinijr@gmail.com", "10107");
        });
        //Verificar Que BuscarUsuario encuentra un usuario existente
        assertDoesNotThrow(() -> {
            Usuario usuarioEncontrado = principal.buscarUsuario("5");
            assertNotNull(usuarioEncontrado);
            assertEquals("Jude", usuarioEncontrado.getNombre());
        });
        //Verificar que buscarUsuario lanza una excepción al buscar un usuario no registrado
        Exception exception = assertThrows(Exception.class, () ->{
            principal.buscarUsuario("11111111111");

        });
        assertEquals("La cédula 11111111111 NO existe", exception.getMessage());

    }
    @Test
    void testAgregarClase() {
        // Crear una instancia de la clase Principal
        principal principal  = new principal();

        // Registro de un entrenador
        assertDoesNotThrow(() -> {
            principal.registrarEntrenador("E1", "Carlo Ancelotti");
        });

        // Verificar que la clase se puede agregar correctamente
        assertDoesNotThrow(() -> {
            principal.agregarClase("C1", "Tactica", "08:00 AM", 20, "2024/09/01", "2024/12/31", "Activa", "Estrategia", "E1");
            Clase claseAgregada = principal.buscarClase("C1");
            assertNotNull(claseAgregada);
            assertEquals("Tactica", claseAgregada.getNombre());
        });

        // Verificar que agregarClase lanza una excepción si la clase ya está registrada
        Exception exceptionClaseExistente = assertThrows(Exception.class, () -> {
            principal.agregarClase("C1", "Pilates", "09:00 AM", 15, "2024-09-01", "2024-12-31", "Activa", "Flexibilidad", "E1");
        });
        assertEquals("La clase con ID C1 Ya está registrada.", exceptionClaseExistente.getMessage());

        // Verificar que agregarClase lanza una excepción si el entrenador no se encuentra
        Exception exceptionEntrenadorNoEncontrado = assertThrows(Exception.class, () -> {
            principal.agregarClase("C2", "Yoga", "10:00 AM", 10, "2024-09-01", "2024-12-31", "Activa", "Relajación", "E2");
        });
        assertEquals("No se encontró con el ID E2", exceptionEntrenadorNoEncontrado.getMessage());
    }
    @Test
    void testReservarClase() throws Exception {
        principal principal = new principal();

        // Registro un Usuario y Una Clase
        assertDoesNotThrow(() -> {
            principal.registrar("9", "Kylian Mbappé", "París, Francia", "9999", "mbappe@gmail.com", "9999");
            principal.registrarEntrenador("E1", "Carlo Ancelotti");
            principal.agregarClase("C1", "Tactica", "08:00 AM", 20, "2024/09/01", "2024/12/31", "Activa", "Estrategia", "E1");
        });

        // Verificar que la clase se puede reservar correctamente para un usuario existente
        assertDoesNotThrow(() -> {
            principal.reservarClase("9", "C1");
            Clase claseReservada = principal.buscarClase("C1");

            Usuario usuarioReservado = claseReservada.getInscritos().stream()
                    .filter(u -> u.getCedula().equals("9"))
                    .findFirst()
                    .orElse(null);
            assertNotNull(usuarioReservado);
            assertEquals("Kylian Mbappé", usuarioReservado.getNombre());
        });

        // Verificar que reservarClase lanza una excepción si el usuario no se encuentra
        Exception exceptionUsuarioNoEncontrado = assertThrows(Exception.class, () -> {
            principal.reservarClase("999", "C1");
        });
        assertEquals("La cédula 999 NO existe", exceptionUsuarioNoEncontrado.getMessage());

        // Verificar que reservarClase lanza una excepción si la clase no se encuentra
        Exception exceptionClaseNoEncontrada = assertThrows(Exception.class, () -> {
            principal.reservarClase("9", "C999");
        });
        assertEquals("Clase con ID C" + 999 + " No encontrada.", exceptionClaseNoEncontrada.getMessage());
    }
    @Test
    void testRegistrarEntrenador(){

        principal principal = new principal();

        //Verificar que el entrenador se puede registrar correctamente

        assertDoesNotThrow(() -> {
            principal.registrarEntrenador("E1", "Carlo Ancelotti");
            Entrenador entrenadorRegistrado = principal.buscarEntrenador("E1");
            assertNotNull(entrenadorRegistrado);
            assertEquals("Carlo Ancelotti", entrenadorRegistrado.getNombre());
        });
        //Verificar que registarEntrnador lanza una excepción si el entrenador ya está registrado
        Exception exceptionEntrenadorExistente = assertThrows(Exception.class, () -> {
            principal.registrarEntrenador("E1", "Carlo Ancelotti");
        });
        assertEquals("El entrenador con ID E1 ya está registrado.", exceptionEntrenadorExistente.getMessage());

        }
        @Test
        void testBuscarEntrenador(){
            principal principal = new principal();

            assertDoesNotThrow(() -> {
                principal.registrarEntrenador("E1", "Pep Guardiola");
                principal.registrarEntrenador("E2", "Jurgen Klopp");
            });
            //Verificar que buscarEntrenador encuentra un entrenador existente
            Entrenador entrenadorEncontrado = principal.buscarEntrenador("E1");
            assertNotNull(entrenadorEncontrado);
            assertEquals("Pep Guardiola", entrenadorEncontrado.getNombre());

            Entrenador entrenadorNoEncontrado = principal.buscarEntrenador("E3");
            assertNull(entrenadorNoEncontrado);
        }
        @Test
        void testConsultarHistorialEntrenamiento() {
            //Crear una instancia de la clase principal

            principal principal = new principal();

            assertDoesNotThrow(() -> {
                // Primero, registra al entrenador
                principal.registrarEntrenador("E1", "Carlo Ancelotti");

                // Luego, registra al usuario
                principal.registrar("9", "Kylian Mbappé", "París, Francia", "9999", "mbappe@gmail.com", "9999");

                // Agregar la clase, ahora que el entrenador ya está registrado
                principal.agregarClase("C1", "Tactica", "08:00 AM", 20, "2024/09/01", "2024/12/31", "Activa", "Estrategia", "E1");
            });

            //Caso 1: Usuario no encontrado (debe lanzar una excepción)

            Exception exception = assertThrows(Exception.class, () -> {
                principal.consultarHistorialEntrenamiento("456");//Usuario No registrado
            });
            assertEquals("La cédula 456 NO existe", exception.getMessage());

            //Caso 2: Usuario sin historial de clases (sin reservas)
            //No debe lanzar Excepciones
            assertDoesNotThrow(() -> {
                principal.consultarHistorialEntrenamiento("9");
            });

            //Caso 3: Usuario con historial de clases
            //Reservar una clase para el usuario
            assertDoesNotThrow(() -> {
                principal.reservarClase("9", "C1");
            });
            assertDoesNotThrow(() -> {
                principal.consultarHistorialEntrenamiento("9");
            });



        }
    @Test
    void testObtenerHistorialClases() {
        principal principal = new principal();

        // Registrar usuarios, entrenadores, clases y reservas
        assertDoesNotThrow(() -> {
            principal.registrar("9", "Kylian Mbappé", "París, Francia", "9999", "mbappe@gmail.com", "9999");
            principal.registrarEntrenador("E1", "Carlo Ancelotti");
            principal.agregarClase("C1", "Tactica", "08:00 AM", 20, "2024/09/01", "2024/12/31", "Activa", "Estrategia", "E1");
            principal.reservarClase("9", "C1");
        });

        // Verificar que el historial de clases para el usuario no esté vacío
        List<Clase> historial = principal.obtenerHistorialClases("9");
        assertFalse(historial.isEmpty(), "El historial de clases no debe estar vacío.");

        // Verificar que la clase reservada sea la correcta
        assertEquals(1, historial.size(), "El historial de clases debe contener exactamente 1 clase.");
        assertEquals("C1", historial.get(0).getId(), "La clase en el historial debe tener el ID 'C1'.");

        // Caso: Usuario sin clases reservadas
        List<Clase> historialVacio = principal.obtenerHistorialClases("10"); // Usuario con cédula "10" no ha reservado una clase
        assertTrue(historialVacio.isEmpty(), "El historial de clases debe estar vacío para un usuario sin reservas.");
    }










}