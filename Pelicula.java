
import java.util.ArrayList;
//Atributos
public class Pelicula {
    
    private String nombre;
    private int duracion;
    private double valoracion;
    private genero Tipo;
    private String Descripcion;
    private String Autor;
    private int id;
    public  enum genero{
        terror,accion,romance,comedia,suspense,aventura,drama,animacion,infantil,policiaca,misterio,historico,familiar,seasonal;
    }

   
    //Constructor
    public Pelicula(String nombre,int duracion,double valoracion,genero Genero, String Autor, String Desc,int id){
        this.nombre = nombre;
        this.duracion = duracion;
        this.valoracion = valoracion;
        this.Tipo = Genero;
        this.Descripcion=Desc;
        this.id = id;
        this.Autor=Autor;
    }

    //Arrays
    public static ArrayList<String> Comentarios = new ArrayList<>();
    
    //Setters y getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public double getValoracion() {
        return valoracion;
    }
    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
    public genero getGenero(){
        return this.Tipo;
    }
    public void setGenero(genero tipo){
        this.Tipo = tipo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    //get
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
    
    public void setAutor(String Autr){
        Autor=Autr; 
    }
    public String getAutor(){
        return Autor;
    }

    

    //Función que añade comentario a la pelicula que escoja el usuario 
    public static void añadirComentario(String comentario){
        String palabras [] = comentario.split("\\s+"); //Divide el comentario en palabras
        boolean esta = false;
        //Este for comprueba cada palabra del comentario con las del array de palabras vetadas
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i].toLowerCase();
            if (RottenApp.PalabrasVetadas.contains(palabra)) {
                esta = true;
            }
        }
        //Si una palabra vetada está en el comentario se añade al array de comentarios borrados, junto con el nombre del usuario que lo ha escrito
       if (esta) {
        System.out.println("Has usado una palabra vetada");
        RottenApp.ComentariosBorrados.add(RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).getNombre() + ": " + comentario);
       }
       //Si no contiene palabras vetadas se añade al array de comentarios
       else{
        Comentarios.add( RottenApp.Usuarios.get(RottenApp.UserIdLogged).getNombre() + ": " + comentario);
       }
       Menus.ImprimeMenu();
    }
    

    
    //Función para agregar valoración a un película debe ser entre 0.0 y 5.0
    public void agregarValoracion(double valor){
        if (valor < 0 || valor > 5) {
            System.out.println("Valor mal introducido");
        }
        else{
            this.valoracion = valor;
        }
    }
    //Funcion para pasarle la informacion a la ficha en Ver Pelicula
    public static String InfoComentarios(int indice) {  
        if (RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).Comentarios.isEmpty()) {
            return ("No hay comentarios");
        }
        else{
            return Comentarios.get(indice);
        }
    }
    
    
    //Método que permite borrar un comentario
    public static void BorrarComentario(){
        System.out.println("Escoge la película");
        for (int i = 0; i <RottenApp.Peliculas.size(); i++) {
            System.out.println((i+1) + " " + RottenApp.Peliculas.get(i).getNombre());
        }
        int pelicula = RottenApp.PideInt() - 1;
        if (RottenApp.Peliculas.get(pelicula).Comentarios.size() > 0) {
            Menus.TodosLosComentarios();
            System.out.println("Ahora dime el comentario que quieres borrar");
            int comentario = RottenApp.PideInt();
            RottenApp.Peliculas.get(pelicula).Comentarios.remove(comentario);
        }
        else{
            System.out.println("Esa película no tiene comentarios");
            Menus.ImprimeMenu();
        }
    }
    public static int ElegirPelícula(){
        System.out.println("Dime la película que quieres modificar");
        Menus.VerPeliculas();
        int pelicula = RottenApp.PideInt() -1;
        return pelicula;
    }
    public static int ElegirPelícula(char letra){
        System.out.println("Dime la película que quieres eliminar");
        for (int i = 0; i <RottenApp.Peliculas.size(); i++) {
            System.out.println(i+1 +" "+RottenApp.Peliculas.get(i).getNombre());

        }
        int pelicula = RottenApp.PideInt() -1;
        return pelicula;
    }

    public static void nuevaFicha(int pelicula){
        System.out.println("\n");
        System.out.println("Nueva ficha");
        Menus.ImprimeFichaPelicula(pelicula);
    }
    public static void CambiarNombre(){
        int pelicula = ElegirPelícula();
        System.out.println("Este su nombre antiguo antiguo");
        System.out.println(RottenApp.Peliculas.get(pelicula).getNombre());
        System.out.println("Dime el nombre nuevo");
        RottenApp.Peliculas.get(pelicula).setNombre(RottenApp.PideString());
        nuevaFicha(pelicula);
    }

    public static void CambiarValoracion(){
        int pelicula = ElegirPelícula();
        System.out.println("Esta es su vieja valoración " + RottenApp.Peliculas.get(pelicula).getValoracion());
        System.out.println("Dame su nueva valoración");
        RottenApp.Peliculas.get(pelicula).setValoracion(RottenApp.PideDouble());
        nuevaFicha(pelicula);
    }

    public static void CambiarDuracion(){
        int pelicula = ElegirPelícula();
        System.out.println("Esta es su antigua duración " + RottenApp.Peliculas.get(pelicula).getDuracion()+ " minutos");
        int valoracion;
        do {
            System.out.println("Dame su nueva duración");
            valoracion = RottenApp.PideInt();
            if (valoracion < 60) {
                System.out.println("Esta no es la duración de un largometraje");
                System.out.println();
            }
        } while (valoracion < 60);
        RottenApp.Peliculas.get(pelicula).setValoracion(valoracion);
        nuevaFicha(pelicula);
    }

    public static void CambiarGenero(){
        int pelicula = ElegirPelícula();
        System.out.println("Este es el antiguo género de la película " + RottenApp.Peliculas.get(pelicula).getGenero());
        System.out.println("Dime el género nuevo de la película");
        Pelicula.genero genero = RottenApp.PideGenero();
        RottenApp.Peliculas.get(pelicula).setGenero(genero);
       nuevaFicha(pelicula);
    }

    public static void CambiarDescripcion(){
        int pelicula = ElegirPelícula();
        System.out.println("Este es la antigua descripción");
        System.out.println(RottenApp.Peliculas.get(pelicula).getDescripcion());
        System.out.println();
        System.out.println("Dame la nueva descripción");
        RottenApp.Peliculas.get(pelicula).setDescripcion(RottenApp.PideString());
        nuevaFicha(pelicula);
    }

    public static void EliminarPelicula(){
        int pelicula = ElegirPelícula('e');
        System.out.println("\n");
        System.out.println("Así era la lista antes");
        Menus.VerPeliculas();
        RottenApp.Peliculas.remove(pelicula);
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("Así es ahora");
        Menus.VerPeliculas();

    }
}