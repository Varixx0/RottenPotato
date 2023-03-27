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
}
