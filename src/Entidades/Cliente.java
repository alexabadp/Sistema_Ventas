package Entidades;

public class Cliente {

    private int ruc;
    private String nombre;
    private int telefono;
    private String direccion;

    public Cliente() {
    }

    public Cliente(Integer ruc) {
        this.ruc = ruc;
    }

    public Cliente(Integer ruc, String nombre) {
        this.ruc = ruc;
        this.nombre = nombre;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
