import java.util.ArrayList;

public class RottenApp {
    private static ArrayList <Pelicula> Peliculas = new ArrayList<>();
    private static ArrayList <Usuarios> Usuarios = new ArrayList<>();
    public static void main(String[] args) {
        ContenidoInicial();

        
    }
    public static void ContenidoInicial() {
        Usuarios.add(new Usuarios("Pepe","1234",true));
        Usuarios.add(new Usuarios("Ana" , "HolaSoyAna" , false));
        Usuarios.add(new Usuarios("Duncan" , "InLoveWithSofi" , true));
        Usuarios.add(new Usuarios("Marra" , "GafasDeJeff" , false));
        Peliculas.add(new Pelicula("Como entrenar a tu dragon", 98, 5, Pelicula.genero.infantil));
        Peliculas.add(new Pelicula("American History X", 120, 4.1, Pelicula.genero.drama));
        Peliculas.add(new Pelicula("Indiana Jones: En busca del arca perdida", 115, 3.5, Pelicula.genero.aventura));
        Peliculas.add(new Pelicula("Frozen", 108, 5.1, Pelicula.genero.animacion));
        Peliculas.add(new Pelicula("El silencio de los corderos", 120, 4.3, Pelicula.genero.terror));

        
    }

    public static void CrearPelicula(){
        
    }
}
