
public class Comprobacio {
    
    public boolean comprobarValoracion(int index){
        boolean bien = false;
        if (RottenApp.Peliculas.get(index).getValoracion() > 0 && RottenApp.Peliculas.get(index).getValoracion() <= 5 ) {
            bien = true;
        }
        return bien;
    }

    public boolean comprobarNombre(int index,String nombre){
        boolean bien = false;
        if (RottenApp.Peliculas.get(index).getNombre().toLowerCase().equals(nombre.toLowerCase())) {
            bien = false;
        }
        else{
            bien = true;
        }

        return bien;
    }

    public boolean comprobarDuracion(int index){
        boolean bien = false;
        if (RottenApp.Peliculas.get(index).getDuracion() >= 60) {
            bien = true;
        }
        return bien;
    }

    public boolean comprobarTodo(int index,String nombre){
        boolean bien = false;
        if (comprobarDuracion(index) && comprobarNombre(index, nombre) &&comprobarValoracion(index)){
            bien = true;
        }
        return bien;
    
    }
}
