package Entidades;

import java.util.Objects;

public class Proveedor {

    private int ruc;
    private String nombre;
    private int telefono;
    private String direccion;
    private String paginaWeb;

    public Proveedor() {
    }

    public Proveedor(int ruc) {
        this.ruc = ruc;
    }

    public Proveedor(int ruc, String nombre) {
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

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
