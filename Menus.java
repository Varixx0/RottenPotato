import com.apple.eawt.event.RotationEvent;

public class Menus {
    public static void ImprimeMenu() {
        System.out.println("Elige la opcion que deseas ejecutar");
        System.out.println("1. Crear Pelicula");
        System.out.println("2. Ver Peliculas");
        System.out.println("3. Modificar Cuenta");
        System.out.println("4. Salir de la cuenta");
        if (Usuarios.isAdmin()) {
            ImprimeMenuAdmin();
        }
        System.out.println("");
    }
    public static void ImprimeMenuAdmin() {
        System.out.println("////////ADMINISTRADOR////////");
        System.out.println("5. Bloquear/Debloquear Usuarios");
        System.out.println("6. Actualizar lista de palabras Vetadas");
    }
    public static void ImprimeMenuVerPeliculas(){
        System.out.println("1. Ver todas las peliculas");
        System.out.println("2. Buscar Pelicula");
        System.out.println("3. Salir");
        if (Usuarios.isAdmin()) {
            ImprimeVerPeliculasAdmin();
        }
        System.out.println("");
    }
    public static void ImprimeVerPeliculasAdmin() {
        System.out.println("////////ADMINISTRADOR////////");
        System.out.println("4. Administrar Peliculas");
    }
    public static void ImprimeMenuVerPeliculasBuscarPelicula(){
        System.out.println("1. Buscar por Nombre");
        System.out.println("2. Buscar por Autor");
        System.out.println("3. Buscar por Genero");
        System.out.println("4. Buscar por Valoracion");
        System.out.println("5. Salir");
        System.out.println("");

    }
    public static void ImprimeFichaPelicula(int index) {
        System.out.println("/////////////////");
        System.out.println("TITULO: " + RottenApp.Peliculas.get(index).getNombre());
        System.out.println("DURACION: " +String.valueOf(RottenApp.Peliculas.get(index).getDuracion()));
        System.out.println("VALORACION: " +String.valueOf(RottenApp.Peliculas.get(index).getValoracion()) + "*");
        System.out.println("GENERO: " + RottenApp.Peliculas.get(index).G());
        System.out.println("/////////////////");
        System.out.println("DESCRIPCION: " +RottenApp.Peliculas.get(index).getNombre());
        ImprimeComentarios();

    }
    public static void ImprimeComentarios() {
        for (int i = 0; i < 3; i++) {
           System.out.println(Pelicula.InfoComentarios(i)); 
        }
        System.out.println("1. Ver todos los comentarios");
        System.out.println("2. Salir");
    }
    public static void TodosLosComentarios() {
        for (int i = 0; i < Pelicula.Comentarios.size(); i++) {
            System.out.println(Pelicula.InfoComentarios(i));
        }
    }

}
