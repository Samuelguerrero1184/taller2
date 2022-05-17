package model;

public class User {

    private String identificacion;
    private String nombre;

    public User(){}

    public User(String identificacion){
        this.identificacion = identificacion;
    }

    public User(String identificacion, String nombre){
        this.identificacion = identificacion;
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}