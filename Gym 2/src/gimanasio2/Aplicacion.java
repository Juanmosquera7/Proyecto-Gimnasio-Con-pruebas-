package gimanasio2;

public class Aplicacion {

        public static void main(String[] args)throws Exception {

            principal principal = new principal();






            //REGISTRO DE USUARIOS
            principal.registrar( "7", "Cristiano Ronaldo", "Riad, Arabia Saudita", "77777", "cr7@gmail", "9777");
            principal.registrar("10", "Vini Jr", "Fabelas do Brasil ", "10101010", "vinijr@gmail", "888");
            principal.registrar("5", "Jude Bellingham", "Birmingham", "3114767899", "jude@gmail", "8777");
            principal.registrar("9", "Kylian Mbappé", "París, Francia", "9999", "mbappe@gmail.com", "9999");

            System.out.println();

            //IMPRIMIR USUARIO REGISTRADO
            principal.imprimirUsuarios();

            System.out.println();

            //ACTUALIZACIÓN DE DATOS
            //principal.actualizarDaotos("5", "Juanes", "Armenia, Quindio", " 7325465", "juanes@gmail.com", "11111");

            //System.out.println();

            //principal.imprimirUsuarios();

            //ELIMINAR USUARIOS
            //principal.eliminarUsuario("5");

            //System.out.println();

            //principal.imprimirUsuarios();

            System.out.println();
            //Registrar Entrenadores

            principal.registrarEntrenador("E455", "LA ROCA");
            principal.registrarEntrenador("F77", "C-BUM");
            principal.registrarEntrenador("E555", "Nairo Quintana");

            System.out.println();
            //Registrar Clase

            principal.agregarClase("C001", "Yoga", "06:30", 30, "25/08/2024", "1/09/2024", "Disponible", "Deportes", "E455");
            principal.agregarClase("C002", "Crossfit", "10:30", 20, "25/08/2024", "1/09/2024", "Disponible", "Deportes", "F77");
            principal.agregarClase("C003", "Bici", "13:30", 20, "25/08/2024", "1/09/2024", "Disponible", "Deportes", "E555");


            System.out.println();

            principal.imprimirEntrenadores();


            System.out.println();

            principal.imprimirClases();

            System.out.println();

            //Eliminar una  clase:
            //principal.eliminarClase("C002");

            //System.out.println();

            //principal.imprimirClases();

            System.out.println();

           principal.reservarClase("7", "C001");
           principal.reservarClase("10", "C001");
           principal.reservarClase("10", "C003");
           principal.reservarClase("10", "C002");
           principal.reservarClase("7", "C003");
           principal.reservarClase("5", "C003");
           principal.reservarClase("9", "C003");
           principal.reservarClase("9", "C002");
           principal.reservarClase("9", "C001");

           System.out.println();


            //principal.cancelarReservaClase("7", "C001");

            //Consultar Historial de entrenamiento
            principal.consultarHistorialEntrenamiento("7");

            System.out.println();

            principal.consultarHistorialEntrenamiento("10");

            System.out.println();

            principal.consultarHistorialEntrenamiento("5");

            System.out.println();

            principal.consultarHistorialEntrenamiento("9");

            System.out.println();

            //REPORTE DE LA CLASE MÁS POPULAR
            principal.reporteClaseMasPopular();

            System.out.println();

            //Registar Clase
            Usuario cr7 = principal.buscarUsuario("7");
            cr7.registrarEntrenamiento(60, "26/08/2024", "1", 500);
            cr7.registrarEntrenamiento(45, "25/08/2024", "2", 3000);

            Usuario vini = principal.buscarUsuario("10");
            vini.registrarEntrenamiento(60, "26/08/2024", "1", 100);
            vini.registrarEntrenamiento(60, "24/08/2024", "2", 3000);

            Usuario jude = principal.buscarUsuario("5");
            jude.registrarEntrenamiento(60, "7/08/2024", "1", 2000);

            Usuario mbappe = principal.buscarUsuario("9");

            mbappe.registrarEntrenamiento(60, "26/08/2024", "1", 100);
            mbappe.registrarEntrenamiento(60, "24/08/2024", "1", 5000);



            //TOP 3 USUARIOS ACTIVOS
            principal.topUsuariosActivos();
        }


}
