
public class Comprobacio {
    
    public static boolean comprobarValoracion(int index){
        boolean bien = false;
        if (RottenApp.Peliculas.get(index).getValoracion() > 0 && RottenApp.Peliculas.get(index).getValoracion() <= 5 ) {
            bien = true;
        }
        return bien;
    }

    public static boolean comprobarNombre(String nombre){
        boolean bien = false;
        for (int i = 0; i < RottenApp.Peliculas.size(); i++) { 
            if (RottenApp.Peliculas.get(i).getNombre().equals(nombre)) {
                bien = false;
            }
            else{
                bien = true;
            }   
        }
        return bien;
    }

    public static boolean comprobarDuracion(int index){
        boolean bien = false;
        if (RottenApp.Peliculas.get(index).getDuracion() >= 60) {
            bien = true;
        }
        return bien;
    }

    public static boolean comprobarTodo(int index,String nombre){
        boolean bien = false;
        if (comprobarDuracion(index) && comprobarNombre(nombre) &&comprobarValoracion(index)){
            bien = true;
        }
        return bien;
    
    }
}
