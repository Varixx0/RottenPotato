
public class Comprobacio {
    
    public static boolean comprobarValoracion(double valor){
        boolean bien = false;
        if (valor >= 0 || valor <= 5) {
            bien = true;
        }
        return bien;
    }

    public static boolean comprobarNombre(String nombre){
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

    public static boolean comprobarDuracion(int duracion){
        boolean bien = false;
        if (duracion >= 60) {
            bien = true;
        }
        return bien;
    }

    public static boolean comprobarTodo(int duracion,String nombre,double valor){
        boolean bien = false;
        if (comprobarDuracion(duracion) && comprobarNombre(nombre) &&comprobarValoracion(valor)){
            bien = true;
        }
        return bien;
    
    }
}
