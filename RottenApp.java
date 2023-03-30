import java.util.ArrayList;
import java.util.Scanner;

/*
 * Rotten App
 */

public class RottenApp {
    private static Scanner user = new Scanner (System.in);
    public static ArrayList <Pelicula> Peliculas = new ArrayList<>();
    public static ArrayList <Usuarios> Usuarios = new ArrayList<>();
    public static ArrayList<String> PalabrasVetadas = new ArrayList<>();
    public static ArrayList<String> ComentariosBorrados = new ArrayList<>();
    static int UserIdLogged; 
    static int idPeliculaSelect;

    public static void main(String[] args) {
        ContenidoInicial();
        Menus.MenuLogIn();
    }
    public static void ContenidoInicial() {
        Usuarios.add(new Usuarios("Pepe","pepe",true, 0));
        Usuarios.add(new Usuarios("Ana" , "ana" , false, 1));
        Usuarios.add(new Usuarios("Duncan" , "duncan" , true, 2));
        Usuarios.add(new Usuarios("Marra" , "sergi" , false, 3));
        Peliculas.add(new Pelicula("Como entrenar a tu dragon", 98, 5, Pelicula.genero.infantil,"Dean DeBlois", "En la película Cómo entrenar a tu dragón, un joven vikingo llamado Hipo debe demostrar su valía al entrenar a un dragón herido y unir a su tribu con estas criaturas antes enemigas. A medida que crece su amistad, descubre un secreto que cambiará el futuro de ambos mundos.",0));
        Peliculas.add(new Pelicula("American History X", 120, 4.1, Pelicula.genero.drama,"Tony Kaye","American History X es una película que cuenta la historia de un ex-neonazi llamado Derek Vinyard que busca redimirse tras salir de prisión y ver cómo su ideología de odio ha afectado a su familia y comunidad, en una reflexión sobre la discriminación racial y la violencia.",1));
        Peliculas.add(new Pelicula("Indiana Jones: En busca del arca perdida", 115, 3.5, Pelicula.genero.aventura,"Steven Spielberg","Indiana Jones: En busca del arca perdida sigue al aventurero Indiana Jones en su misión de encontrar el arca de la alianza antes de que caiga en manos de los nazis durante la Segunda Guerra Mundial, enfrentando peligrosos obstáculos y descubriendo secretos ancestrales a lo largo del camino.",2));
        Peliculas.add(new Pelicula("Frozen", 98, 5.1, Pelicula.genero.animacion,"Chris Buck","Frozen es una película de animación de Disney que cuenta la historia de dos hermanas, Elsa y Anna, en un reino atrapado en un invierno eterno debido a los poderes de hielo de Elsa. Anna se embarca en una peligrosa aventura para encontrar a su hermana y poner fin al invierno, mientras aprenden el valor del amor fraternal y el poder de ser uno mismo",3));
        Peliculas.add(new Pelicula("El silencio de los corderos", 115, 4.3, Pelicula.genero.terror,"Jonathan Demme","El silencio de los corderos es una película de suspense psicológico en la que Clarice Starling, una joven agente del FBI, debe entrevistar al famoso asesino en serie Hannibal Lecter para obtener pistas sobre un nuevo caso. Sin embargo, se ve arrastrada a un peligroso juego del gato y el ratón con otro asesino en serie, Buffalo Bill, mientras lucha por mantenerse viva y resolver el caso.",4));
        Peliculas.add(new Pelicula("El club de la lucha", 139, 4.7, Pelicula.genero.drama, "David Fincher", "Brad Pitt y Edward Norton se involucran en un peligroso juego subterráneo de peleas mientras lidian con problemas de identidad y alienación en la sociedad de consumo moderna.", 5));        
        PalabrasVetadas.add("hitler");
        PalabrasVetadas.add("loco");
        PalabrasVetadas.add("esquizofrenia");
        PalabrasVetadas.add("huérfana");
        PalabrasVetadas.add("huérfana");
        PalabrasVetadas.add("caníbal");
        PalabrasVetadas.add("secuestro");
        PalabrasVetadas.add("psicópata");
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
            Menus.ImprimeMenu();
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
    public static void noSeEncontro(){
        System.out.println("No se han encontrado películas");
        Menus.ImprimeMenuVerPeliculasBuscarPelicula();
    }
    public static void BuscarPeliculaTitulo() {
        System.out.println("¿Que pelicula quieres buscar?");
        String Titulo= PideString();
        boolean seEncontro = false;
        for (int i = 0; i < Peliculas.size(); i++) {
            if (Peliculas.get(i).getNombre().indexOf(Titulo)!=-1) {
                System.out.println("ID: " + Peliculas.get(i).getId() + " " + Peliculas.get(i).getNombre());
                seEncontro = true;
            }
            
        }
        if (!seEncontro) {
            noSeEncontro();
        }
        SeleccionaPeliculaPorId();
    }
    public static void BuscarPeliculaAutor() {
        System.out.println("¿Que Autor quieres buscar?");
        String Autor= PideString(); 
        boolean seEncontro = false;
        for (int i = 0; i < Peliculas.size(); i++) {
            if (Peliculas.get(i).getAutor().indexOf(Autor)!=-1) {
                System.out.println("ID: " + Peliculas.get(i).getId() + " " + Peliculas.get(i).getNombre());
                seEncontro = true;
            }
            else{
                
            }
        }
        if (!seEncontro) {
            noSeEncontro();
        }
        SeleccionaPeliculaPorId();
    }
    public static void BuscarPeliculaValoracion(){
        System.out.println("¿A partir de que valoracion quieres buscar?");
        Double Valor = PideDouble();
        boolean seEncontro = false; 
        for (int i = 0; i < Peliculas.size(); i++) {
            if (Peliculas.get(i).getValoracion()>Valor) {
                System.out.println("ID: " + Peliculas.get(i).getId() + " " + Peliculas.get(i).getNombre());
                seEncontro = true;
            }
        }
        if (!seEncontro) {
            noSeEncontro();
        }
        SeleccionaPeliculaPorId();
    }
    public static void BuscarPeliculaGenero() {
        System.out.println("¿Que Genero quieres buscar?");
        Pelicula.genero Genero= PideGenero(); 
        boolean seEncontro = false;
        for (int i = 0; i < Peliculas.size(); i++) {
            if (Peliculas.get(i).getGenero().equals(Genero)) {
                System.out.println("ID: " + Peliculas.get(i).getId() + " " + Peliculas.get(i).getNombre());
                seEncontro = true;
            }
           
        }
        if (!seEncontro) {
            noSeEncontro();
        }
        SeleccionaPeliculaPorId();
    }
    //Habria que hacer algo con esto, WTF JHON?
    public static int SeleccionaPeliculaPorId() {
        System.out.println("Elige el id la pelicula que deseas seleccionar: ");
        int id = PideInt(); 
        if ((id -1 )> Peliculas.size()) {
            System.out.println("Esa película no existe");
            Menus.ImprimeMenuVerPeliculasBuscarPelicula();
        }
        else{
            idPeliculaSelect = id; 
            Menus.ImprimeFichaPelicula();
        }
        return id;
        
    }
    public static void SeleccionarPeliculaPorIndice() {
        System.out.println("Elige la pelicula que deseas seleccionar: ");
        int id = PideInt();
        if (id > RottenApp.Peliculas.size()) {
            System.out.println("Esa película no existe");
            Menus.ImprimeMenu();
        }
        else{
            idPeliculaSelect = id-1; 
            Menus.ImprimeFichaPelicula();
        }
        
        
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
        if (posiPalabra >= PalabrasVetadas.size()) {
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
            Menus.ImprimeTresComentarios();
        }
        else{
            System.out.println("No hay comentarios borrados");
            Menus.ImprimeMenu();
        }
    }
   
}
