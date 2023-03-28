public class Usuarios {
    private String Nombre; 
    private String Contraseña;
    private boolean Admin;
    private int idCuenta;

    

    public Usuarios() {
    }

    public Usuarios(String Nom , String Con , Boolean Ad, int id) {
        this.Nombre=Nom;
        this.Contraseña=Con;
        this.Admin=Ad;
        this.idCuenta=id; 
    }
    public String getNombre() {
        return this.Nombre;
    }
    public void setNombre(String nombre) {
            Nombre = nombre;
    }
    public String getContraseña() {
        return Contraseña;
    }
    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }
    public boolean isAdmin() {
        return Admin;
    }
    public void setAdmin(boolean admin) {
        Admin = admin;
    } 


    
}
