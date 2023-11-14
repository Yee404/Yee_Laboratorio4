import java.util.*;
import java.io.*;

public class InterfazPremium {
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static String vuelosDoc = "vuelos.csv";
    static String usuariosDoc = "usuarios.csv";

    public static void main(String[] args) {
        boolean go = true;

        while (go) {
            printMenu();

            System.out.println("\nIngrese la opción elegida: ");
            int opcion = Integer.parseInt(scan.nextLine());
            System.out.println("");

            switch (opcion) {
                case 1:
                    Registro();
                    break;

                case 2:
                    System.out.println("opcion 2");
                    break;

                case 3:
                    System.out.println("opcion3");
                    break;

                case 4:
                    System.out.println("opcion4");
                    break;
                case 5:
                    Perfil();
                    break;

                case 6:
                    System.out.println("salir");
                    go = false;
                    break;
            }

        }
    }

    // Opcion1 [Modo Registro]
    private static void Registro() {
        System.out.println("a. Crear Usuario");
        System.out.println("b. Seleccionar plan");
        String opcion1 = scan.nextLine();

        switch (opcion1) {
            case "a":
                System.out.println("\nCREAR USUARIO");
                crearUsuario();
                break;

            case "b":
                System.out.println("\nELEGIR PLAN");
                elegirPlan();
                break;
        }
    }

    // MÉTODOS OPCIÓN1
    public static void crearUsuario() {
        System.out.println("Nombre del usuario: ");
        String usuario = scan.nextLine();

        System.out.println("Ingrese su contraseña: ");
        String contrasenna = scan.nextLine();

        System.out.println("Ingrese un código numérico de seguridad: ");
        int codigo = Integer.parseInt(scan.nextLine());

        String claseVuelo = "gratis";

        Usuario nuevoUsuario = new Usuario(usuario, contrasenna, codigo, claseVuelo);
        usuarios.add(nuevoUsuario);

        try (BufferedWriter Fwriter = new BufferedWriter(new FileWriter(usuariosDoc, true))) {
            Fwriter.write(nuevoUsuario.getUsuario() + "," + nuevoUsuario.getContrasenna() + ","
                    + nuevoUsuario.getCodigo() + "," + nuevoUsuario.getClaseVuelo());
            Fwriter.newLine();
        } catch (IOException e) {
            System.err.println("\u001B[31mError. No se guardaron los datos: " + e.getMessage());
            System.out.println("\u001B[37m");
        }
    }

    public static void elegirPlan() {

        System.out.println("Ingrese el nombre de su usuario: ");
        String usuario = scan.nextLine();

        for (Usuario usu : usuarios) {
            if (usu.getUsuario().equals(usuario)) {
                usu.setClaseVuelo("vip");
                System.err.println("\n\u001B[32mEl plan de \u001B[32m" + usuario + " \u001B[32mha sido cambiado a \u001B[33mVIP");
                System.out.println("\u001B[37m");
                return;
            }
        }
    }

    // MÉTODOS OPCION2
    // (lo pondría en varias clases y dejarlo pero el grupo decidió que el main
    // fuera largo :v)

    //MÉTODOS OPCION5 
    public static void Perfil() {

        System.out.println("Ingrese el nombre de su usuario: ");
        String usuario = scan.nextLine();

        System.out.println("Ingrese la nueva contraseña: ");
        String contrasenna = scan.nextLine();

        for (Usuario usu : usuarios) {
            if (usu.getUsuario().equals(usuario)) {
                usu.setContrasenna(contrasenna);
                return;
            }
        }

        System.err.println("\n\u001B[32mLa contraseña de \u001B[32m" + usuario + " \u001B[32mha sido cambiada");
    }
    
    public static void printMenu(){
        System.out.println("\nREGISTRO Y CONSULTA DE VUELOS");
        System.out.println("1. Modo Registro");
        System.out.println("2. Ingresar/ Salir");
        System.out.println("3. Modo Reservas");
        System.out.println("4. Modo Confirmacion");
        System.out.println("5. Modo Perfil");
        System.out.println("6. Salir");
    }
}
