

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
    public static void ImprimeFichaPelicula(String Nombre, int Tiempo, double Valoracion, Pelicula.genero Generos, String Descripcion) {
        System.out.println("/////////////////");
        System.out.println("TITULO: " + Nombre);
        System.out.println("DURACION: " + String.valueOf(Tiempo) + " min");
        System.out.println("VALORACION: " + String.valueOf(Valoracion) + "*");
        System.out.println("GENERO: " + String.valueOf(Generos));
        System.out.println("/////////////////");
        System.out.println("DESCRIPCION: " + Descripcion);
    }
}
