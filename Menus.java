
public class Menus {
    //Inicio Log in
    public static void MenuLogIn() {
        System.out.println("1. Crear cuenta");
        System.out.println("2. Entrar en mi cuenta");
        SelectorMenuLogIn();
        //Salir Quizas
    }
    public static void SelectorMenuLogIn() {
        switch (RottenApp.PideInt()) {
            case 1:
                Logs.CrearCuenta();
                break;
            case 2:
                Logs.LogInCuenta();
                break;
            default:
                System.out.println("Opción inválida, elige otra vez.");
             break;
            }
    }
    //Imprime el menu principal
    public static void ImprimeMenu() {
        System.out.println("Elige la opcion que deseas ejecutar");
        System.out.println("1. Crear Pelicula");
        System.out.println("2. Ver Peliculas");
        System.out.println("3. Modificar Cuenta");
        System.out.println("4. Salir de la cuenta");
        //Comprueba si es admin, si lo es imprime su menu especial
        if (RottenApp.Usuarios.get(RottenApp.UserIdLogged).isAdmin()) {
            ImprimeMenuAdmin();
            
        }else{
            SelectorMenu();
        }
        System.out.println("");
    }
    //Imprime el menu principal pero con opciones especiales
    public static void ImprimeMenuAdmin() {
        System.out.println("////////ADMINISTRADOR////////");
        System.out.println("5. Bloquear/Debloquear Usuarios");
        System.out.println("6. Actualizar lista de palabras Vetadas");
        SelectorMenuAdmin();
    }
    //Selector principal 
    public static void SelectorMenu() {
    switch (RottenApp.PideInt()) {
        case 1:
            RottenApp.CrearPelicula();
            break;
        case 2:
            VerPeliculas();
            break;
     case 3:
            SelectorMenuModificarCuenta();
            break;
        case 4:
            Logs.LogOut();
        break;
        default:
            System.out.println("Opción inválida, elige otra vez.");
         break;
        }
    }
    //Selector para admin, esta separado para que un usuario normal no pueda acceder a las opciones de administrador
    public static void SelectorMenuAdmin() {
        switch (RottenApp.PideInt()) {
            case 1:
                RottenApp.CrearPelicula();
                break;
            case 2:
                VerPeliculas();
                break;
            case 3:
                SelectorMenuAdministrarCuentas();
                break;
            case 4:
                Logs.LogOut();
            break;
            case 5:
                MenuAdminBloqDesbloq();
                break;
            case 6:
                MenuPalabrasVetadas();
                break;
            
            default:
                System.out.println("Opción inválida, elige otra vez.");
             break;
            }
    }
    public static void ImprimeMenuPalabrasVetadas(){
        System.out.println("////////ADMINISTRADOR////////");
        System.out.println("1.- Ver palabras vetadas");
        System.out.println("2.- Añadir palabras vetadas");
        System.out.println("3.- Borrar palabra vetada");
        System.out.println("4. Salir");
        MenuPalabrasVetadas();
    }
    public static void MenuPalabrasVetadas(){

        switch (RottenApp.PideInt()) {
            case 1:
                VerPalabrasVetadas();
                break;
            case 2:
                Pelicula.añadirPalabraVetada();
            case 3:
                Pelicula.BorrarPalabrasVetadas();
            case 4:
                ImprimeMenu();
            default:
                break;
        }
    }

    //Imprime el submenu de ver peliculas
    public static void ImprimeMenuVerPeliculas(){
        System.out.println("1. Ver todas las peliculas");
        System.out.println("2. Buscar Pelicula");
        System.out.println("3. Salir");
        if (RottenApp.Usuarios.get(RottenApp.UserIdLogged).isAdmin()) {
            ImprimeVerPeliculasAdmin();
        }else{
            SelectorVerPelicula();
        }
        System.out.println("");
    }
    //Imprime las opciones de administrador de ver peliculas
    public static void ImprimeVerPeliculasAdmin() {
        System.out.println("////////ADMINISTRADOR////////");
        System.out.println("4. Administrar Peliculas");
        SelectorVarPeliculaAdmin();
    }
    //Switch de VerPeliculas
    public static void SelectorVerPelicula() {
        switch (RottenApp.PideInt()) {
            case 1:
             // Lógica para crear una película
                break;
            case 2:
             // Lógica para ver las películas
                break;
            case 3:
             // Lógica para modificar la cuenta
                break;
            }
    }
    public static void SelectorVarPeliculaAdmin() {
        switch (RottenApp.PideInt()) {
            case 1:
             // Lógica para crear una película
                break;
            case 2:
             // Lógica para ver las películas
                break;
            case 3:
             // Lógica para modificar la cuenta
                break;
            case 4:
                // Lógica para salir de la cuenta
            break;
            }
    }
    //Imprime el submenu para buscar pelicula
    public static void ImprimeMenuVerPeliculasBuscarPelicula(){
        System.out.println("1. Buscar por Nombre");
        System.out.println("2. Buscar por Autor");
        System.out.println("3. Buscar por Genero");
        System.out.println("4. Buscar por Valoracion");
        System.out.println("5. Salir");
        System.out.println("");
        SelectorBuscarPelicula();
    }
    //Switch para buscar pelicula
    public static void SelectorBuscarPelicula() {
        switch (RottenApp.PideInt()) {
            case 1:
                RottenApp.BuscarPeliculaTitulo();
                break;
            case 2:
                RottenApp.BuscarPeliculaAutor();
                break;
            case 3:
                RottenApp.BuscarPeliculaGenero();
                break;
            case 4:
                RottenApp.BuscarPeliculaValoracion();
            break;
            case 5:
                ImprimeMenu();
                break;
            }
    }
    //Imprime la ficha de la pelicula seleccionada
    public static void ImprimeFichaPelicula(int index) {
        System.out.println("/////////////////");
        System.out.println("TITULO: " + RottenApp.Peliculas.get(index).getNombre());
        System.out.println("DURACION: " +String.valueOf(RottenApp.Peliculas.get(index).getDuracion()));
        System.out.println("VALORACION: " +String.valueOf(RottenApp.Peliculas.get(index).getValoracion()) + "*");
        System.out.println("GENERO: " + String.valueOf(RottenApp.Peliculas.get(index).getGenero()));
        System.out.println("/////////////////");
        System.out.println("DESCRIPCION: " +RottenApp.Peliculas.get(index).getDescripcion());
        ImprimeTresComentarios();

    }
    //Imprime los 3 ultimos comentarios, te deja entrar a una subpagina con todos los comentarios
    public static void ImprimeTresComentarios() {
        for (int i = 0; i < 3; i++) {
           System.out.println(RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).InfoComentarios(i)); 
        }
        ImprimeMenuComentarios();
    }
    public static void ImprimeMenuComentarios() {
        System.out.println("1. Ver todos los comentarios");
        System.out.println("2. Salir");
        if(RottenApp.Usuarios.get(RottenApp.UserIdLogged).isAdmin()) {
            ImprimeMenuComentariosAdmin();
        }else{
            SelectorMenuComentarios();
        }
    }
    //Imprime las opciones extra de el menu de comentarios para administradores
    public static void ImprimeMenuComentariosAdmin() {
        System.out.println("////////ADMINISTRADOR////////");
        System.out.println("3. Ver comentarios borrados");
        System.out.println("4. Administarar comentarios");
        SelectorMenuComentariosAdmin();
    }
    //Selector de comentarios
    public static void SelectorMenuComentarios() {
        switch (RottenApp.PideInt()) {
            case 1:
             // Lógica para crear una película
                break;
            case 2:
             // Lógica para ver las películas
                break;
            default:
                System.out.println("Opción inválida, elige otra vez.");
             break;
            }
    }
    public static void SelectorMenuComentariosAdmin() {
        switch (RottenApp.PideInt()) {
            case 1:
             // Lógica para crear una película
                break;
            case 2:
             // Lógica para ver las películas
                break;
            case 3:
             // Lógica para modificar la cuenta
                break;
            case 4:
                // Lógica para salir de la cuenta
            break;
            default:
                System.out.println("Opción inválida, elige otra vez.");
             break;
            }
    }
    //imprime todos los comentarips
    public static void TodosLosComentarios() {
        for (int i = 0; i < Pelicula.Comentarios.size(); i++) {
            System.out.println(RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).Comentarios.get(i));
        }
        ImprimeMenuComentarios();
    }
    //Menu administrador de cuentas
    public static void MenuAdministrarCuentas() {
        System.out.println("////////ADMINISTRADOR////////");
        System.out.println("1. Eliminar cuenta");
        System.out.println("2. Cambiar nombre");
        System.out.println("3. Cambiar Contraseña");
        SelectorMenuAdministrarCuentas();
    }
    public static void SelectorMenuAdministrarCuentas() {
        switch (RottenApp.PideInt()) {
            case 1:
                Logs.EliminarCuentas();
                break;
            case 2:
                Logs.CambiarNombre();
                break;
            case 3:
                Logs.CambiarContra();
                break;
            default:
                System.out.println("Opción inválida, elige otra vez.");
             break;
            }
    }

    //Submenu de admin para bloquear/Desbloquear personas. 
    public static void MenuAdminBloqDesbloq() {
        System.out.println("1. Ver cuentas bloqueadas");
        System.out.println("2. Bloquear cuentas");
        System.out.println("3. Desbloquear cuentas");
        System.out.println("4. Salir");
    }

    public static void SelectorMenuAdminBloqDesbloq() {
        switch (RottenApp.PideInt()) {
            case 1:
                Logs.EliminarCuentas();
                break;
            case 2:
                Logs.CambiarNombre();
                break;
            case 3:
                Logs.CambiarContra();
                break;
            default:
                System.out.println("Opción inválida, elige otra vez.");
             break;
            }
    }public static void SelectorMenuModificarCuenta() {
        switch (RottenApp.PideInt()) {
            case 1:
                Logs.CambiarNombre();
                break;
            case 2:
                Logs.CambiarContra();
                break;
            default:
                System.out.println("Opción inválida, elige otra vez.");
             break;
            }
    }
    //Imprime el de una cuenta a partir de su indice. Ademas le da un numero para que sea seleccionable
    public static void VerCuenta(int id) {
        System.out.println(id + ". " + RottenApp.Usuarios.get(id).getNombre());
    }
    public static void VerPeliculas(){
        for (int index = 0; index < RottenApp.Peliculas.size(); index++) {
            System.out.println( (index+1) +" "+RottenApp.Peliculas.get(index).getNombre());
        }
    }

    public static void VerPalabrasVetadas(){
        for (int i = 0; i < RottenApp.PalabrasVetadas.size() ; i++) {
            System.out.println(RottenApp.PalabrasVetadas.get(i));
        }
    }
    public static void ListarCuentas() {
        for (int i = 0; i < RottenApp.Usuarios.size(); i++) {
            VerCuenta(i);
        }
    }

}
