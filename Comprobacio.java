
public class Comprobacio {
    //Comprobacio para la creacion de peliculas
    public static boolean comprobarValoracionPelicula(double valor){
        boolean bien = false;
        if (valor >= 0 || valor <= 5) {
            bien = true;
        }
        return bien;
    }
    public static boolean comprobarNombrePelicula(String nombre){
        boolean bien = false;
        for (int i = 0; i < RottenApp.Peliculas.size(); i++) { 
            if (RottenApp.Peliculas.get(i).getNombre().equals(nombre)) {
                bien = false;
                break;
            }
            else{
                bien = true;
            }   
        }
        return bien;
    }
    public static boolean comprobarDuracionPelicula(int duracion){
        boolean bien = false;
        if (duracion >= 60) {
            bien = true;
        }
        return bien;
    }
    public static boolean comprobarTodoPelicula(int duracion,String nombre,double valor){
        boolean bien = false;
        if (comprobarDuracionPelicula(duracion) && comprobarNombrePelicula(nombre) &&comprobarValoracionPelicula(valor)){
            bien = true;
        }
        return bien;
    
    }
    //Comprobacion para la creacion de Usuarios
    public static Boolean NombreRepetido(String Nombre) {
        boolean repetido = false; 
        for (int i = 0; i < RottenApp.Usuarios.size(); i++) {
            if (RottenApp.Usuarios.get(i).getNombre().equals(Nombre)) {
                repetido=true;
                break; 
            }
        }
        return repetido;
    }
    //Al crear la cuenta comprueba que las dos contraseñas coincidan, esto ayuda a evitar fallos ortograficos a la hora de leerlas
    public static boolean ContraCoincide(String Contra1, String Contra2) {
        if (Contra1.equals(Contra2)) {
            return true;
        } else {
            return false;
        }
    }
    //Busca un usuario en la array usuarios para ver si existe, esta funcion es necesaria para el log in
    public static int UsuarioExiste(String Username) {
        boolean encontrado = false; 
        int id=0; 
        for (int i = 0; i < RottenApp.Usuarios.size(); i++) {
            if (RottenApp.Usuarios.get(i).getNombre().equals(Username)) {
                encontrado=true;
                id = i;
                break;
            }
        }
        if (encontrado) {
            return id; 
        } else {
            return -1; 
        }
        
    }
    public static boolean ComparaConras(String Contra, int id) {
        if (RottenApp.Usuarios.get(id).getContraseña().equals(Contra)) {
            return true; 
        } else {
            return false; 
        }
    }
    public static boolean VerificaContra(){
        System.out.println("Por favor introduce tu contraseña actual: ");
        String Contra = RottenApp.PideString(); 
        return ComparaConras(Contra, RottenApp.UserIdLogged);
    }
}
