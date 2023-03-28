import java.util.ArrayList;
//Push
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
    //Función para añadir palabras al array de palabras vetadas puede ser llamado en cualquier momento
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
    }
    public void setAutor(String Autr){
        Autor=Autr; 
    }
    public String getAutor(){
        return Autor;
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
    }

    //Función que añade comentario a la pelicula que escoja el usuario 
    public static void añadirComentario(String comentario){
        String palabras [] = comentario.split("\\s+");
        boolean esta = false;
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i].toLowerCase();
            if (RottenApp.PalabrasVetadas.contains(palabra)) {
                esta = true;
            }
        }
       if (esta) {
        System.out.println("Has usado una palabra vetada");
        RottenApp.ComentariosBorrados.add(RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).getNombre() + ": " + comentario);
       }
       else{
        Comentarios.add( RottenApp.Usuarios.get(RottenApp.UserIdLogged).getNombre() + ": " + comentario);
       }
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
        return Comentarios.get(indice);
    }

    public static void AutorizarComentarios(){
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

    public static void BorrarComentario(){
        System.out.println("Escoge la película");
        for (int i = 0; i <RottenApp.Peliculas.size(); i++) {
            System.out.println((i+1) + " " + RottenApp.Peliculas.get(i).getNombre());
        }
        int pelicula = RottenApp.PideInt() - 1;
        for (int i = 0; i <RottenApp.Peliculas.get(pelicula).Comentarios.size(); i++) {
            RottenApp.Peliculas.get(pelicula).Comentarios.get(i);
        }
        System.out.println("Ahora dime el comentario que quieres borrar");
        int comentario = RottenApp.PideInt();
        RottenApp.Peliculas.get(pelicula).Comentarios.remove(comentario);
    }
}