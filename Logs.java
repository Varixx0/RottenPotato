
//duncan castellano
public class Logs {
    //Falta un boton de salir (Por si acaso)
    public static void CrearCuenta() {
        System.out.println("////////////");
        System.out.println("Introduce el username:");
        String username= RottenApp.PideString(); 
        if (!Comprobacio.NombreRepetido(username)) {
            System.out.println("A continuacion introduce la contraseña que quieres que tenga la cuenta: ");
            String Cont1= RottenApp.PideString(); 
            System.out.println("Vuelve a introducir la contraseña");
            String Cont2= RottenApp.PideString();
            if (Comprobacio.ContraCoincide(Cont1, Cont2)) {
                RottenApp.Usuarios.add(new Usuarios(username , Cont1 , false, RottenApp.Usuarios.size()));
            }else{
                System.out.println("Las contraseñas que has introducido no son iguales");
                CrearCuenta();
            }
        } else {
            System.out.println("El usuario ya existe, por favor introduce otro nombre de usuario");
            CrearCuenta();
        }
    }
    public static void LogInCuenta() {
        System.out.println("Por favor introduce tu nombre de usuario: ");
        String username = RottenApp.PideString(); 
        //Lo hago asi en lugar de con un boolean porque de esta manera puedo devolver el id del usuario que trata de registrarse
        if (Comprobacio.UsuarioExiste(username)!=-1) {
            int idUsuario= Comprobacio.UsuarioExiste(username);
            System.out.println("Por favor introduce la contraseña: ");
            String Cont = RottenApp.PideString(); 
            if (Comprobacio.ComparaConras(Cont, idUsuario)) {
                System.out.println("Buenos dias " + RottenApp.Usuarios.get(idUsuario).getNombre()) ;
                System.out.println("////////////////");
                RottenApp.UserIdLogged=idUsuario;
                Menus.ImprimeMenu();
            } else {
                System.out.println("Contraseña incorrecta");
                LogInCuenta();
            }

        } else {
            System.out.println("La cuenta a la que intentas acceder no existe");
        }
        
    }
    //Administrar cuentas
    public static void EliminarCuentas() {
        int seleccion=RottenApp.SeleccionaCuenta();
        RottenApp.Usuarios.remove(seleccion);
        Menus.ImprimeMenu();
    }
    //Opcion de admin, adaptable al publico general, quitar seleccion cuenta
    public static void CambiarNombre(){
        int seleccion;
        if (RottenApp.Usuarios.get(RottenApp.UserIdLogged).isAdmin()) {
            seleccion = RottenApp.SeleccionaCuenta();
        } else {
            seleccion=RottenApp.UserIdLogged;
        }
        System.out.println("¿Que nombre te gustaria poner?");
        String NuevoNom= RottenApp.PideString();
        RottenApp.Usuarios.get(seleccion).setNombre(NuevoNom);
        Menus.ImprimeMenu();
    }
    public static void CambiarContra(){
        int seleccion;
        boolean Verificacion=false; 
        if (RottenApp.Usuarios.get(RottenApp.UserIdLogged).isAdmin()) {
            seleccion = RottenApp.SeleccionaCuenta();
            Verificacion=true; 
        } else {
            seleccion= RottenApp.UserIdLogged;  
            Verificacion=Comprobacio.VerificaContra();
            
        }
        if (Verificacion) {
            System.out.println("Que contraseña te gustaria poner?");
            String Contra= RottenApp.PideString();
            RottenApp.Usuarios.get(seleccion).setContraseña(Contra);
        }else{
            System.out.println("La contraseña que has introducido es incorrecta");
        }
        Menus.ImprimeMenu();
    }
    public static void LogOut() {
        System.out.println("Gracias por usar nuestra aplicacion");
        RottenApp.UserIdLogged=0; 
        Menus.MenuLogIn();

    }
    public static void BloquearUsuario(){
        int seleccion = RottenApp.SeleccionaCuenta();
        RottenApp.Usuarios.get(seleccion).setBloquedo(true);
        Menus.ImprimeMenu();
    }
    //Desbloquear usuaruis
    public static void DesbloquearUsuario() {
        VerBloqueados();
        //Selecciona la id de la cuenta que quieras bloquear
        System.out.println("Selecciona el id que desea desbloquear");
        int seleccion = RottenApp.PideInt();
        RottenApp.Usuarios.get(seleccion).setBloquedo(false);
        Menus.ImprimeMenu();
    }
    //Ver usuarios bloqueados
    public static void VerBloqueados(){
        boolean HayBloqueados= false; 
        for (int i = 0; i < RottenApp.Usuarios.size(); i++) {
            if (RottenApp.Usuarios.get(i).getBloqueado()) {
                System.out.println("ID: "+ RottenApp.Usuarios.get(i).getID() + ". " + RottenApp.Usuarios.get(i).getNombre());
                HayBloqueados=true;
            }
        }
        if (!HayBloqueados) {
            System.out.println("No hay cuentas bloqueadas");   
        }
    }
}
