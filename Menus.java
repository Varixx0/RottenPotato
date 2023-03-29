
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
            case 42:
                EasterEgg();
                break;
            default:
                System.out.println("Esa opción no existe");
                MenuLogIn();
                break;
            }
    }
    public static void EasterEgg(){
        System.out.println("                                   ''~``");
        System.out.println("                                  ( o o )");
        System.out.println("  +--------------------------.oooO--(_)--Oooo.--------------------------+");
        System.out.println("  |                                                                     |");
        System.out.println("  |                          VARIXX & SEMPAI N                          |");
        System.out.println("  |                                                                     |");
        System.out.println("  |                            .oooO                                    |");
        System.out.println("  |                            (   )   Oooo.                            |");
        System.out.println("  +-----------------------------) (----(   )----------------------------+");
        System.out.println("                                (__)    ) /");
        System.out.println("                                        (_/");
        Menus.MenuLogIn();
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
            ImprimeMenuVerPeliculas();
            break;
     case 3:
            MenuModificarCuenta();
            break;
        case 4:
            Logs.LogOut();
        break;
        default:
            System.out.println("Opción inválida, elige otra vez.");
            ImprimeMenu();
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
                ImprimeMenuVerPeliculas();
                break;
            case 3:
               if (RottenApp.Usuarios.get(RottenApp.UserIdLogged).isAdmin()) {
                    MenuAdministrarCuentas();
               } else {
                    MenuModificarCuenta();
               }
                break;
            case 4:
                Logs.LogOut();
            break;
            case 5:
                MenuAdminBloqDesbloq();
                break;
            case 6:
                ImprimeMenuPalabrasVetadas();
                break;
            
            default:
                System.out.println("Opción inválida, elige otra vez.");
                ImprimeMenu();
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
                ImprimeMenuPalabrasVetadas();
                break;
            case 2:
                Pelicula.añadirPalabraVetada();
            case 3:
                Pelicula.BorrarPalabrasVetadas();
            case 4:
                ImprimeMenu();
            default:
                System.out.println("Esa opción no existe, elige otra");
                ImprimeMenuPalabrasVetadas();
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
                VerPeliculas();
                RottenApp.SeleccionarPeliculaPorIndice();
                break;
            case 2:
                ImprimeMenuVerPeliculasBuscarPelicula();
                break;
            case 3:
                ImprimeMenu();
                break;
            }
    }
    public static void SelectorVarPeliculaAdmin() {
        switch (RottenApp.PideInt()) {
            case 1:
                VerPeliculas();
                RottenApp.SeleccionarPeliculaPorIndice();
                break;
            case 2:
                 ImprimeMenuVerPeliculasBuscarPelicula();
                break;
            case 3:
                ImprimeMenu();
                break;
            case 4:
                ImprimeMenuAdministrarPeliculas();
            break;
            }
    }

    public static void ImprimeMenuAdministrarPeliculas(){
        System.out.println("////////ADMINISTRADOR////////");
        System.out.println("1.- Cambiar nombre");
        System.out.println("2.- Cambiar Valoración");
        System.out.println("3.- Cambiar Duración");
        System.out.println("4.- Cambiar género");
        System.out.println("5.- Cambiar descripción");
        System.out.println("6.- Eliminar Película");
        MenuAdministrarPeliculas();
    }
    public static void MenuAdministrarPeliculas(){
        switch (RottenApp.PideInt()) {
            case 1:
                Pelicula.CambiarNombre();
                break;
            case 2:
                //Pelicula.CambiarValoracion();
            case 3:
                //Pelicula.CambiarDuracion();
            case 4:
                //Pelicula.CambiarGenero();
            case 5:
                //Pelicula.CambiarDescripcion();
            case 6:
                //Pelicula.EliminarPelicula();
            default:
                System.out.println("Esa opción no existe, elige otra");
                ImprimeMenuAdministrarPeliculas();
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
            
            default:
                System.out.println("Esa opción no existe");
                ImprimeMenu();
                break;
        }
    }
    //Imprime la ficha de la pelicula seleccionada
    public static void ImprimeFichaPelicula() {
        System.out.println("/////////////////");
        System.out.println("TITULO: " + RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).getNombre());
        System.out.println("DURACION: " +String.valueOf(RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).getDuracion()));
        System.out.println("VALORACION: " +String.valueOf(RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).getValoracion()) + "*");
        System.out.println("GENERO: " + String.valueOf(RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).getGenero()));
        System.out.println("/////////////////");
        System.out.println("DESCRIPCION: " +RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).getDescripcion());
        ImprimeTresComentarios();

    } public static void ImprimeFichaPelicula(int num) {
        System.out.println("/////////////////");
        System.out.println("TITULO: " + RottenApp.Peliculas.get(num).getNombre());
        System.out.println("DURACION: " +String.valueOf(RottenApp.Peliculas.get(num).getDuracion()));
        System.out.println("VALORACION: " +String.valueOf(RottenApp.Peliculas.get(num).getValoracion()) + "*");
        System.out.println("GENERO: " + String.valueOf(RottenApp.Peliculas.get(num).getGenero()));
        System.out.println("/////////////////");
        System.out.println("DESCRIPCION: " +RottenApp.Peliculas.get(num).getDescripcion());
        

    }
    //Imprime los 3 ultimos comentarios, te deja entrar a una subpagina con todos los comentarios.
    public static void ImprimeTresComentarios() {
        int numComentarios = RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).Comentarios.size();
        int numComentariosAMostrar = Math.min(numComentarios, 3);
        for (int i = 0; i < numComentariosAMostrar; i++) {
            System.out.println(RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).InfoComentarios(i)); 
        }
        if (numComentarios == 0) {
            System.out.println("No hay comentarios.");
        } 
        ImprimeMenuComentarios();
    }
    public static void ImprimeMenuComentarios() {
        System.out.println("1. Ver todos los comentarios");
        System.out.println("2. Comentar");
        System.out.println("3. Salir");
        if(RottenApp.Usuarios.get(RottenApp.UserIdLogged).isAdmin()) {
            ImprimeMenuComentariosAdmin();
        }else{
            SelectorMenuComentarios();
        }
    }
    //Imprime las opciones extra de el menu de comentarios para administradores
    public static void ImprimeMenuComentariosAdmin() {
        System.out.println("////////ADMINISTRADOR////////");
        System.out.println("4. Ver comentarios borrados");
        System.out.println("5. Administarar comentarios");
        SelectorMenuComentariosAdmin();
    }
    //Selector de comentarios
    public static void SelectorMenuComentarios() {
        switch (RottenApp.PideInt()) {
            case 1:
                TodosLosComentarios();
                break;
            case 2:
                ImprimeMenuComentar();
                break;
            case 3:
                ImprimeMenu();
                break;
            default:
                System.out.println("Opción inválida, elige otra vez.");
                ImprimeMenuComentar();
             break;
            }
    }
    public static void ImprimeMenuComentar() {
        System.out.println("Introduce el comentario que quieras poner: ");
        String Comentario = RottenApp.PideString();
        RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).añadirComentario(Comentario);
    }
    public static void ImprimeMenuAdministrarcomentarios(){
        System.out.println("////////ADMINISTRADOR////////");
        System.out.println("1.- Autorizar Comentarios");
        System.out.println("2.- Borrar Comentarios");
        System.out.println("3.- Salir");
        System.out.println("4.- Modificar comentarios <Provisional>");
        SelectorMenuAdministarComentarios();
    }
    public static void SelectorMenuAdministarComentarios(){
        switch (RottenApp.PideInt()) {
            case 1:
                Pelicula.AutorizarComentarios();
                break;
            case 2:
                Pelicula.BorrarComentario();
            case 3:
                ImprimeMenu();
            default:
                System.out.println("Esa opción no existe,elige otra");
                ImprimeMenuAdministrarcomentarios();
                break;
        }
    }
    public static void SelectorMenuComentariosAdmin() {
        switch (RottenApp.PideInt()) {
            case 1:
                TodosLosComentarios();
                break;
            case 2:
                ImprimeMenuComentar();
                break;
            case 3:
                ImprimeMenu();
                break;    
            case 4:
                VerComentariosBorrados();
                break;
            case 5:
                ImprimeMenuAdministrarcomentarios();
            break;
            default:
                System.out.println("Opción inválida, elige otra vez.");
                ImprimeMenuComentarios();
             break;
            }
        
    }
    public static void VerComentariosBorrados(){
        if (RottenApp.ComentariosBorrados.size() > 0) {
            for (int i = 0; i <RottenApp.ComentariosBorrados.size(); i++) {
                System.out.println(RottenApp.ComentariosBorrados.get(i));
            }
        }
        else{
            System.out.println("No hay comentarios borrados");
        }
        ImprimeMenu();
    }
    //imprime todos los comentarios
    public static void TodosLosComentarios() {
        for (int i = 0; i < Pelicula.Comentarios.size(); i++) {
            System.out.println(RottenApp.Peliculas.get(RottenApp.idPeliculaSelect).Comentarios.get(i));
        }
        ImprimeMenuComentarios();
    }
    //Menu administrador de cuentas
    public static void MenuAdministrarCuentas() {
        System.out.println("////////ADMINISTRADOR////////");
        System.out.println("1.- Eliminar cuenta");
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
                MenuAdministrarCuentas();
             break;
            }
    }

    //Submenu de admin para bloquear/Desbloquear personas. 
    public static void MenuAdminBloqDesbloq() {
        System.out.println("1. Ver cuentas bloqueadas");
        System.out.println("2. Bloquear cuentas");
        System.out.println("3. Desbloquear cuentas");
        System.out.println("4. Salir");
        SelectorMenuAdminBloqDesbloq();
    }

    public static void SelectorMenuAdminBloqDesbloq() {
        switch (RottenApp.PideInt()) {
            case 1:
                Logs.VerBloqueados();
                ImprimeMenu();
                break;
            case 2:
                Logs.BloquearUsuario();
                break;
            case 3:
                Logs.DesbloquearUsuario();
                break;
            case 4:
                ImprimeMenu();
            default:
                System.out.println("Opción inválida, elige otra vez.");
                MenuAdminBloqDesbloq();
             break;
            }
    
    }
    public static void MenuModificarCuenta() {
        System.out.println("1. Cambiar nombre");
        System.out.println("2. Cambiar Contraseña");
        System.out.println("3. Salir");
        SelectorMenuModificarCuenta();
    }
    public static void SelectorMenuModificarCuenta() {
        switch (RottenApp.PideInt()) {
            case 1:
                Logs.CambiarNombre();
                break;
            case 2:
                Logs.CambiarContra();
                break;
            case 3: 
                ImprimeMenu();
            default:
                System.out.println("Opción inválida, elige otra vez.");
                MenuModificarCuenta();
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
            System.out.println(i+". "+RottenApp.PalabrasVetadas.get(i));
        }
    }
    public static void ListarCuentas() {
        for (int i = 0; i < RottenApp.Usuarios.size(); i++) {
            VerCuenta(i);
        }
    }

}
