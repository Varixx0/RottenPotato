public class Usuarios {
    private static String Nombre; 
    private static String Contraseña;
    private static boolean Admin;
    private static int idCuenta;

    

    public Usuarios() {
    }

    public Usuarios(String Nom , String Con , Boolean Ad, int id) {
        Nombre=Nom;
        Contraseña=Con;
        Admin=Ad;
        idCuenta=id; 
    }
    public String getNombre() {
        return this.Nombre;
    }
    public static void setNombre(String nombre) {
        Nombre = nombre;
    }
    public static String getContraseña() {
        return Contraseña;
    }
    public static void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }
    public static boolean isAdmin() {
        return Admin;
    }
    public static void setAdmin(boolean admin) {
        Admin = admin;
    } 


    
}
