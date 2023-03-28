import java.util.ArrayList;
import java.util.Scanner;



public class RottenApp {
    private static Scanner user = new Scanner (System.in);
    public static ArrayList <Pelicula> Peliculas = new ArrayList<>();
    public static ArrayList <Usuarios> Usuarios = new ArrayList<>();
    public static ArrayList<String> PalabrasVetadas = new ArrayList<>();
    static int UserIdLogged = 0; 
    static int idPeliculaSelect  = 0 ;

    public static void main(String[] args) {
        ContenidoInicial();
       // Menus.MenuLogIn(); 
       Peliculas.get(idPeliculaSelect).añadirComentario("Hola");
       Menus.TodosLosComentarios();
    }
    public static void ContenidoInicial() {
        
        
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
        System.out.println("Dame el autor de la película");
        String Autor = PideString();
        System.out.println("Dame la valoración de la película");
        double valoracion = PideDouble();
        Pelicula.genero genero = PideGenero();
        System.out.println("Esccribe una descripción");
        String descrip = PideString();
       if (Comprobacio.comprobarTodoPelicula(duracion, nombre, valoracion)) {
        Peliculas.add(new Pelicula(nombre, duracion, valoracion, genero,Autor, descrip,Peliculas.size()));
       }
       else{
        System.out.println("Has introducido valores incorrectos");
       }
    }
    public static void BuscarPeliculaTitulo() {
        System.out.println("¿Que pelicula quieres buscar?");
        String Titulo= PideString(); 
        for (int i = 0; i < Peliculas.size(); i++) {
            if (Peliculas.get(i).getNombre().indexOf(Titulo)!=-1) {
                System.out.println("ID: " + Peliculas.get(i).getId() + " " + Peliculas.get(i).getNombre());
            }
        }
    }
    public static void BuscarPeliculaAutor() {
        System.out.println("¿Que Autor quieres buscar?");
        String Autor= PideString(); 
        for (int i = 0; i < Peliculas.size(); i++) {
            if (Peliculas.get(i).getAutor().indexOf(Autor)!=-1) {
                System.out.println("ID: " + Peliculas.get(i).getId() + " " + Peliculas.get(i).getNombre());
            }
        }
    }
    public static void BuscarPeliculaValoracion(){
        System.out.println("¿A partir de que valoracion quieres buscar?");
        Double Valor = PideDouble(); 
        for (int i = 0; i < Peliculas.size(); i++) {
            if (Peliculas.get(i).getValoracion()>Valor) {
                System.out.println("ID: " + Peliculas.get(i).getId() + " " + Peliculas.get(i).getNombre());
            }
        }
    }
    public static void BuscarPeliculaGenero() {
        System.out.println("¿Que Genero quieres buscar?");
        Pelicula.genero Genero= PideGenero(); 
        for (int i = 0; i < Peliculas.size(); i++) {
            if (Peliculas.get(i).getAutor().equals(Genero)) {
                System.out.println("ID: " + Peliculas.get(i).getId() + " " + Peliculas.get(i).getNombre());
            }
        }
    }
    public static void AñadirComentario(){
        SeleccionarPelicula();
        System.out.println("Escribe tu comentario");
        String comentario = user.nextLine();
        Peliculas.get(UserIdLogged).Comentarios.add( Usuarios.get(UserIdLogged).getNombre()+ ": "+ comentario);
    }
}
