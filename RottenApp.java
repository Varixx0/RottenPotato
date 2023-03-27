

public class RottenApp {
    public static void main(String[] args) {
        
    }
    public static void ContenidoInicial() {
        Usuarios Manuel = new Usuarios("Manuel" , "1234" , true);
        Usuarios Ana = new Usuarios("Ana" , "HolaSoyAna" , false);
        Usuarios Duncan= new Usuarios("Duncan" , "InLoveWithSofi" , true);
        Usuarios Sergi = new Usuarios("Marra" , "GafasDeJeff" , false);
        Pelicula ComoEntrenarATuDragon = new Pelicula("Como entrenar a tu dragon", 98, 5, Pelicula.genero.infantil);
        Pelicula AmericanHistoryX = new Pelicula("American History X", 120, 4.1, Pelicula.genero.drama);
        Pelicula ElSilencioDeLosCorderos = new Pelicula("El silencio de los corderos", 120, 4.3, Pelicula.genero.terror);
        Pelicula IndianaJones = new Pelicula("Indiana Jones: En busca del arca perdida", 115, 3.5, Pelicula.genero.aventura);
        Pelicula Frozen = new Pelicula("Frozen", 108, 5.1, Pelicula.genero.animacion);
    }
}
