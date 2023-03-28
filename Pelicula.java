import java.util.ArrayList;
//Push
//Atributos
public class Pelicula {
    private String nombre;
    private int duracion;
    private double valoracion;
    private genero Tipo;
    private String Descripcion;
    public  enum genero{
        terror,accion,romance,comedia,suspense,aventura,drama,animacion,infantil,policiaca,misterio,historico,familiar,seasonal;
    }

   
    //Constructor
    public Pelicula(String nombre,int duracion,double valoracion,genero Genero, String Desc){
        this.nombre = nombre;
        this.duracion = duracion;
        this.valoracion = valoracion;
        this.Tipo = Genero;
        this.Descripcion=Desc;
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
    
    //get
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
    //Función para añadir palabras al array de palabras vetadas puede ser llamado en cualquier momento
    public static void añadirPalabraVetada(String palabra){
        RottenApp.PalabrasVetadas.add(palabra);
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
        Comentarios.add(comentario);
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