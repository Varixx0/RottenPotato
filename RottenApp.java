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
<<<<<<< HEAD
        Menus.MenuLogIn(); 
       
=======
        Menus.ImprimeMenu();
       //Peliculas.get(idPeliculaSelect).añadirComentario("Hola");
      // Menus.TodosLosComentarios();
>>>>>>> 9f51b8da104b29cf8b6d4b2e7fbaab10242c25f3
    }
    public static void ContenidoInicial() {
        Usuarios.add(new Usuarios("Pepe","1234",true, 0));
        Usuarios.add(new Usuarios("Ana" , "HolaSoyAna" , false, 1));
        Usuarios.add(new Usuarios("Duncan" , "InLoveWithSofi" , true, 2));
        Usuarios.add(new Usuarios("Marra" , "GafasDeJeff" , false, 3));
        Peliculas.add(new Pelicula("Como entrenar a tu dragon", 98, 5, Pelicula.genero.infantil,"", "",0));
        Peliculas.add(new Pelicula("American History X", 120, 4.1, Pelicula.genero.drama,"","",1));
        Peliculas.add(new Pelicula("Indiana Jones: En busca del arca perdida", 115, 3.5, Pelicula.genero.aventura,"Tarantino","",2));
        Peliculas.add(new Pelicula("Frozen", 108, 5.1, Pelicula.genero.animacion,"Duncan","",3));
        Peliculas.add(new Pelicula("El silencio de los corderos", 120, 4.3, Pelicula.genero.terror,"Rua","",4));
        Peliculas.add(new Pelicula("ilencio de los corderos", 120, 4.3, Pelicula.genero.terror,"Sergio","",5));
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
        SeleccionaPeliculaPorId();
    }
    public static void BuscarPeliculaAutor() {
        System.out.println("¿Que Autor quieres buscar?");
        String Autor= PideString(); 
        for (int i = 0; i < Peliculas.size(); i++) {
            if (Peliculas.get(i).getAutor().indexOf(Autor)!=-1) {
                System.out.println("ID: " + Peliculas.get(i).getId() + " " + Peliculas.get(i).getNombre());
            }
        }
        SeleccionaPeliculaPorId();
    }
    public static void BuscarPeliculaValoracion(){
        System.out.println("¿A partir de que valoracion quieres buscar?");
        Double Valor = PideDouble(); 
        for (int i = 0; i < Peliculas.size(); i++) {
            if (Peliculas.get(i).getValoracion()>Valor) {
                System.out.println("ID: " + Peliculas.get(i).getId() + " " + Peliculas.get(i).getNombre());
            }
        }
        SeleccionaPeliculaPorId();
    }
    public static void BuscarPeliculaGenero() {
        System.out.println("¿Que Genero quieres buscar?");
        Pelicula.genero Genero= PideGenero(); 
        for (int i = 0; i < Peliculas.size(); i++) {
            if (Peliculas.get(i).getAutor().equals(Genero)) {
                System.out.println("ID: " + Peliculas.get(i).getId() + " " + Peliculas.get(i).getNombre());
            }
        }
        SeleccionaPeliculaPorId();
    }
    public static void SeleccionaPeliculaPorId() {
        System.out.println("Elige el id la pelicula que deseas seleccionar: ");
        int id = PideInt(); 
        idPeliculaSelect = id; 
        Menus.ImprimeFichaPelicula();
    }
    public static void AñadirComentario(){
        SeleccionarPelicula();
        System.out.println("Escribe tu comentario");
        String comentario = user.nextLine();
        Peliculas.get(UserIdLogged).Comentarios.add( Usuarios.get(UserIdLogged).getNombre()+ ": "+ comentario);
    }
}
