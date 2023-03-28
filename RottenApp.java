import java.util.ArrayList;
import java.util.Scanner;



public class RottenApp {
    private static Scanner user = new Scanner (System.in);
    public static ArrayList <Pelicula> Peliculas = new ArrayList<>();
    public static ArrayList <Usuarios> Usuarios = new ArrayList<>();
    public static ArrayList<String> PalabrasVetadas = new ArrayList<>();
    static int UserIdLogged; 

    public static void main(String[] args) {
        ContenidoInicial();
        AñadirComentario();
    }
    public static void ContenidoInicial() {
        Usuarios.add(new Usuarios("Pepe","1234",true, 0));
        Usuarios.add(new Usuarios("Ana" , "HolaSoyAna" , false, 1));
        Usuarios.add(new Usuarios("Duncan" , "InLoveWithSofi" , true, 2));
        Usuarios.add(new Usuarios("Marra" , "GafasDeJeff" , false, 3));
        Peliculas.add(new Pelicula("Como entrenar a tu dragon", 98, 5, Pelicula.genero.infantil, ""));
        Peliculas.add(new Pelicula("American History X", 120, 4.1, Pelicula.genero.drama,""));
        Peliculas.add(new Pelicula("Indiana Jones: En busca del arca perdida", 115, 3.5, Pelicula.genero.aventura,""));
        Peliculas.add(new Pelicula("Frozen", 108, 5.1, Pelicula.genero.animacion,""));
        Peliculas.add(new Pelicula("El silencio de los corderos", 120, 4.3, Pelicula.genero.terror,""));
        PalabrasVetadas.add("Malo");
        PalabrasVetadas.add("Bueno");
        PalabrasVetadas.add("Nazi");
        PalabrasVetadas.add("Duncan");
        PalabrasVetadas.add("Sergi");
        
    }
    //Setter y Getter
    public static int getUserIdLogged() {
        return UserIdLogged;
    }
    public static void setUserIdLogged(int userIdLogged) {
        UserIdLogged = userIdLogged;
    }  
    //Scanners
    public static String PideString() {
        String cadena = user.nextLine(); 
        return cadena; 
    }
    public static int PideInt() {
        int x = user.nextInt(); 
        user.nextLine(); 
        return x;
    }
    public static double PideDouble() {
        double x = user.nextDouble(); 
        user.nextLine(); 
        return x;
    }
    //Seleccionar cuenta
    public static int SeleccionaCuenta() {
        Menus.ListarCuentas();
        int seleccion = PideInt(); 
        return seleccion;
    }

    public static int SeleccionarPelicula() {
        Menus.VerPeliculas();
        int seleccion = PideInt();
        return seleccion;
    }

    public static Pelicula.genero PideGenero() {
        Pelicula.genero[] generos = Pelicula.genero.values();
        System.out.println("Selecciona un género:");
        for (int i = 0; i < generos.length; i++) {
            System.out.println((i+1) + ". " + generos[i].toString());
        }
        int seleccion = PideInt();
        if (seleccion < 1 || seleccion > generos.length) {
            System.out.println("Selección inválida");
            return null;
        } else {
            return generos[seleccion - 1];
        }
    }

    //Metodos principales
    public static void CrearPelicula(){
        System.out.println("Dame el nombre de la película");
        String nombre = PideString();
        System.out.println("Dame la duración de la película");
        int duracion = PideInt();
        System.out.println("Dame la valoración de la película");
        double valoracion = PideDouble();
        Pelicula.genero genero = PideGenero();
        System.out.println("Esccribe una descripción");
        String descrip = PideString();
       if (Comprobacio.comprobarTodoPelicula(duracion, nombre, valoracion)) {
        Peliculas.add(new Pelicula(nombre, duracion, valoracion, genero, descrip));
       }
       else{
        System.out.println("Has introducido valores incorrectos");
       }
    }

    public static void AñadirComentario(){
        SeleccionarPelicula();
        System.out.println("Escribe tu comentario");
        String comentario = user.nextLine();
        Pelicula.añadirComentario(comentario);
    }
}
