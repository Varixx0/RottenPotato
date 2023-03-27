
public class Comprobacio {
    //Comprobaciones para la creacion de peliculas
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
            if (RottenApp.Usuarios.get(i).equals(Nombre)) {
                repetido=true;
            }
        }
        return repetido;
    }
    public static boolean ContraCoincide(String Contra1, String Contra2) {
        if (Contra1.equals(Contra2)) {
            return true;
        } else {
            return false;
        }
    }
}
