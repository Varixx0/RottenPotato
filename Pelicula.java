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
        String palabra = RottenApp.PideString();
        System.out.println("Dime la palabra vetada");
        for (int i = 0; i <RottenApp.PalabrasVetadas.size(); i++) {
            if (RottenApp.PalabrasVetadas.get(i).toLowerCase().equals(palabra.toLowerCase())) {
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
        boolean esta = false;
       for (int i = 0; i < RottenApp.PalabrasVetadas.size(); i++) {
            if (RottenApp.PalabrasVetadas.contains(comentario)) {
                esta = true;
            }
       }
       if (esta) {
        System.out.println("Has usado una palabra vetada");
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
}