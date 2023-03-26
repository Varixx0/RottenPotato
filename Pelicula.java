import java.util.ArrayList;

/**
 * Pelicula
 */
public class Pelicula {
    private String nombre;
    private int duracion;
    private double valoracion;
    private genero Tipo;
    private enum genero{
        terror,accion,romance,comedia,suspense,aventura,drama,animacion,infantil,policiaca,misterio,historico,familiar,seasonal;
    }

    Pelicula p0 = new Pelicula("American History X", 120, 5, genero.drama);
    
    public Pelicula(String nombre,int duracion,double valoracion,genero Genero){
        this.nombre = nombre;
        this.duracion = duracion;
        this.valoracion = valoracion;
        this.Tipo = Genero;
    }


    private ArrayList<String> Comentarios;
    public ArrayList<String> Peliculas;
    public ArrayList<String> PalabrasVetadas;

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
       if (PalabrasVetadas.contains(comentario)) {
        System.out.println("Esa palabra no se puede usar");
       }
       else{
        this.Comentarios.add(comentario)
       }
    }

    public void añadirPelicula(String peli){
        this.Peliculas.add(peli);
    }

    
}