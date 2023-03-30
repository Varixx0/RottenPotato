import java.util.ArrayList;
import java.util.Scanner;



public class RottenApp {
    private static Scanner user = new Scanner (System.in);
    public static ArrayList <Pelicula> Peliculas = new ArrayList<>();
    public static ArrayList <Usuarios> Usuarios = new ArrayList<>();
    public static ArrayList<String> PalabrasVetadas = new ArrayList<>();
    public static ArrayList<String> ComentariosBorrados = new ArrayList<>();
    static int UserIdLogged; 
    static int idPeliculaSelect ;

    public static void main(String[] args) {
        ContenidoInicial();
        Menus.MenuLogIn();
    }
    public static void ContenidoInicial() {
        Usuarios.add(new Usuarios("Pepe","1",true, 0));
        Usuarios.add(new Usuarios("Ana" , "2" , false, 1));
        Usuarios.add(new Usuarios("Duncan" , "InLoveWithSofi" , true, 2));
        Usuarios.add(new Usuarios("Marra" , "GafasDeJeff" , false, 3));
        Peliculas.add(new Pelicula("Como entrenar a tu dragon", 98, 5, Pelicula.genero.infantil,"autor", "pelicula",0));
        Peliculas.add(new Pelicula("American History X", 120, 4.1, Pelicula.genero.drama,"autor","pelicula",1));
        Peliculas.add(new Pelicula("Indiana Jones: En busca del arca perdida", 115, 3.5, Pelicula.genero.aventura,"Tarantino","pelicula tarantido",2));
        Peliculas.add(new Pelicula("Frozen", 108, 5.1, Pelicula.genero.animacion,"Duncan","sergi",3));
        Peliculas.add(new Pelicula("El silencio de los corderos", 120, 4.3, Pelicula.genero.terror,"Rua","valiente",4));
        Peliculas.add(new Pelicula("ilencio de los corderos", 120, 4.3, Pelicula.genero.terror,"Sergio","falopero",5));
        PalabrasVetadas.add("Bueno");
        PalabrasVetadas.add("nazi");
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
       Menus.ImprimeMenu();
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
    //Habria que hacer algo con esto, WTF JHON?
    public static void SeleccionaPeliculaPorId() {
        System.out.println("Elige el id la pelicula que deseas seleccionar: ");
        int id = PideInt(); 
        idPeliculaSelect = id; 
        Menus.ImprimeFichaPelicula();
    }
    public static void SeleccionarPeliculaPorIndice() {
        System.out.println("Elige la pelicula que deseas seleccionar: ");
        int id = PideInt(); 
        idPeliculaSelect = id-1; 
        Menus.ImprimeFichaPelicula();
    }
    //Función para añadir palabras al array de palabras vetadas, no deja tener dos palabras iguales
    public static void añadirPalabraVetada(){
        boolean esta = false;
        System.out.println("Dime la palabra vetada");
        String palabra = RottenApp.PideString().toLowerCase();
        for (int i = 0; i <RottenApp.PalabrasVetadas.size(); i++) {
            if (RottenApp.PalabrasVetadas.get(i).toLowerCase().equals(palabra)) {
                esta = true;
            }
        }
        if(esta){
            System.out.println("Esa palabra ya existe");
        }
        else{
            RottenApp.PalabrasVetadas.add(palabra);
        } 
        Menus.ImprimeMenuPalabrasVetadas();
    }

    public static void BorrarPalabrasVetadas(){
        Menus.VerPalabrasVetadas();
        System.out.println("Elige la palabra vetada");
        int posiPalabra = RottenApp.PideInt();
        if (RottenApp.PalabrasVetadas.get(posiPalabra).isEmpty()) {
            System.out.println("Esa palabra no existe");
        }
        else{
            RottenApp.PalabrasVetadas.remove(posiPalabra);
        }
        Menus.ImprimeMenuPalabrasVetadas();
    }

    //Funcion que muestra los comentarios borrados y permite que un admin los restaure
    public static void AutorizarComentarios(){
        if (RottenApp.ComentariosBorrados.size()> 0) { //Primero se comprueba si hay comentarios borrados
            for (int i = 0; i <RottenApp.ComentariosBorrados.size(); i++) { 
                System.out.println((i+1 ) + " " + RottenApp.ComentariosBorrados.get(i) );
                ;
            }
            System.out.println("Selecciona un comentario");
            int seleccion = RottenApp.PideInt() -1;
            //int posiPelicula = RottenApp.PalabrasVetadas.get(seleccion).indexOf(':'); idea para hacerlo más óptimo
            System.out.println("Selecciona la película donde quieres guardar el comentario");
            for (int i = 0; i <RottenApp.Peliculas.size(); i++) {
                System.out.println((i+1) + " " + RottenApp.Peliculas.get(i).getNombre());
            }
            int pelicula = RottenApp.PideInt() - 1;
            RottenApp.Peliculas.get(pelicula).Comentarios.add(RottenApp.ComentariosBorrados.get(seleccion));
            RottenApp.ComentariosBorrados.remove(seleccion);
        }
        else{
            System.out.println("No hay comentarios borrados");
            Menus.ImprimeMenu();
        }
    }
   
}
