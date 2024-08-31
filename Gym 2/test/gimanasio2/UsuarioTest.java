package gimanasio2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testRegistrarEntrenamiento() {
        // Crear una instancia de la clase Usuario
        Usuario usuario = new Usuario("123", "Juan Pérez", "Calle Falsa 123", "555-1234", "juan.perez@example.com", "password");

        // Registrar un entrenamiento
        assertDoesNotThrow(() -> {
            usuario.registrarEntrenamiento(60, "2024-08-30", "S1", 500);
        });

        // Verificar que el entrenamiento se haya registrado correctamente
        assertEquals(1, usuario.getEntrenamientos().size());
        Entrenamiento entrenamiento = usuario.getEntrenamientos().get(0);
        assertEquals(60, entrenamiento.getDuracionEntreno());
        assertEquals("2024-08-30", entrenamiento.getFecha());
        assertEquals("S1", entrenamiento.getNumsesion());
        assertEquals(500, entrenamiento.getCaloriasQuemadas());
    }

    @Test
    void testObtenerCaloriasQuemadas() {
        // Crear una instancia de la clase Usuario
        Usuario usuario = new Usuario("123", "Juan Pérez", "Calle Falsa 123", "555-1234", "juan.perez@example.com", "password");

        // Registrar algunos entrenamientos
        usuario.registrarEntrenamiento(60, "2024-08-30", "S1", 500);
        usuario.registrarEntrenamiento(45, "2024-08-31", "S2", 300);

        // Verificar que el total de calorías quemadas se calcula correctamente
        assertEquals(800, usuario.obtenerCaloriasQuemadas());

        // Caso: Usuario sin entrenamientos registrados
        Usuario usuarioSinEntrenamientos = new Usuario("456", "Ana Gómez", "Avenida Siempre Viva 456", "555-5678", "ana.gomez@example.com", "password");
        assertEquals(0, usuarioSinEntrenamientos.obtenerCaloriasQuemadas());
    }
}
