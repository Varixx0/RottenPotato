import java.util.ArrayList;

/**
 * Pelicula
 */
public class Pelicula {
    private String nombre;
    private int duracion;
    private double valoracion;
    private genero Tipo;
    public enum genero{
        terror,accion,romance,comedia,suspense,aventura,drama,animacion,infantil,policiaca,misterio,historico,familiar,seasonal;
    }

   
    
    public Pelicula(String nombre,int duracion,double valoracion,genero Genero){
        this.nombre = nombre;
        this.duracion = duracion;
        this.valoracion = valoracion;
        this.Tipo = Genero;
    }


    private ArrayList<String> Comentarios = new ArrayList<>();
    public ArrayList<String> Peliculas = new ArrayList<>();
    public ArrayList<String> PalabrasVetadas = new ArrayList<>();

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


    public void añadirPalabraVetada(String palabra){
        this.PalabrasVetadas.add(palabra);
    }
    
    public void añadirComentario(String comentario){
       boolean esta = false;
       for (int i = 0; i < PalabrasVetadas.size(); i++) {
        if (PalabrasVetadas.get(i).contains(comentario)) {
            esta = true;
        }
       }
       if (esta = true) {
        System.out.println("Has usado palabras vetadas");
       }
       else{
        this.Comentarios.add(comentario);
       }
    }

    public void añadirPelicula(String peli){
        this.Peliculas.add(peli);
    }

    
}